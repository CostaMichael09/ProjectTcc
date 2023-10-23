import { Component, Vue, Inject } from 'vue-property-decorator';

import EscolherVeiculoService from './escolher-veiculo.service';
import { EscolherVeiculoContext } from './escolher-veiculo.model';

const validations: any = {
  taskContext: {
    carroProcess: {
      carro: {
        nomeCliente: {},
        nomeVendedor: {},
        startDate: {},
        marcaCarro: {},
        anoCarro: {},
        modeloCarro: {},
        gnv: {},
        valorTotalCarro: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class EscolherVeiculoExecuteComponent extends Vue {
  private escolherVeiculoService: EscolherVeiculoService = new EscolherVeiculoService();
  private taskContext: EscolherVeiculoContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.escolherVeiculoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.escolherVeiculoService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
