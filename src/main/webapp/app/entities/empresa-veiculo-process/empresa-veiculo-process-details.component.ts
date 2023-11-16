import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IEmpresaVeiculoProcess } from '@/shared/model/empresa-veiculo-process.model';
import EmpresaVeiculoProcessService from './empresa-veiculo-process.service';

@Component
export default class EmpresaVeiculoProcessDetailsComponent extends mixins(JhiDataUtils) {
  @Inject('empresaVeiculoProcessService') private empresaVeiculoProcessService: () => EmpresaVeiculoProcessService;
  public empresaVeiculoProcess: IEmpresaVeiculoProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveEmpresaVeiculoProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveEmpresaVeiculoProcess(empresaVeiculoProcessId) {
    this.isFetching = true;
    this.empresaVeiculoProcessService()
      .find(empresaVeiculoProcessId)
      .then(
        res => {
          this.empresaVeiculoProcess = res;
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
