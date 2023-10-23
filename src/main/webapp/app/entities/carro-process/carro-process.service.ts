import axios from 'axios';

import { ICarroProcess } from '@/shared/model/carro-process.model';

const baseApiUrl = 'api/carro-processes';

export default class CarroProcessService {
  public find(id: number): Promise<ICarroProcess> {
    return new Promise<ICarroProcess>((resolve, reject) => {
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

  public create(entity: ICarroProcess): Promise<ICarroProcess> {
    return new Promise<ICarroProcess>((resolve, reject) => {
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
