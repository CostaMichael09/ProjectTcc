import { Component, Vue, Inject } from 'vue-property-decorator';

import PagamentoService from './pagamento.service';
import { PagamentoContext } from './pagamento.model';

@Component
export default class PagamentoDetailsComponent extends Vue {
  private pagamentoService: PagamentoService = new PagamentoService();
  private taskContext: PagamentoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.pagamentoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
