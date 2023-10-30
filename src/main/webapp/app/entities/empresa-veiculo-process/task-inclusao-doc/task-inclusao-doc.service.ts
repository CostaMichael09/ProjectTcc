import axios from 'axios';
import { TaskInclusaoDocContext } from './task-inclusao-doc.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-inclusao-doc';

export default class TaskInclusaoDocService {
  public loadContext(taskId: number): Promise<TaskInclusaoDocContext> {
    return new Promise<TaskInclusaoDocContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskInclusaoDocContext> {
    return new Promise<TaskInclusaoDocContext>((resolve, reject) => {
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

  public complete(taskInclusaoDocContext: TaskInclusaoDocContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskInclusaoDocContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
