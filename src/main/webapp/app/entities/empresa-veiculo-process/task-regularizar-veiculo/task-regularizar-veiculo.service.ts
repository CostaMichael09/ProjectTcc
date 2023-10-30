import axios from 'axios';
import { TaskRegularizarVeiculoContext } from './task-regularizar-veiculo.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-regularizar-veiculo';

export default class TaskRegularizarVeiculoService {
  public loadContext(taskId: number): Promise<TaskRegularizarVeiculoContext> {
    return new Promise<TaskRegularizarVeiculoContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskRegularizarVeiculoContext> {
    return new Promise<TaskRegularizarVeiculoContext>((resolve, reject) => {
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

  public complete(taskRegularizarVeiculoContext: TaskRegularizarVeiculoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRegularizarVeiculoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
