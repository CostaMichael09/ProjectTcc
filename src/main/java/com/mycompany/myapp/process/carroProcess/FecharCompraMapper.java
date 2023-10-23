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
public interface FecharCompraMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    CarroProcessDTO toCarroProcessDTO(CarroProcess carroProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeCliente", source = "nomeCliente")
    @Mapping(target = "nomeVendedor", source = "nomeVendedor")
    @Mapping(target = "marcaCarro", source = "marcaCarro")
    @Mapping(target = "anoCarro", source = "anoCarro")
    @Mapping(target = "modeloCarro", source = "modeloCarro")
    @Mapping(target = "valorTotalCarro", source = "valorTotalCarro")
    @Mapping(target = "formaPagamento", source = "formaPagamento")
    @Mapping(target = "entrada", source = "entrada")
    @Mapping(target = "parcelas", source = "parcelas")
    @Mapping(target = "valorParcela", source = "valorParcela")
    @Mapping(target = "juros", source = "juros")
    @Mapping(target = "rua", source = "rua")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "cidade", source = "cidade")
    @Mapping(target = "cep", source = "cep")
    CarroDTO toCarroDTO(Carro carro);
}
