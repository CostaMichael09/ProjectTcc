import axios from 'axios';
import {IEmpresaVeiculoProcess} from "@/shared/model/empresa-veiculo-process.model";

// Define uma função para fazer o upload de um PDF associado a um EmpresaVeiculo

const baseUrl = '/api/arquivos';

export default class PdfService {
  public uploadPdf(empresaVeiculoId: number, file: File): Promise<any> {
    const formData = new FormData();
    formData.append('pdf', file);

    // Certifique-se de que a URL corresponda ao endpoint do servidor para o upload
    return axios.post(`/api/upload/pdf/${empresaVeiculoId}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
  }


  public downloadPdf(idArquivo: number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios.get(`/api/download/pdf/${idArquivo}`).then( res => {
        resolve(res);
      })
        .catch( err => {
          console.log("Error na API de download")
        })
    })
  }

  public async obterArquivosPorEmpresaVeiculoId(empresaVeiculoId: number): Promise<any> {
    return axios.get(`${baseUrl}/empresa-veiculo/pdf/${empresaVeiculoId}`);
  }

  public async excluirArquivo(arquivoId: number): Promise<any> {
    return axios.delete(`${baseUrl}/${arquivoId}`);
  }
}

