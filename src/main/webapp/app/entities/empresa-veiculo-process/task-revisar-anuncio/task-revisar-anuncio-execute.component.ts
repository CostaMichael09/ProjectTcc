import {Component, Vue, Inject, Watch} from 'vue-property-decorator';

import TaskRevisarAnuncioService from './task-revisar-anuncio.service';
import { TaskRevisarAnuncioContext } from './task-revisar-anuncio.model';

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
        preco: {},
        anuncioAprovado: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRevisarAnuncioExecuteComponent extends Vue {
  private taskRevisarAnuncioService: TaskRevisarAnuncioService = new TaskRevisarAnuncioService();
  private taskContext: TaskRevisarAnuncioContext = {};
  public isSaving = false;
  public showReanuncio = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRevisarAnuncioService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRevisarAnuncioService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

 public teste() {
   console.log(this.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado);
   this.$forceUpdate();
   this.showReanuncio = this.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado;

   this.$nextTick(() => {
     this.$forceUpdate();
   });
 }

  get isAnuncioNaoAprovado(): boolean {
    return !this.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado;
  }
  public initRelationships(): void {}
}
