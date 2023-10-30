import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import TaskIncluirFotosService from './task-incluir-fotos.service';
import { TaskIncluirFotosContext } from './task-incluir-fotos.model';

@Component
export default class TaskIncluirFotosDetailsComponent extends mixins(JhiDataUtils) {
  private taskIncluirFotosService: TaskIncluirFotosService = new TaskIncluirFotosService();
  private taskContext: TaskIncluirFotosContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskIncluirFotosService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
