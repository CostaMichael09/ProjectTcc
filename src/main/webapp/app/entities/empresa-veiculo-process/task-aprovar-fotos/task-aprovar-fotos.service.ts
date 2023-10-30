import axios from 'axios';
import { TaskAprovarFotosContext } from './task-aprovar-fotos.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-aprovar-fotos';

export default class TaskAprovarFotosService {
  public loadContext(taskId: number): Promise<TaskAprovarFotosContext> {
    return new Promise<TaskAprovarFotosContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskAprovarFotosContext> {
    return new Promise<TaskAprovarFotosContext>((resolve, reject) => {
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

  public complete(taskAprovarFotosContext: TaskAprovarFotosContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskAprovarFotosContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
