import { Component, Vue, Inject } from 'vue-property-decorator';

import PagamentoService from './pagamento.service';
import { PagamentoContext } from './pagamento.model';

const validations: any = {
  taskContext: {
    carroProcess: {
      carro: {
        nomeCliente: {},
        nomeVendedor: {},
        marcaCarro: {},
        anoCarro: {},
        modeloCarro: {},
        valorTotalCarro: {},
        formaPagamento: {},
        parcelas: {},
        entrada: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class PagamentoExecuteComponent extends Vue {
  private pagamentoService: PagamentoService = new PagamentoService();
  private taskContext: PagamentoContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.pagamentoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.pagamentoService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
