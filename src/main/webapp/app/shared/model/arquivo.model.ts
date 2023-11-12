export interface IArquivo {
  id?: number;
  name?: string | null;
  status?: string | null;
  type?: string | null;
  uploadedDate?: Date | null;
  uploadedBy?: string | null;
  pdfs?: Blob | null;
  fotos?: Blob | null;
  empresaVeiculoId?: number | null;
}

export class Arquivo implements IArquivo {
  constructor(
    public id?: number,
    public name?: string | null,
    public status?: string | null,
    public type?: string | null,
    public uploadedDate?: Date | null,
    public uploadedBy?: string | null,
    public pdfs?: Blob | null,
    public fotos?: Blob | null,
    public empresaVeiculoId?: number | null
  ) {}
}
