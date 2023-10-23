import { FormaPagamento } from '@/shared/model/enumerations/forma-pagamento.model';
export interface ICarro {
  id?: number;
  nomeCliente?: string | null;
  nomeVendedor?: string | null;
  startDate?: Date | null;
  endDate?: Date | null;
  marcaCarro?: string | null;
  anoCarro?: string | null;
  modeloCarro?: string | null;
  formaPagamento?: FormaPagamento | null;
  gnv?: boolean | null;
  valorTotalCarro?: number | null;
  entrada?: number | null;
  valorParcela?: number | null;
  parcelas?: number | null;
  juros?: number | null;
  rua?: string | null;
  bairro?: string | null;
  cidade?: string | null;
  cep?: string | null;
}

export class Carro implements ICarro {
  constructor(
    public id?: number,
    public nomeCliente?: string | null,
    public nomeVendedor?: string | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public marcaCarro?: string | null,
    public anoCarro?: string | null,
    public modeloCarro?: string | null,
    public formaPagamento?: FormaPagamento | null,
    public gnv?: boolean | null,
    public valorTotalCarro?: number | null,
    public entrada?: number | null,
    public valorParcela?: number | null,
    public parcelas?: number | null,
    public juros?: number | null,
    public rua?: string | null,
    public bairro?: string | null,
    public cidade?: string | null,
    public cep?: string | null
  ) {
    this.gnv = this.gnv ?? false;
  }
}
