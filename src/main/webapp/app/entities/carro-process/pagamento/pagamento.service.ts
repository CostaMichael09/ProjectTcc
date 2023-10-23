import axios from 'axios';
import { PagamentoContext } from './pagamento.model';

const baseApiUrl = 'api/carro-process/pagamento';

export default class PagamentoService {
  public loadContext(taskId: number): Promise<PagamentoContext> {
    return new Promise<PagamentoContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<PagamentoContext> {
    return new Promise<PagamentoContext>((resolve, reject) => {
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

  public complete(pagamentoContext: PagamentoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, pagamentoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
