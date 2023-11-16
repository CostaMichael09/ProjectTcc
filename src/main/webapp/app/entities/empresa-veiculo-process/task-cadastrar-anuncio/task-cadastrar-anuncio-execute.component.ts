import {Component, Vue, Inject, Watch} from 'vue-property-decorator';

import TaskCadastrarAnuncioService from './task-cadastrar-anuncio.service';
import { TaskCadastrarAnuncioContext } from './task-cadastrar-anuncio.model';

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
        preco: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskCadastrarAnuncioExecuteComponent extends Vue {
  private taskCadastrarAnuncioService: TaskCadastrarAnuncioService = new TaskCadastrarAnuncioService();
  private taskContext: TaskCadastrarAnuncioContext = {};
  public isSaving = false;
  // Adicione a propriedade availableYears com as opções iniciais vazias
  public availableYears: number[] = [];
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }


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
  public claimTaskInstance(taskInstanceId) {
    this.taskCadastrarAnuncioService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskCadastrarAnuncioService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
