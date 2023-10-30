import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import TaskIncluirFotosService from './task-incluir-fotos.service';
import { TaskIncluirFotosContext } from './task-incluir-fotos.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        fotos: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskIncluirFotosExecuteComponent extends mixins(JhiDataUtils) {
  private taskIncluirFotosService: TaskIncluirFotosService = new TaskIncluirFotosService();
  private taskContext: TaskIncluirFotosContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskIncluirFotosService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskIncluirFotosService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
