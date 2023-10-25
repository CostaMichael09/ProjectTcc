import { Component, Vue, Inject } from 'vue-property-decorator';
import { IEmpresaVeiculoProcess } from '@/shared/model/empresa-veiculo-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import EmpresaVeiculoProcessService from './empresa-veiculo-process.service';

@Component
export default class EmpresaVeiculoProcessListComponent extends Vue {
  @Inject('empresaVeiculoProcessService') private empresaVeiculoProcessService: () => EmpresaVeiculoProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'EmpresaVeiculoProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public empresaVeiculoProcessList: IEmpresaVeiculoProcess[] = [];

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
    this.empresaVeiculoProcessService()
      .retrieve()
      .then(
        res => {
          this.empresaVeiculoProcessList = res.data;
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
