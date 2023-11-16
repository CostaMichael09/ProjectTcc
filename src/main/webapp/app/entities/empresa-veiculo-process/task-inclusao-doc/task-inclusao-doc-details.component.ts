import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskInclusaoDocService from './task-inclusao-doc.service';
import { TaskInclusaoDocContext } from './task-inclusao-doc.model';

@Component
export default class TaskInclusaoDocDetailsComponent extends Vue {
  private taskInclusaoDocService: TaskInclusaoDocService = new TaskInclusaoDocService();
  private taskContext: TaskInclusaoDocContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskInclusaoDocService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
