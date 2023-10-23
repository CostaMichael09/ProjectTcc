package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CarroProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CarroProcess} and its DTO {@link CarroProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, CarroMapper.class })
public interface CarroProcessMapper extends EntityMapper<CarroProcessDTO, CarroProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "carro", source = "carro")
    CarroProcessDTO toDto(CarroProcess s);
}
