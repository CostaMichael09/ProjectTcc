package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmpresaVeiculoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmpresaVeiculo.class);
        EmpresaVeiculo empresaVeiculo1 = new EmpresaVeiculo();
        empresaVeiculo1.setId(1L);
        EmpresaVeiculo empresaVeiculo2 = new EmpresaVeiculo();
        empresaVeiculo2.setId(empresaVeiculo1.getId());
        assertThat(empresaVeiculo1).isEqualTo(empresaVeiculo2);
        empresaVeiculo2.setId(2L);
        assertThat(empresaVeiculo1).isNotEqualTo(empresaVeiculo2);
        empresaVeiculo1.setId(null);
        assertThat(empresaVeiculo1).isNotEqualTo(empresaVeiculo2);
    }
}
