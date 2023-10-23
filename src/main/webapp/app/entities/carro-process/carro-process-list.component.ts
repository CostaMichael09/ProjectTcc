import { Component, Vue, Inject } from 'vue-property-decorator';
import { ICarroProcess } from '@/shared/model/carro-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import CarroProcessService from './carro-process.service';

@Component
export default class CarroProcessListComponent extends Vue {
  @Inject('carroProcessService') private carroProcessService: () => CarroProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'CarroProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public carroProcessList: ICarroProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.carroProcessService()
      .retrieve()
      .then(
        res => {
          this.carroProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
