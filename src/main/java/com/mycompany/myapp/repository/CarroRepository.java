package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Carro;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Carro entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {}
