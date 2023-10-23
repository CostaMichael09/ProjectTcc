package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CarroProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CarroProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarroProcessRepository extends JpaRepository<CarroProcess, Long> {
    Optional<CarroProcess> findByProcessInstanceId(Long processInstanceId);
}
