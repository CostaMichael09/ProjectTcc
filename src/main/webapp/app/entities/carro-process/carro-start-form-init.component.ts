import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICarroProcess, CarroProcess } from '@/shared/model/carro-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Carro } from '@/shared/model/carro.model';
import CarroProcessService from './carro-process.service';
import router from "@/router";
import {data} from "autoprefixer";

const validations: any = {
  carroProcess: {
    carro: {
      nomeCliente: {},
      nomeVendedor: {},
      startDate: {},
      endDate: {},
    },
  },
};

@Component({
  validations,
})
export default class CarroStartFormInitComponent extends Vue {
  @Inject('carroProcessService') private carroProcessService: () => CarroProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'CarroProcess';
  public carroProcess: ICarroProcess = new CarroProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initCarroStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.carroProcessService()
      .create(this.carroProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('newProjectApp.carroStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });

    this.$router.push({
      name: 'CarroProcess_EscolherVeiculoExecute'
    })

  }

  public initCarroStartForm(): void {
    this.carroProcess.carro = new Carro();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.carroProcess.processInstance = new ProcessInstance();
      this.carroProcess.processInstance.processDefinition = res;
    });
  }
}
