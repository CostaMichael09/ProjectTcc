import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICarro } from '@/shared/model/carro.model';
import CarroService from './carro.service';

@Component
export default class CarroDetails extends Vue {
  @Inject('carroService') private carroService: () => CarroService;
  public carro: ICarro = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.carroId) {
        vm.retrieveCarro(to.params.carroId);
      }
    });
  }

  public retrieveCarro(carroId) {
    this.carroService()
      .find(carroId)
      .then(res => {
        this.carro = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
