import axios from 'axios';
import { TaskRevisarAnuncioContext } from './task-revisar-anuncio.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-revisar-anuncio';

export default class TaskRevisarAnuncioService {
  public loadContext(taskId: number): Promise<TaskRevisarAnuncioContext> {
    return new Promise<TaskRevisarAnuncioContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskRevisarAnuncioContext> {
    return new Promise<TaskRevisarAnuncioContext>((resolve, reject) => {
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

  public complete(taskRevisarAnuncioContext: TaskRevisarAnuncioContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRevisarAnuncioContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
