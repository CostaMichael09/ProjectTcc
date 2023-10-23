import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICarro } from '@/shared/model/carro.model';

import CarroService from './carro.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Carro extends Vue {
  @Inject('carroService') private carroService: () => CarroService;
  private removeId: number = null;

  public carros: ICarro[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCarros();
  }

  public clear(): void {
    this.retrieveAllCarros();
  }

  public retrieveAllCarros(): void {
    this.isFetching = true;

    this.carroService()
      .retrieve()
      .then(
        res => {
          this.carros = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
