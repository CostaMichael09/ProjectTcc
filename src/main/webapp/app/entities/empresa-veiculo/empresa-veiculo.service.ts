import axios from 'axios';

import { IEmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';

const baseApiUrl = 'api/empresa-veiculos';

export default class EmpresaVeiculoService {
  public find(id: number): Promise<IEmpresaVeiculo> {
    return new Promise<IEmpresaVeiculo>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
