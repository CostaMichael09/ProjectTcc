import { IEmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';

export interface IEmpresaVeiculoProcess {
  id?: number;
  processInstance?: any | null;
  empresaVeiculo?: IEmpresaVeiculo | null;
}

export class EmpresaVeiculoProcess implements IEmpresaVeiculoProcess {
  constructor(public id?: number, public processInstance?: any | null, public empresaVeiculo?: IEmpresaVeiculo | null) {}
}
