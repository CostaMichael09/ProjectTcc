package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.EmpresaVeiculoProcess;
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
}
