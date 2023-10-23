import { Component, Vue, Inject } from 'vue-property-decorator';

import EscolherVeiculoService from './escolher-veiculo.service';
import { EscolherVeiculoContext } from './escolher-veiculo.model';

@Component
export default class EscolherVeiculoDetailsComponent extends Vue {
  private escolherVeiculoService: EscolherVeiculoService = new EscolherVeiculoService();
  private taskContext: EscolherVeiculoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.escolherVeiculoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
