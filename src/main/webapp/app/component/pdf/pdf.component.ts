import {Component, Prop, Vue} from 'vue-property-decorator';
import PdfService from "@/component/pdf/pdf.service";
import {EmpresaVeiculoProcess} from "@/shared/model/empresa-veiculo-process.model";
import {Arquivo} from "@/shared/model/arquivo.model";

@Component
export default class PdfComponent extends Vue {
  private showPdfModal: boolean = false;
  private empresaVeiculoId: number = 1;
  private selectedPdfFiles: Array<{ name: string; file: File }> = [];
  private pdfService: PdfService = new PdfService();
  private arquivos: Arquivo[] = [];

  @Prop() private empresaVeiculoProcess: EmpresaVeiculoProcess;
  @Prop() private view: Boolean;


  created(): void {
    this.carregarArquivos();
  }

  async carregarArquivos(): Promise<void> {
    try {
      const response = await this.pdfService.obterArquivosPorEmpresaVeiculoId(this.empresaVeiculoProcess.empresaVeiculo.id);
      this.arquivos = response.data;
    } catch (error) {
      console.error('Erro ao carregar arquivos', error);
    }
  }

  async deleteFile(arquivoId: number): Promise<void> {
    try {
      await this.pdfService.excluirArquivo(arquivoId);
      // Após a exclusão bem-sucedida, atualize a lista de arquivos
      await this.carregarArquivos();
    } catch (error) {
      console.error('Erro ao excluir arquivo', error);
    }
  }

  private handleFileUpload(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement.files && inputElement.files.length > 0) {
      for (let i = 0; i < inputElement.files.length; i++) {
        this.selectedPdfFiles.push({ name: inputElement.files[i].name, file: inputElement.files[i] });
      }
    }
  }

  private addFile() {
    const inputElement = this.$el.querySelector('#pdf-upload') as HTMLInputElement;
    if (inputElement) {
      inputElement.click();
    }
    this.carregarArquivos();
  }

  private async uploadPdf() {
    const promises = this.selectedPdfFiles.map(({name, file}) => {
      return this.pdfService.uploadPdf(this.empresaVeiculoProcess.empresaVeiculo.id, file)
        .then((response) => {
          // Lidar com a resposta do servidor, se necessário
          console.log(`Upload bem-sucedido para ${name}`, response);
        })
        .catch((error) => {
          // Lidar com erros, se necessário
          console.error(`Erro no upload para ${name}`, error);
        });
    });

    // Aguarde todas as promessas serem resolvidas antes de fazer algo após o envio
    Promise.all(promises)
      .then(async () => {
        this.selectedPdfFiles = [];
        await this.carregarArquivos()
        // Realize alguma ação após o envio de todos os arquivos, se necessário
        console.log("Todos os arquivos foram enviados com sucesso.");
      })
      .catch((error) => {
        // Lidar com erros gerais, se necessário
        console.error("Erro no envio de arquivos", error);
      });
  }

  private async downloadFile(arquivo: Arquivo): Promise<void> {
    this.downloadFilePdfOrImage(arquivo.type, arquivo.pdfs, arquivo.name);
  }

  public downloadFilePdfOrImage(contentType, data, fileName) {
    const byteCharacters = atob(data);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    const blob = new Blob([byteArray], {
      type: contentType,
    });
    const tempLink = document.createElement('a');
    tempLink.href = window.URL.createObjectURL(blob);
    tempLink.download = fileName;
    tempLink.target = '_blank';
    tempLink.click();
  }
}
