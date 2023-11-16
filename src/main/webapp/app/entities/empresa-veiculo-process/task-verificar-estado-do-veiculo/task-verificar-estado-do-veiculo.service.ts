import axios from 'axios';
import { TaskVerificarEstadoDoVeiculoContext } from './task-verificar-estado-do-veiculo.model';

const baseApiUrl = 'api/empresa-veiculo-process/task-verificar-estado-do-veiculo';

export default class TaskVerificarEstadoDoVeiculoService {
  public loadContext(taskId: number): Promise<TaskVerificarEstadoDoVeiculoContext> {
    return new Promise<TaskVerificarEstadoDoVeiculoContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskVerificarEstadoDoVeiculoContext> {
    return new Promise<TaskVerificarEstadoDoVeiculoContext>((resolve, reject) => {
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

  public complete(taskVerificarEstadoDoVeiculoContext: TaskVerificarEstadoDoVeiculoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskVerificarEstadoDoVeiculoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
