import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskInclusaoDocService from './task-inclusao-doc.service';
import { TaskInclusaoDocContext } from './task-inclusao-doc.model';

const validations: any = {
  taskContext: {
    empresaVeiculoProcess: {
      empresaVeiculo: {
        renavam: {},
        placa: {},
        docRegular: {},
        multa: {},
        marca: {},
        modelo: {},
        anoFabricacao: {},
        anoModelo: {},
        cor: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskInclusaoDocExecuteComponent extends Vue {
  private taskInclusaoDocService: TaskInclusaoDocService = new TaskInclusaoDocService();
  private taskContext: TaskInclusaoDocContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskInclusaoDocService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskInclusaoDocService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
