import { Component, Vue, Inject } from 'vue-property-decorator';

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

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
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
