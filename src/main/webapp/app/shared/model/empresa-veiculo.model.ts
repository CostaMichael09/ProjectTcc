import {IArquivo} from "@/shared/model/arquivo.model";

export interface IEmpresaVeiculo {
  id?: number;
  renavam?: string | null;
  placa?: string | null;
  docRegular?: boolean | null;
  multa?: number | null;
  marca?: string | null;
  modelo?: string | null;
  anoFabricacao?: number | null;
  anoModelo?: number | null;
  cor?: string | null;
  estadoVeiculo?: boolean | null;
  obsEstadoVeiculo?: string | null;
  arquivos?: IArquivo[] | null; // Adiciona o campo arquivos
  aprovarFotos?: boolean | null;
  preco?: number | null;
  anuncioAprovado?: boolean | null;
}

export class EmpresaVeiculo implements IEmpresaVeiculo {
  constructor(
    public id?: number,
    public renavam?: string | null,
    public placa?: string | null,
    public docRegular?: boolean | null,
    public multa?: number | null,
    public marca?: string | null,
    public modelo?: string | null,
    public anoFabricacao?: number | null,
    public anoModelo?: number | null,
    public cor?: string | null,
    public estadoVeiculo?: boolean | null,
    public obsEstadoVeiculo?: string | null,
    public arquivos?: IArquivo[] | null, // Adiciona o campo arquivos
    public aprovarFotos?: boolean | null,
    public preco?: number | null,
    public anuncioAprovado?: boolean | null
  ) {
    this.docRegular = this.docRegular ?? false;
    this.estadoVeiculo = this.estadoVeiculo ?? false;
    this.aprovarFotos = this.aprovarFotos ?? false;
    this.anuncioAprovado = this.anuncioAprovado ?? false;
  }
}
