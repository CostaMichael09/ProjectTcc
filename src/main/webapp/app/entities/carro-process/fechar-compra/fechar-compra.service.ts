import axios from 'axios';
import { FecharCompraContext } from './fechar-compra.model';

const baseApiUrl = 'api/carro-process/fechar-compra';

export default class FecharCompraService {
  public loadContext(taskId: number): Promise<FecharCompraContext> {
    return new Promise<FecharCompraContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<FecharCompraContext> {
    return new Promise<FecharCompraContext>((resolve, reject) => {
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

  public complete(fecharCompraContext: FecharCompraContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, fecharCompraContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
