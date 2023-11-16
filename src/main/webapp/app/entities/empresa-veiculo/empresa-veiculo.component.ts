import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import EmpresaVeiculoService from './empresa-veiculo.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EmpresaVeiculo extends mixins(JhiDataUtils) {
  @Inject('empresaVeiculoService') private empresaVeiculoService: () => EmpresaVeiculoService;
  private removeId: number = null;

  public empresaVeiculos: IEmpresaVeiculo[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEmpresaVeiculos();
  }

  public clear(): void {
    this.retrieveAllEmpresaVeiculos();
  }

  public retrieveAllEmpresaVeiculos(): void {
    this.isFetching = true;

    this.empresaVeiculoService()
      .retrieve()
      .then(
        res => {
          this.empresaVeiculos = res.data;
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
