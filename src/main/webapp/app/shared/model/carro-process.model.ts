import { ICarro } from '@/shared/model/carro.model';

export interface ICarroProcess {
  id?: number;
  processInstance?: any | null;
  carro?: ICarro | null;
}

export class CarroProcess implements ICarroProcess {
  constructor(public id?: number, public processInstance?: any | null, public carro?: ICarro | null) {}
}
