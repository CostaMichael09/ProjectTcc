package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.akip.domain.ProcessInstance;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A EmpresaVeiculoProcess.
 */
@Entity
@Table(name = "empresa_veiculo_process")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmpresaVeiculoProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "processDefinition" }, allowSetters = true)
    private ProcessInstance processInstance;

    @ManyToOne
    private EmpresaVeiculo empresaVeiculo;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaVeiculoProcess id(Long id) {
        this.id = id;
        return this;
    }

    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public EmpresaVeiculoProcess processInstance(ProcessInstance processInstance) {
        this.setProcessInstance(processInstance);
        return this;
    }

    public EmpresaVeiculo getEmpresaVeiculo() {
        return this.empresaVeiculo;
    }

    public void setEmpresaVeiculo(EmpresaVeiculo empresaVeiculo) {
        this.empresaVeiculo = empresaVeiculo;
    }

    public EmpresaVeiculoProcess EmpresaVeiculo(EmpresaVeiculo empresaVeiculo) {
        this.setEmpresaVeiculo(empresaVeiculo);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaVeiculoProcess)) {
            return false;
        }
        return id != null && id.equals(((EmpresaVeiculoProcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaVeiculoProcess{" +
            "id=" + getId() +
            "}";
    }
}
