package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Arquivos;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivosRepository extends JpaRepository<Arquivos, Long> {
    Arquivos findByEmpresaVeiculoId(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoId(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoIdAndPdfsIsNotNull(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoIdAndFotosIsNotNull(Long empresaVeiculoId);

    List<Arquivos> findAllByEmpresaVeiculoIdInAndFotosIsNotNull(List<Long> empresaVeiculosIds);
}
