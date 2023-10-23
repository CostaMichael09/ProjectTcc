import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICarroProcess } from '@/shared/model/carro-process.model';
import CarroProcessService from './carro-process.service';

@Component
export default class CarroProcessDetailsComponent extends Vue {
  @Inject('carroProcessService') private carroProcessService: () => CarroProcessService;
  public carroProcess: ICarroProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveCarroProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveCarroProcess(carroProcessId) {
    this.isFetching = true;
    this.carroProcessService()
      .find(carroProcessId)
      .then(
        res => {
          this.carroProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
