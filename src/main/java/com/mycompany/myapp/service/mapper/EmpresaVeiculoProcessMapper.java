package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link EmpresaVeiculoProcess} and its DTO {@link EmpresaVeiculoProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, EmpresaVeiculoMapper.class })
public interface EmpresaVeiculoProcessMapper extends EntityMapper<EmpresaVeiculoProcessDTO, EmpresaVeiculoProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "empresaVeiculo", source = "empresaVeiculo")
    EmpresaVeiculoProcessDTO toDto(EmpresaVeiculoProcess s);
}
