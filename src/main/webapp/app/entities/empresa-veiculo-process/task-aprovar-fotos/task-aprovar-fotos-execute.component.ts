import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import TaskAprovarFotosService from './task-aprovar-fotos.service';
import { TaskAprovarFotosContext } from './task-aprovar-fotos.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        fotos: {},
        aprovarFotos: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskAprovarFotosExecuteComponent extends mixins(JhiDataUtils) {
  private taskAprovarFotosService: TaskAprovarFotosService = new TaskAprovarFotosService();
  private taskContext: TaskAprovarFotosContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskAprovarFotosService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskAprovarFotosService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
