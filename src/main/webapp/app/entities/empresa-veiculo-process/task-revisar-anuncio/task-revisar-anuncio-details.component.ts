import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRevisarAnuncioService from './task-revisar-anuncio.service';
import { TaskRevisarAnuncioContext } from './task-revisar-anuncio.model';

@Component
export default class TaskRevisarAnuncioDetailsComponent extends Vue {
  private taskRevisarAnuncioService: TaskRevisarAnuncioService = new TaskRevisarAnuncioService();
  private taskContext: TaskRevisarAnuncioContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRevisarAnuncioService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
