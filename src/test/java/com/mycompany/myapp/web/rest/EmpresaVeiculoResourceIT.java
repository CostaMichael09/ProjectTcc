package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.repository.EmpresaVeiculoRepository;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import com.mycompany.myapp.service.mapper.EmpresaVeiculoMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link EmpresaVeiculoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class EmpresaVeiculoResourceIT {

    private static final String DEFAULT_RENAVAM = "AAAAAAAAAA";
    private static final String UPDATED_RENAVAM = "BBBBBBBBBB";

    private static final String DEFAULT_PLACA = "AAAAAAAAAA";
    private static final String UPDATED_PLACA = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DOC_REGULAR = false;
    private static final Boolean UPDATED_DOC_REGULAR = true;

    private static final BigDecimal DEFAULT_MULTA = new BigDecimal(1);
    private static final BigDecimal UPDATED_MULTA = new BigDecimal(2);

    private static final String DEFAULT_MARCA = "AAAAAAAAAA";
    private static final String UPDATED_MARCA = "BBBBBBBBBB";

    private static final String DEFAULT_MODELO = "AAAAAAAAAA";
    private static final String UPDATED_MODELO = "BBBBBBBBBB";

    private static final Long DEFAULT_ANO_FABRICACAO = 1L;
    private static final Long UPDATED_ANO_FABRICACAO = 2L;

    private static final Long DEFAULT_ANO_MODELO = 1L;
    private static final Long UPDATED_ANO_MODELO = 2L;

    private static final String DEFAULT_COR = "AAAAAAAAAA";
    private static final String UPDATED_COR = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ESTADO_VEICULO = false;
    private static final Boolean UPDATED_ESTADO_VEICULO = true;

    private static final String DEFAULT_OBS_ESTADO_VEICULO = "AAAAAAAAAA";
    private static final String UPDATED_OBS_ESTADO_VEICULO = "BBBBBBBBBB";

    private static final String DEFAULT_FOTOS = "AAAAAAAAAA";
    private static final String UPDATED_FOTOS = "BBBBBBBBBB";

    private static final Boolean DEFAULT_APROVAR_FOTOS = false;
    private static final Boolean UPDATED_APROVAR_FOTOS = true;

    private static final BigDecimal DEFAULT_PRECO = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRECO = new BigDecimal(2);

    private static final Boolean DEFAULT_ANUNCIO_APROVADO = false;
    private static final Boolean UPDATED_ANUNCIO_APROVADO = true;

    private static final String ENTITY_API_URL = "/api/empresa-veiculos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EmpresaVeiculoRepository empresaVeiculoRepository;

    @Autowired
    private EmpresaVeiculoMapper empresaVeiculoMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEmpresaVeiculoMockMvc;

    private EmpresaVeiculo empresaVeiculo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmpresaVeiculo createEntity(EntityManager em) {
        EmpresaVeiculo empresaVeiculo = new EmpresaVeiculo()
            .renavam(DEFAULT_RENAVAM)
            .placa(DEFAULT_PLACA)
            .docRegular(DEFAULT_DOC_REGULAR)
            .multa(DEFAULT_MULTA)
            .marca(DEFAULT_MARCA)
            .modelo(DEFAULT_MODELO)
            .anoFabricacao(DEFAULT_ANO_FABRICACAO)
            .anoModelo(DEFAULT_ANO_MODELO)
            .cor(DEFAULT_COR)
            .estadoVeiculo(DEFAULT_ESTADO_VEICULO)
            .obsEstadoVeiculo(DEFAULT_OBS_ESTADO_VEICULO)
            .fotos(DEFAULT_FOTOS)
            .aprovarFotos(DEFAULT_APROVAR_FOTOS)
            .preco(DEFAULT_PRECO)
            .anuncioAprovado(DEFAULT_ANUNCIO_APROVADO);
        return empresaVeiculo;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmpresaVeiculo createUpdatedEntity(EntityManager em) {
        EmpresaVeiculo empresaVeiculo = new EmpresaVeiculo()
            .renavam(UPDATED_RENAVAM)
            .placa(UPDATED_PLACA)
            .docRegular(UPDATED_DOC_REGULAR)
            .multa(UPDATED_MULTA)
            .marca(UPDATED_MARCA)
            .modelo(UPDATED_MODELO)
            .anoFabricacao(UPDATED_ANO_FABRICACAO)
            .anoModelo(UPDATED_ANO_MODELO)
            .cor(UPDATED_COR)
            .estadoVeiculo(UPDATED_ESTADO_VEICULO)
            .obsEstadoVeiculo(UPDATED_OBS_ESTADO_VEICULO)
            .fotos(UPDATED_FOTOS)
            .aprovarFotos(UPDATED_APROVAR_FOTOS)
            .preco(UPDATED_PRECO)
            .anuncioAprovado(UPDATED_ANUNCIO_APROVADO);
        return empresaVeiculo;
    }

    @BeforeEach
    public void initTest() {
        empresaVeiculo = createEntity(em);
    }

    @Test
    @Transactional
    void getAllEmpresaVeiculos() throws Exception {
        // Initialize the database
        empresaVeiculoRepository.saveAndFlush(empresaVeiculo);

        // Get all the empresaVeiculoList
        restEmpresaVeiculoMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(empresaVeiculo.getId().intValue())))
            .andExpect(jsonPath("$.[*].renavam").value(hasItem(DEFAULT_RENAVAM)))
            .andExpect(jsonPath("$.[*].placa").value(hasItem(DEFAULT_PLACA)))
            .andExpect(jsonPath("$.[*].docRegular").value(hasItem(DEFAULT_DOC_REGULAR.booleanValue())))
            .andExpect(jsonPath("$.[*].multa").value(hasItem(sameNumber(DEFAULT_MULTA))))
            .andExpect(jsonPath("$.[*].marca").value(hasItem(DEFAULT_MARCA)))
            .andExpect(jsonPath("$.[*].modelo").value(hasItem(DEFAULT_MODELO)))
            .andExpect(jsonPath("$.[*].anoFabricacao").value(hasItem(DEFAULT_ANO_FABRICACAO.intValue())))
            .andExpect(jsonPath("$.[*].anoModelo").value(hasItem(DEFAULT_ANO_MODELO.intValue())))
            .andExpect(jsonPath("$.[*].cor").value(hasItem(DEFAULT_COR)))
            .andExpect(jsonPath("$.[*].estadoVeiculo").value(hasItem(DEFAULT_ESTADO_VEICULO.booleanValue())))
            .andExpect(jsonPath("$.[*].obsEstadoVeiculo").value(hasItem(DEFAULT_OBS_ESTADO_VEICULO)))
            .andExpect(jsonPath("$.[*].fotos").value(hasItem(DEFAULT_FOTOS.toString())))
            .andExpect(jsonPath("$.[*].aprovarFotos").value(hasItem(DEFAULT_APROVAR_FOTOS.booleanValue())))
            .andExpect(jsonPath("$.[*].preco").value(hasItem(sameNumber(DEFAULT_PRECO))))
            .andExpect(jsonPath("$.[*].anuncioAprovado").value(hasItem(DEFAULT_ANUNCIO_APROVADO.booleanValue())));
    }

    @Test
    @Transactional
    void getEmpresaVeiculo() throws Exception {
        // Initialize the database
        empresaVeiculoRepository.saveAndFlush(empresaVeiculo);

        // Get the empresaVeiculo
        restEmpresaVeiculoMockMvc
            .perform(get(ENTITY_API_URL_ID, empresaVeiculo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(empresaVeiculo.getId().intValue()))
            .andExpect(jsonPath("$.renavam").value(DEFAULT_RENAVAM))
            .andExpect(jsonPath("$.placa").value(DEFAULT_PLACA))
            .andExpect(jsonPath("$.docRegular").value(DEFAULT_DOC_REGULAR.booleanValue()))
            .andExpect(jsonPath("$.multa").value(sameNumber(DEFAULT_MULTA)))
            .andExpect(jsonPath("$.marca").value(DEFAULT_MARCA))
            .andExpect(jsonPath("$.modelo").value(DEFAULT_MODELO))
            .andExpect(jsonPath("$.anoFabricacao").value(DEFAULT_ANO_FABRICACAO.intValue()))
            .andExpect(jsonPath("$.anoModelo").value(DEFAULT_ANO_MODELO.intValue()))
            .andExpect(jsonPath("$.cor").value(DEFAULT_COR))
            .andExpect(jsonPath("$.estadoVeiculo").value(DEFAULT_ESTADO_VEICULO.booleanValue()))
            .andExpect(jsonPath("$.obsEstadoVeiculo").value(DEFAULT_OBS_ESTADO_VEICULO))
            .andExpect(jsonPath("$.fotos").value(DEFAULT_FOTOS.toString()))
            .andExpect(jsonPath("$.aprovarFotos").value(DEFAULT_APROVAR_FOTOS.booleanValue()))
            .andExpect(jsonPath("$.preco").value(sameNumber(DEFAULT_PRECO)))
            .andExpect(jsonPath("$.anuncioAprovado").value(DEFAULT_ANUNCIO_APROVADO.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingEmpresaVeiculo() throws Exception {
        // Get the empresaVeiculo
        restEmpresaVeiculoMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
