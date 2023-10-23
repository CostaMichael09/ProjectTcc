package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarroMapperTest {

    private CarroMapper carroMapper;

    @BeforeEach
    public void setUp() {
        carroMapper = new CarroMapperImpl();
    }
}
