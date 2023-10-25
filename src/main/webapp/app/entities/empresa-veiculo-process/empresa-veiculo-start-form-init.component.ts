import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEmpresaVeiculoProcess, EmpresaVeiculoProcess } from '@/shared/model/empresa-veiculo-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { EmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';
import EmpresaVeiculoProcessService from './empresa-veiculo-process.service';

const validations: any = {
  empresaVeiculoProcess: {
    empresaVeiculo: {
      renavam: {},
      placa: {},
    },
  },
};

@Component({
  validations,
})
export default class EmpresaVeiculoStartFormInitComponent extends Vue {
  @Inject('empresaVeiculoProcessService') private empresaVeiculoProcessService: () => EmpresaVeiculoProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'EmpresaVeiculoProcess';
  public empresaVeiculoProcess: IEmpresaVeiculoProcess = new EmpresaVeiculoProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initEmpresaVeiculoStartForm();
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

    this.empresaVeiculoProcessService()
      .create(this.empresaVeiculoProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('newProjectApp.empresaVeiculoStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initEmpresaVeiculoStartForm(): void {
    this.empresaVeiculoProcess.empresaVeiculo = new EmpresaVeiculo();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.empresaVeiculoProcess.processInstance = new ProcessInstance();
      this.empresaVeiculoProcess.processInstance.processDefinition = res;
    });
  }
}
