package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Arquivos;
import com.mycompany.myapp.service.dto.ArquivosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArquivosMapper {

    @Mapping(target = "empresaVeiculoId", source = "empresaVeiculo.id")
    ArquivosDTO toDto(Arquivos arquivos);

    Arquivos toEntity(ArquivosDTO arquivosDTO);
}
