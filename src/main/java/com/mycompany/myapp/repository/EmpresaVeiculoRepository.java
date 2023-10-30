package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.EmpresaVeiculo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the EmpresaVeiculo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpresaVeiculoRepository extends JpaRepository<EmpresaVeiculo, Long> {}
