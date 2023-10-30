package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaVeiculoMapperTest {

    private EmpresaVeiculoMapper empresaVeiculoMapper;

    @BeforeEach
    public void setUp() {
        empresaVeiculoMapper = new EmpresaVeiculoMapperImpl();
    }
}
