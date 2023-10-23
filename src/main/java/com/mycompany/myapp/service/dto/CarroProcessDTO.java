package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CarroProcess} entity.
 */
public class CarroProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private CarroDTO carro;

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

    public CarroDTO getCarro() {
        return carro;
    }

    public void setCarro(CarroDTO carro) {
        this.carro = carro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarroProcessDTO)) {
            return false;
        }

        CarroProcessDTO carroProcessDTO = (CarroProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, carroProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CarroProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", carro=" + getCarro() +
            "}";
    }
}
