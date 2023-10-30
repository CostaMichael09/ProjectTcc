import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskVerificarEstadoDoVeiculoService from './task-verificar-estado-do-veiculo.service';
import { TaskVerificarEstadoDoVeiculoContext } from './task-verificar-estado-do-veiculo.model';

@Component
export default class TaskVerificarEstadoDoVeiculoDetailsComponent extends Vue {
  private taskVerificarEstadoDoVeiculoService: TaskVerificarEstadoDoVeiculoService = new TaskVerificarEstadoDoVeiculoService();
  private taskContext: TaskVerificarEstadoDoVeiculoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskVerificarEstadoDoVeiculoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
