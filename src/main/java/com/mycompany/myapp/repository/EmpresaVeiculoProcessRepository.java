package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.domain.EmpresaVeiculoProcess;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the EmpresaVeiculoProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpresaVeiculoProcessRepository extends JpaRepository<EmpresaVeiculoProcess, Long> {
    Optional<EmpresaVeiculoProcess> findByProcessInstanceId(Long processInstanceId);

    List<EmpresaVeiculoProcess> findAllByProcessInstanceId(Long processInstanceId);

    List<EmpresaVeiculoProcess> findAllByEmpresaVeiculo_AnuncioAprovado(Boolean anuncioAprovado);
}
