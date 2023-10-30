import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskVerificarEstadoDoVeiculoService from './task-verificar-estado-do-veiculo.service';
import { TaskVerificarEstadoDoVeiculoContext } from './task-verificar-estado-do-veiculo.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        estadoVeiculo: {},
        obsEstadoVeiculo: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskVerificarEstadoDoVeiculoExecuteComponent extends Vue {
  private taskVerificarEstadoDoVeiculoService: TaskVerificarEstadoDoVeiculoService = new TaskVerificarEstadoDoVeiculoService();
  private taskContext: TaskVerificarEstadoDoVeiculoContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskVerificarEstadoDoVeiculoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskVerificarEstadoDoVeiculoService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
