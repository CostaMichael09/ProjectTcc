import { Component, Vue, Inject } from 'vue-property-decorator';

import FecharCompraService from './fechar-compra.service';
import { FecharCompraContext } from './fechar-compra.model';

@Component
export default class FecharCompraDetailsComponent extends Vue {
  private fecharCompraService: FecharCompraService = new FecharCompraService();
  private taskContext: FecharCompraContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.fecharCompraService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
