package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * A EmpresaVeiculo.
 */
@Entity
@Table(name = "empresa_veiculo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmpresaVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "renavam")
    private String renavam;

    @Column(name = "placa")
    private String placa;

    @Column(name = "doc_regular")
    private Boolean docRegular;

    @Column(name = "multa", precision = 21, scale = 2)
    private BigDecimal multa;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano_fabricacao")
    private Long anoFabricacao;

    @Column(name = "ano_modelo")
    private Long anoModelo;

    @Column(name = "cor")
    private String cor;

    @Column(name = "estado_veiculo")
    private Boolean estadoVeiculo;

    @Column(name = "obs_estado_veiculo")
    private String obsEstadoVeiculo;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "fotos")
    private String fotos;

    @Column(name = "aprovar_fotos")
    private Boolean aprovarFotos;

    @Column(name = "preco", precision = 21, scale = 2)
    private BigDecimal preco;

    @Column(name = "anuncio_aprovado")
    private Boolean anuncioAprovado;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaVeiculo id(Long id) {
        this.id = id;
        return this;
    }

    public String getRenavam() {
        return this.renavam;
    }

    public EmpresaVeiculo renavam(String renavam) {
        this.renavam = renavam;
        return this;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getPlaca() {
        return this.placa;
    }

    public EmpresaVeiculo placa(String placa) {
        this.placa = placa;
        return this;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getDocRegular() {
        return this.docRegular;
    }

    public EmpresaVeiculo docRegular(Boolean docRegular) {
        this.docRegular = docRegular;
        return this;
    }

    public void setDocRegular(Boolean docRegular) {
        this.docRegular = docRegular;
    }

    public BigDecimal getMulta() {
        return this.multa;
    }

    public EmpresaVeiculo multa(BigDecimal multa) {
        this.multa = multa;
        return this;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public String getMarca() {
        return this.marca;
    }

    public EmpresaVeiculo marca(String marca) {
        this.marca = marca;
        return this;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public EmpresaVeiculo modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public EmpresaVeiculo anoFabricacao(Long anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
        return this;
    }

    public void setAnoFabricacao(Long anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Long getAnoModelo() {
        return this.anoModelo;
    }

    public EmpresaVeiculo anoModelo(Long anoModelo) {
        this.anoModelo = anoModelo;
        return this;
    }

    public void setAnoModelo(Long anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return this.cor;
    }

    public EmpresaVeiculo cor(String cor) {
        this.cor = cor;
        return this;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getEstadoVeiculo() {
        return this.estadoVeiculo;
    }

    public EmpresaVeiculo estadoVeiculo(Boolean estadoVeiculo) {
        this.estadoVeiculo = estadoVeiculo;
        return this;
    }

    public void setEstadoVeiculo(Boolean estadoVeiculo) {
        this.estadoVeiculo = estadoVeiculo;
    }

    public String getObsEstadoVeiculo() {
        return this.obsEstadoVeiculo;
    }

    public EmpresaVeiculo obsEstadoVeiculo(String obsEstadoVeiculo) {
        this.obsEstadoVeiculo = obsEstadoVeiculo;
        return this;
    }

    public void setObsEstadoVeiculo(String obsEstadoVeiculo) {
        this.obsEstadoVeiculo = obsEstadoVeiculo;
    }

    public String getFotos() {
        return this.fotos;
    }

    public EmpresaVeiculo fotos(String fotos) {
        this.fotos = fotos;
        return this;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Boolean getAprovarFotos() {
        return this.aprovarFotos;
    }

    public EmpresaVeiculo aprovarFotos(Boolean aprovarFotos) {
        this.aprovarFotos = aprovarFotos;
        return this;
    }

    public void setAprovarFotos(Boolean aprovarFotos) {
        this.aprovarFotos = aprovarFotos;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public EmpresaVeiculo preco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getAnuncioAprovado() {
        return this.anuncioAprovado;
    }

    public EmpresaVeiculo anuncioAprovado(Boolean anuncioAprovado) {
        this.anuncioAprovado = anuncioAprovado;
        return this;
    }

    public void setAnuncioAprovado(Boolean anuncioAprovado) {
        this.anuncioAprovado = anuncioAprovado;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaVeiculo)) {
            return false;
        }
        return id != null && id.equals(((EmpresaVeiculo) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaVeiculo{" +
            "id=" + getId() +
            ", renavam='" + getRenavam() + "'" +
            ", placa='" + getPlaca() + "'" +
            ", docRegular='" + getDocRegular() + "'" +
            ", multa=" + getMulta() +
            ", marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", anoFabricacao=" + getAnoFabricacao() +
            ", anoModelo=" + getAnoModelo() +
            ", cor='" + getCor() + "'" +
            ", estadoVeiculo='" + getEstadoVeiculo() + "'" +
            ", obsEstadoVeiculo='" + getObsEstadoVeiculo() + "'" +
            ", fotos='" + getFotos() + "'" +
            ", aprovarFotos='" + getAprovarFotos() + "'" +
            ", preco=" + getPreco() +
            ", anuncioAprovado='" + getAnuncioAprovado() + "'" +
            "}";
    }
}
