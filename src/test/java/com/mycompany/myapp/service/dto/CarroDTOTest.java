package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CarroDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CarroDTO.class);
        CarroDTO carroDTO1 = new CarroDTO();
        carroDTO1.setId(1L);
        CarroDTO carroDTO2 = new CarroDTO();
        assertThat(carroDTO1).isNotEqualTo(carroDTO2);
        carroDTO2.setId(carroDTO1.getId());
        assertThat(carroDTO1).isEqualTo(carroDTO2);
        carroDTO2.setId(2L);
        assertThat(carroDTO1).isNotEqualTo(carroDTO2);
        carroDTO1.setId(null);
        assertThat(carroDTO1).isNotEqualTo(carroDTO2);
    }
}
