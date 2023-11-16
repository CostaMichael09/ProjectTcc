import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegularizarVeiculoService from './task-regularizar-veiculo.service';
import { TaskRegularizarVeiculoContext } from './task-regularizar-veiculo.model';

@Component
export default class TaskRegularizarVeiculoDetailsComponent extends Vue {
  private taskRegularizarVeiculoService: TaskRegularizarVeiculoService = new TaskRegularizarVeiculoService();
  private taskContext: TaskRegularizarVeiculoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRegularizarVeiculoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
