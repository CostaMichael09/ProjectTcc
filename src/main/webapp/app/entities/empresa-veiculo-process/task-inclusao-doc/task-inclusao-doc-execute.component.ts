import {Component, Vue, Inject, Watch} from 'vue-property-decorator';

import TaskInclusaoDocService from './task-inclusao-doc.service';
import { TaskInclusaoDocContext } from './task-inclusao-doc.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        renavam: {},
        placa: {},
        docRegular: {},
        multa: {},
        marca: {},
        modelo: {},
        anoFabricacao: {},
        anoModelo: {},
        cor: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskInclusaoDocExecuteComponent extends Vue {
  private taskInclusaoDocService: TaskInclusaoDocService = new TaskInclusaoDocService();
  private taskContext: TaskInclusaoDocContext = {};
  public isSaving = false;
// Adicione a propriedade availableYears com as opções iniciais vazias
  public availableYears: number[] = [];

  // Método para atualizar as opções do campo "Ano Modelo"
  @Watch('taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao')
  private updateAvailableYears(): void {
    const fabricacaoYear = this.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao;
    if (fabricacaoYear) {
      // Atualize availableYears com base no ano de fabricação e o ano seguinte
      this.availableYears = [fabricacaoYear, fabricacaoYear + 1];
    } else {
      this.availableYears = []; // Limpe as opções se o campo "Ano Fabricação" estiver vazio
    }
  }

// Método chamado quando o campo "Ano Fabricação" muda
  public onAnoFabricacaoChange(): void {
    this.updateAvailableYears();
  }

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskInclusaoDocService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskInclusaoDocService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
