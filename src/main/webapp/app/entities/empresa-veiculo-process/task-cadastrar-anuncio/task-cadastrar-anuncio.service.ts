import axios from 'axios';
import { TaskCadastrarAnuncioContext } from './task-cadastrar-anuncio.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-cadastrar-anuncio';

export default class TaskCadastrarAnuncioService {
  public loadContext(taskId: number): Promise<TaskCadastrarAnuncioContext> {
    return new Promise<TaskCadastrarAnuncioContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskCadastrarAnuncioContext> {
    return new Promise<TaskCadastrarAnuncioContext>((resolve, reject) => {
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

  public complete(taskCadastrarAnuncioContext: TaskCadastrarAnuncioContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskCadastrarAnuncioContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
