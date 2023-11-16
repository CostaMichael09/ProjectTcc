package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.Arquivos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.EmpresaVeiculo} entity.
 */
public class EmpresaVeiculoDTO implements Serializable {

    private Long id;

    private String renavam;

    private String placa;

    private Boolean docRegular;

    private BigDecimal multa;

    private String marca;

    private String modelo;

    private Long anoFabricacao;

    private Long anoModelo;

    private String cor;

    private Boolean estadoVeiculo;

    private String obsEstadoVeiculo;

    private Boolean aprovarFotos;

    private BigDecimal preco;

    private Boolean anuncioAprovado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getDocRegular() {
        return docRegular;
    }

    public void setDocRegular(Boolean docRegular) {
        this.docRegular = docRegular;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Long anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Long getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Long anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getEstadoVeiculo() {
        return estadoVeiculo;
    }

    public void setEstadoVeiculo(Boolean estadoVeiculo) {
        this.estadoVeiculo = estadoVeiculo;
    }

    public String getObsEstadoVeiculo() {
        return obsEstadoVeiculo;
    }

    public void setObsEstadoVeiculo(String obsEstadoVeiculo) {
        this.obsEstadoVeiculo = obsEstadoVeiculo;
    }

    public Boolean getAprovarFotos() {
        return aprovarFotos;
    }

    public void setAprovarFotos(Boolean aprovarFotos) {
        this.aprovarFotos = aprovarFotos;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getAnuncioAprovado() {
        return anuncioAprovado;
    }

    public void setAnuncioAprovado(Boolean anuncioAprovado) {
        this.anuncioAprovado = anuncioAprovado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaVeiculoDTO)) {
            return false;
        }

        EmpresaVeiculoDTO empresaVeiculoDTO = (EmpresaVeiculoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, empresaVeiculoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaVeiculoDTO{" +
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
            ", aprovarFotos='" + getAprovarFotos() + "'" +
            ", preco=" + getPreco() +
            ", anuncioAprovado='" + getAnuncioAprovado() + "'" +
            "}";
    }
}
