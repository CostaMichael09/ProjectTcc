package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Arquivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivosRepository extends JpaRepository<Arquivos, Long> {
    Arquivos findByEmpresaVeiculoId(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoIdAndPdfsIsNotNull(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoIdAndFotosIsNotNull(Long empresaVeiculoId);



}
