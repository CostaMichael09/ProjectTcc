package com.mycompany.myapp.process.empresaVeiculoProcess;

import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.domain.EmpresaVeiculoProcess;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskAprovarFotosMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    EmpresaVeiculoProcessDTO toEmpresaVeiculoProcessDTO(EmpresaVeiculoProcess empresaVeiculoProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
//    @Mapping(target = "fotos", source = "fotos")
    @Mapping(target = "aprovarFotos", source = "aprovarFotos")
    EmpresaVeiculoDTO toEmpresaVeiculoDTO(EmpresaVeiculo empresaVeiculo);
}
