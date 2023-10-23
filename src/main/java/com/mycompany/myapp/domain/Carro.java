package com.mycompany.myapp.domain;

import com.mycompany.myapp.domain.enumeration.FormaPagamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Carro.
 */
@Entity
@Table(name = "carro")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "nome_vendedor")
    private String nomeVendedor;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "marca_carro")
    private String marcaCarro;

    @Column(name = "ano_carro")
    private String anoCarro;

    @Column(name = "modelo_carro")
    private String modeloCarro;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private FormaPagamento formaPagamento;

    @Column(name = "gnv")
    private Boolean gnv;

    @Column(name = "valor_total_carro", precision = 21, scale = 2)
    private BigDecimal valorTotalCarro;

    @Column(name = "entrada", precision = 21, scale = 2)
    private BigDecimal entrada;

    @Column(name = "valor_parcela", precision = 21, scale = 2)
    private BigDecimal valorParcela;

    @Column(name = "parcelas")
    private Long parcelas;

    @Column(name = "juros", precision = 21, scale = 2)
    private BigDecimal juros;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carro id(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public Carro nomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        return this;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return this.nomeVendedor;
    }

    public Carro nomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
        return this;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public Carro startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Carro endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMarcaCarro() {
        return this.marcaCarro;
    }

    public Carro marcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
        return this;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getAnoCarro() {
        return this.anoCarro;
    }

    public Carro anoCarro(String anoCarro) {
        this.anoCarro = anoCarro;
        return this;
    }

    public void setAnoCarro(String anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getModeloCarro() {
        return this.modeloCarro;
    }

    public Carro modeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
        return this;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public Carro formaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Boolean getGnv() {
        return this.gnv;
    }

    public Carro gnv(Boolean gnv) {
        this.gnv = gnv;
        return this;
    }

    public void setGnv(Boolean gnv) {
        this.gnv = gnv;
    }

    public BigDecimal getValorTotalCarro() {
        return this.valorTotalCarro;
    }

    public Carro valorTotalCarro(BigDecimal valorTotalCarro) {
        this.valorTotalCarro = valorTotalCarro;
        return this;
    }

    public void setValorTotalCarro(BigDecimal valorTotalCarro) {
        this.valorTotalCarro = valorTotalCarro;
    }

    public BigDecimal getEntrada() {
        return this.entrada;
    }

    public Carro entrada(BigDecimal entrada) {
        this.entrada = entrada;
        return this;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public BigDecimal getValorParcela() {
        return this.valorParcela;
    }

    public Carro valorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
        return this;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Long getParcelas() {
        return this.parcelas;
    }

    public Carro parcelas(Long parcelas) {
        this.parcelas = parcelas;
        return this;
    }

    public void setParcelas(Long parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getJuros() {
        return this.juros;
    }

    public Carro juros(BigDecimal juros) {
        this.juros = juros;
        return this;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public String getRua() {
        return this.rua;
    }

    public Carro rua(String rua) {
        this.rua = rua;
        return this;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public Carro bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public Carro cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return this.cep;
    }

    public Carro cep(String cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Carro)) {
            return false;
        }
        return id != null && id.equals(((Carro) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Carro{" +
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
