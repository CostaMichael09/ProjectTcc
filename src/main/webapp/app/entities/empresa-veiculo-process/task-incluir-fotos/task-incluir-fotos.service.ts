import axios from 'axios';
import { TaskIncluirFotosContext } from './task-incluir-fotos.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-incluir-fotos';

export default class TaskIncluirFotosService {
  public loadContext(taskId: number): Promise<TaskIncluirFotosContext> {
    return new Promise<TaskIncluirFotosContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskIncluirFotosContext> {
    return new Promise<TaskIncluirFotosContext>((resolve, reject) => {
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

  public complete(taskIncluirFotosContext: TaskIncluirFotosContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskIncluirFotosContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
