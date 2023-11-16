import Component from 'vue-class-component';
import { Inject, Vue, Watch } from 'vue-property-decorator';
import LoginService from '@/account/login.service';
import ImgService from '@/component/img/img.service';
import EmpresaVeiculoService from '@/entities/empresa-veiculo/empresa-veiculo.service';
import { EmpresaVeiculo, IEmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';
import { Arquivo, IArquivo } from '@/shared/model/arquivo.model';
import EmpresaVeiculoProcessService from '@/entities/empresa-veiculo-process/empresa-veiculo-process.service';
import { EmpresaVeiculoProcess } from '@/shared/model/empresa-veiculo-process.model';

@Component
export default class Home extends Vue {
  @Inject('loginService')
  private loginService: () => LoginService;
  private imgService: ImgService = new ImgService();
  @Inject('empresaVeiculoService')
  private empresaVeiculoService: () => EmpresaVeiculoService;
  @Inject('empresaVeiculoProcessService') private empresaVeiculoProcessService: () => EmpresaVeiculoProcessService;

  public empresaVeiculos: EmpresaVeiculoProcess[] = [];
  private arquivos: IArquivo[] = [];
  private empresaIds: number[] = [];

  public created(): void {
    if (this.authenticated) {
      this.retrieveAllByAnuncioAprovado();
    }
  }

  @Watch('$store.getters.authenticated')
  public retrieveAllByAnuncioAprovado(): void {
    if (this.$store.getters.authenticated) {
      this.empresaVeiculoProcessService()
        .retrieveAnuncioTrue()
        .then(res => {
          this.empresaVeiculos = res.data;
          this.empresaVeiculos.forEach(res => {
            this.carregarArquivos(res);
          });
        });
    } else {
      this.empresaVeiculos = [];
    }
  }

  async carregarArquivos(res: EmpresaVeiculoProcess): Promise<void> {
    try {
      const response = await this.imgService.obterArquivosImgPorEmpresaVeiculoId(res.empresaVeiculo.id);
      this.arquivos.push(response.data);
      // @ts-ignore
      res.empresaVeiculo.totalPhotos = response.data.length;
      // @ts-ignore
      res.empresaVeiculo.currentPhotoIndex = 0;
    } catch (error) {
      console.error('Erro ao carregar arquivos', error);
    }
  }

  public nextPhoto(veiculo: EmpresaVeiculo): void {
    // @ts-ignore
    if (veiculo.totalPhotos > 1) {
      // @ts-ignore
      veiculo.currentPhotoIndex = (veiculo.currentPhotoIndex + 1) % veiculo.totalPhotos;
    }
    this.$forceUpdate();
  }

  public prevPhoto(veiculo: EmpresaVeiculo): void {
    // @ts-ignore
    if (veiculo.totalPhotos > 1) {
      // @ts-ignore
      veiculo.currentPhotoIndex = (veiculo.currentPhotoIndex - 1 + veiculo.totalPhotos) % veiculo.totalPhotos;
    }
    this.$forceUpdate();
  }

  public openLogin(): void {
    this.loginService().openLogin((<any>this).$root);
  }

  public get authenticated(): boolean {
    return this.$store.getters.authenticated;
  }

  public get username(): string {
    return this.$store.getters.account ? this.$store.getters.account.login : '';
  }
}
