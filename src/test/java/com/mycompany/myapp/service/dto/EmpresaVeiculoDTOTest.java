package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmpresaVeiculoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmpresaVeiculoDTO.class);
        EmpresaVeiculoDTO empresaVeiculoDTO1 = new EmpresaVeiculoDTO();
        empresaVeiculoDTO1.setId(1L);
        EmpresaVeiculoDTO empresaVeiculoDTO2 = new EmpresaVeiculoDTO();
        assertThat(empresaVeiculoDTO1).isNotEqualTo(empresaVeiculoDTO2);
        empresaVeiculoDTO2.setId(empresaVeiculoDTO1.getId());
        assertThat(empresaVeiculoDTO1).isEqualTo(empresaVeiculoDTO2);
        empresaVeiculoDTO2.setId(2L);
        assertThat(empresaVeiculoDTO1).isNotEqualTo(empresaVeiculoDTO2);
        empresaVeiculoDTO1.setId(null);
        assertThat(empresaVeiculoDTO1).isNotEqualTo(empresaVeiculoDTO2);
    }
}
