import axios from 'axios';

import { IEmpresaVeiculoProcess } from '@/shared/model/empresa-veiculo-process.model';

const baseApiUrl = 'api/empresa-veiculo-processes';

export default class EmpresaVeiculoProcessService {
  public find(id: number): Promise<IEmpresaVeiculoProcess> {
    return new Promise<IEmpresaVeiculoProcess>((resolve, reject) => {
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

  public retrieveAnuncioTrue(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/anuncios-aprovado`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IEmpresaVeiculoProcess): Promise<IEmpresaVeiculoProcess> {
    return new Promise<IEmpresaVeiculoProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
