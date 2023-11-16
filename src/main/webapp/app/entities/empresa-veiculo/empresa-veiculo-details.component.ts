import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IEmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';
import EmpresaVeiculoService from './empresa-veiculo.service';

@Component
export default class EmpresaVeiculoDetails extends mixins(JhiDataUtils) {
  @Inject('empresaVeiculoService') private empresaVeiculoService: () => EmpresaVeiculoService;
  public empresaVeiculo: IEmpresaVeiculo = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.empresaVeiculoId) {
        vm.retrieveEmpresaVeiculo(to.params.empresaVeiculoId);
      }
    });
  }

  public retrieveEmpresaVeiculo(empresaVeiculoId) {
    this.empresaVeiculoService()
      .find(empresaVeiculoId)
      .then(res => {
        this.empresaVeiculo = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
