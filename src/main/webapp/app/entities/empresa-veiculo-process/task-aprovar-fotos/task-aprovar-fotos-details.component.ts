import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import TaskAprovarFotosService from './task-aprovar-fotos.service';
import { TaskAprovarFotosContext } from './task-aprovar-fotos.model';

@Component
export default class TaskAprovarFotosDetailsComponent extends mixins(JhiDataUtils) {
  private taskAprovarFotosService: TaskAprovarFotosService = new TaskAprovarFotosService();
  private taskContext: TaskAprovarFotosContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskAprovarFotosService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
