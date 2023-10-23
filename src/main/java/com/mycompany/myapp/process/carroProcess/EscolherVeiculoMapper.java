package com.mycompany.myapp.process.carroProcess;

import com.mycompany.myapp.domain.Carro;
import com.mycompany.myapp.domain.CarroProcess;
import com.mycompany.myapp.service.dto.CarroDTO;
import com.mycompany.myapp.service.dto.CarroProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface EscolherVeiculoMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    CarroProcessDTO toCarroProcessDTO(CarroProcess carroProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeCliente", source = "nomeCliente")
    @Mapping(target = "nomeVendedor", source = "nomeVendedor")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "marcaCarro", source = "marcaCarro")
    @Mapping(target = "anoCarro", source = "anoCarro")
    @Mapping(target = "modeloCarro", source = "modeloCarro")
    @Mapping(target = "gnv", source = "gnv")
    @Mapping(target = "valorTotalCarro", source = "valorTotalCarro")
    CarroDTO toCarroDTO(Carro carro);
}
