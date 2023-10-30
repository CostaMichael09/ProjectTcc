import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegularizarVeiculoService from './task-regularizar-veiculo.service';
import { TaskRegularizarVeiculoContext } from './task-regularizar-veiculo.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        renavam: {},
        placa: {},
        docRegular: {},
        multa: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRegularizarVeiculoExecuteComponent extends Vue {
  private taskRegularizarVeiculoService: TaskRegularizarVeiculoService = new TaskRegularizarVeiculoService();
  private taskContext: TaskRegularizarVeiculoContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRegularizarVeiculoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRegularizarVeiculoService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
