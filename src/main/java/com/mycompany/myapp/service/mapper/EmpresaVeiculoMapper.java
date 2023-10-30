package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link EmpresaVeiculo} and its DTO {@link EmpresaVeiculoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmpresaVeiculoMapper extends EntityMapper<EmpresaVeiculoDTO, EmpresaVeiculo> {}
