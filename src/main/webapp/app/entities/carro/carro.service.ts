import axios from 'axios';

import { ICarro } from '@/shared/model/carro.model';

const baseApiUrl = 'api/carros';

export default class CarroService {
  public find(id: number): Promise<ICarro> {
    return new Promise<ICarro>((resolve, reject) => {
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
