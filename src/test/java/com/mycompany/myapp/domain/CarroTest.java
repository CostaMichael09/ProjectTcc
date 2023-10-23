package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CarroTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Carro.class);
        Carro carro1 = new Carro();
        carro1.setId(1L);
        Carro carro2 = new Carro();
        carro2.setId(carro1.getId());
        assertThat(carro1).isEqualTo(carro2);
        carro2.setId(2L);
        assertThat(carro1).isNotEqualTo(carro2);
        carro1.setId(null);
        assertThat(carro1).isNotEqualTo(carro2);
    }
}
