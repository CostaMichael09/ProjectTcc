package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CarroDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Carro} and its DTO {@link CarroDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CarroMapper extends EntityMapper<CarroDTO, Carro> {}
