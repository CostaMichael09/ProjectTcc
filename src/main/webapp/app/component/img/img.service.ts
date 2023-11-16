import axios from 'axios';
import { Arquivo, IArquivo } from '@/shared/model/arquivo.model';

const baseUrl = '/api/arquivos';

export default class ImgService {
  public uploadImg(empresaVeiculoId: number, file: File): Promise<any> {
    const formData = new FormData();
    formData.append('img', file);

    // Certifique-se de que a URL corresponda ao endpoint do servidor para o upload
    return axios.post(`/api/upload/img/${empresaVeiculoId}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
  }

  public downloadImg(idArquivo: number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(`/api/download/img/${idArquivo}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          console.log('Error na API de download de Imagem');
        });
    });
  }

  public obterArquivosImgPorEmpresaVeiculoIdSemSync(empresaVeiculoId: number): Promise<IArquivo[]> {
    return new Promise<IArquivo[]>((resolve, reject) => {
      axios
        .get(`${baseUrl}/empresa-veiculo/img/${empresaVeiculoId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public async obterArquivosImgPorEmpresaVeiculoId(empresaVeiculoId: number): Promise<any> {
    return axios.get(`${baseUrl}/empresa-veiculo/img/${empresaVeiculoId}`);
  }

  public async obterArquivosImgPorEmpresaVeiculoIds(empresaVeiculoId: number[]): Promise<any> {
    return axios.get(`${baseUrl}/empresa-veiculo/imgs/${empresaVeiculoId}`);
  }

  public async excluirArquivo(arquivoId: number): Promise<any> {
    return axios.delete(`${baseUrl}/${arquivoId}`);
  }
}
