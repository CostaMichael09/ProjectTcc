import axios from 'axios';
import { EscolherVeiculoContext } from './escolher-veiculo.model';

const baseApiUrl = 'api/carro-process/escolher-veiculo';

export default class EscolherVeiculoService {
  public loadContext(taskId: number): Promise<EscolherVeiculoContext> {
    return new Promise<EscolherVeiculoContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<EscolherVeiculoContext> {
    return new Promise<EscolherVeiculoContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(escolherVeiculoContext: EscolherVeiculoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, escolherVeiculoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
