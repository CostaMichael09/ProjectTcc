package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.enumeration.FormaPagamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Carro} entity.
 */
public class CarroDTO implements Serializable {

    private Long id;

    private String nomeCliente;

    private String nomeVendedor;

    private LocalDate startDate;

    private LocalDate endDate;

    private String marcaCarro;

    private String anoCarro;

    private String modeloCarro;

    private FormaPagamento formaPagamento;

    private Boolean gnv;

    private BigDecimal valorTotalCarro;

    private BigDecimal entrada;

    private BigDecimal valorParcela;

    private Long parcelas;

    private BigDecimal juros;

    private String rua;

    private String bairro;

    private String cidade;

    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(String anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Boolean getGnv() {
        return gnv;
    }

    public void setGnv(Boolean gnv) {
        this.gnv = gnv;
    }

    public BigDecimal getValorTotalCarro() {
        return valorTotalCarro;
    }

    public void setValorTotalCarro(BigDecimal valorTotalCarro) {
        this.valorTotalCarro = valorTotalCarro;
    }

    public BigDecimal getEntrada() {
        return entrada;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Long getParcelas() {
        return parcelas;
    }

    public void setParcelas(Long parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarroDTO)) {
            return false;
        }

        CarroDTO carroDTO = (CarroDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, carroDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CarroDTO{" +
            "id=" + getId() +
            ", nomeCliente='" + getNomeCliente() + "'" +
            ", nomeVendedor='" + getNomeVendedor() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", marcaCarro='" + getMarcaCarro() + "'" +
            ", anoCarro='" + getAnoCarro() + "'" +
            ", modeloCarro='" + getModeloCarro() + "'" +
            ", formaPagamento='" + getFormaPagamento() + "'" +
            ", gnv='" + getGnv() + "'" +
            ", valorTotalCarro=" + getValorTotalCarro() +
            ", entrada=" + getEntrada() +
            ", valorParcela=" + getValorParcela() +
            ", parcelas=" + getParcelas() +
            ", juros=" + getJuros() +
            ", rua='" + getRua() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", cep='" + getCep() + "'" +
            "}";
    }
}
