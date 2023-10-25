package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.EmpresaVeiculoProcess} entity.
 */
public class EmpresaVeiculoProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private EmpresaVeiculoDTO empresaVeiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public EmpresaVeiculoDTO getEmpresaVeiculo() {
        return empresaVeiculo;
    }

    public void setEmpresaVeiculo(EmpresaVeiculoDTO empresaVeiculo) {
        this.empresaVeiculo = empresaVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaVeiculoProcessDTO)) {
            return false;
        }

        EmpresaVeiculoProcessDTO empresaVeiculoProcessDTO = (EmpresaVeiculoProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, empresaVeiculoProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaVeiculoProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", empresaVeiculo=" + getEmpresaVeiculo() +
            "}";
    }
}
