import { Component, Vue, Inject } from 'vue-property-decorator';

import FecharCompraService from './fechar-compra.service';
import { FecharCompraContext } from './fechar-compra.model';

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
        entrada: {},
        parcelas: {},
        valorParcela: {},
        juros: {},
        rua: {},
        bairro: {},
        cidade: {},
        cep: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class FecharCompraExecuteComponent extends Vue {
  private fecharCompraService: FecharCompraService = new FecharCompraService();
  private taskContext: FecharCompraContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.fecharCompraService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.fecharCompraService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
