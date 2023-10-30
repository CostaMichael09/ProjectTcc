import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCadastrarAnuncioService from './task-cadastrar-anuncio.service';
import { TaskCadastrarAnuncioContext } from './task-cadastrar-anuncio.model';

@Component
export default class TaskCadastrarAnuncioDetailsComponent extends Vue {
  private taskCadastrarAnuncioService: TaskCadastrarAnuncioService = new TaskCadastrarAnuncioService();
  private taskContext: TaskCadastrarAnuncioContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskCadastrarAnuncioService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
