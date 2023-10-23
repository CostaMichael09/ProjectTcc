package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Carro;
import com.mycompany.myapp.domain.enumeration.FormaPagamento;
import com.mycompany.myapp.repository.CarroRepository;
import com.mycompany.myapp.service.dto.CarroDTO;
import com.mycompany.myapp.service.mapper.CarroMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
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

/**
 * Integration tests for the {@link CarroResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CarroResourceIT {

    private static final String DEFAULT_NOME_CLIENTE = "AAAAAAAAAA";
    private static final String UPDATED_NOME_CLIENTE = "BBBBBBBBBB";

    private static final String DEFAULT_NOME_VENDEDOR = "AAAAAAAAAA";
    private static final String UPDATED_NOME_VENDEDOR = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MARCA_CARRO = "AAAAAAAAAA";
    private static final String UPDATED_MARCA_CARRO = "BBBBBBBBBB";

    private static final String DEFAULT_ANO_CARRO = "AAAAAAAAAA";
    private static final String UPDATED_ANO_CARRO = "BBBBBBBBBB";

    private static final String DEFAULT_MODELO_CARRO = "AAAAAAAAAA";
    private static final String UPDATED_MODELO_CARRO = "BBBBBBBBBB";

    private static final FormaPagamento DEFAULT_FORMA_PAGAMENTO = FormaPagamento.AVISTA;
    private static final FormaPagamento UPDATED_FORMA_PAGAMENTO = FormaPagamento.FINANCIADO;

    private static final Boolean DEFAULT_GNV = false;
    private static final Boolean UPDATED_GNV = true;

    private static final BigDecimal DEFAULT_VALOR_TOTAL_CARRO = new BigDecimal(1);
    private static final BigDecimal UPDATED_VALOR_TOTAL_CARRO = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ENTRADA = new BigDecimal(1);
    private static final BigDecimal UPDATED_ENTRADA = new BigDecimal(2);

    private static final BigDecimal DEFAULT_VALOR_PARCELA = new BigDecimal(1);
    private static final BigDecimal UPDATED_VALOR_PARCELA = new BigDecimal(2);

    private static final Long DEFAULT_PARCELAS = 1L;
    private static final Long UPDATED_PARCELAS = 2L;

    private static final BigDecimal DEFAULT_JUROS = new BigDecimal(1);
    private static final BigDecimal UPDATED_JUROS = new BigDecimal(2);

    private static final String DEFAULT_RUA = "AAAAAAAAAA";
    private static final String UPDATED_RUA = "BBBBBBBBBB";

    private static final String DEFAULT_BAIRRO = "AAAAAAAAAA";
    private static final String UPDATED_BAIRRO = "BBBBBBBBBB";

    private static final String DEFAULT_CIDADE = "AAAAAAAAAA";
    private static final String UPDATED_CIDADE = "BBBBBBBBBB";

    private static final String DEFAULT_CEP = "AAAAAAAAAA";
    private static final String UPDATED_CEP = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/carros";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroMapper carroMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCarroMockMvc;

    private Carro carro;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Carro createEntity(EntityManager em) {
        Carro carro = new Carro()
            .nomeCliente(DEFAULT_NOME_CLIENTE)
            .nomeVendedor(DEFAULT_NOME_VENDEDOR)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .marcaCarro(DEFAULT_MARCA_CARRO)
            .anoCarro(DEFAULT_ANO_CARRO)
            .modeloCarro(DEFAULT_MODELO_CARRO)
            .formaPagamento(DEFAULT_FORMA_PAGAMENTO)
            .gnv(DEFAULT_GNV)
            .valorTotalCarro(DEFAULT_VALOR_TOTAL_CARRO)
            .entrada(DEFAULT_ENTRADA)
            .valorParcela(DEFAULT_VALOR_PARCELA)
            .parcelas(DEFAULT_PARCELAS)
            .juros(DEFAULT_JUROS)
            .rua(DEFAULT_RUA)
            .bairro(DEFAULT_BAIRRO)
            .cidade(DEFAULT_CIDADE)
            .cep(DEFAULT_CEP);
        return carro;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Carro createUpdatedEntity(EntityManager em) {
        Carro carro = new Carro()
            .nomeCliente(UPDATED_NOME_CLIENTE)
            .nomeVendedor(UPDATED_NOME_VENDEDOR)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .marcaCarro(UPDATED_MARCA_CARRO)
            .anoCarro(UPDATED_ANO_CARRO)
            .modeloCarro(UPDATED_MODELO_CARRO)
            .formaPagamento(UPDATED_FORMA_PAGAMENTO)
            .gnv(UPDATED_GNV)
            .valorTotalCarro(UPDATED_VALOR_TOTAL_CARRO)
            .entrada(UPDATED_ENTRADA)
            .valorParcela(UPDATED_VALOR_PARCELA)
            .parcelas(UPDATED_PARCELAS)
            .juros(UPDATED_JUROS)
            .rua(UPDATED_RUA)
            .bairro(UPDATED_BAIRRO)
            .cidade(UPDATED_CIDADE)
            .cep(UPDATED_CEP);
        return carro;
    }

    @BeforeEach
    public void initTest() {
        carro = createEntity(em);
    }

    @Test
    @Transactional
    void getAllCarros() throws Exception {
        // Initialize the database
        carroRepository.saveAndFlush(carro);

        // Get all the carroList
        restCarroMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(carro.getId().intValue())))
            .andExpect(jsonPath("$.[*].nomeCliente").value(hasItem(DEFAULT_NOME_CLIENTE)))
            .andExpect(jsonPath("$.[*].nomeVendedor").value(hasItem(DEFAULT_NOME_VENDEDOR)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].marcaCarro").value(hasItem(DEFAULT_MARCA_CARRO)))
            .andExpect(jsonPath("$.[*].anoCarro").value(hasItem(DEFAULT_ANO_CARRO)))
            .andExpect(jsonPath("$.[*].modeloCarro").value(hasItem(DEFAULT_MODELO_CARRO)))
            .andExpect(jsonPath("$.[*].formaPagamento").value(hasItem(DEFAULT_FORMA_PAGAMENTO.toString())))
            .andExpect(jsonPath("$.[*].gnv").value(hasItem(DEFAULT_GNV.booleanValue())))
            .andExpect(jsonPath("$.[*].valorTotalCarro").value(hasItem(sameNumber(DEFAULT_VALOR_TOTAL_CARRO))))
            .andExpect(jsonPath("$.[*].entrada").value(hasItem(sameNumber(DEFAULT_ENTRADA))))
            .andExpect(jsonPath("$.[*].valorParcela").value(hasItem(sameNumber(DEFAULT_VALOR_PARCELA))))
            .andExpect(jsonPath("$.[*].parcelas").value(hasItem(DEFAULT_PARCELAS.intValue())))
            .andExpect(jsonPath("$.[*].juros").value(hasItem(sameNumber(DEFAULT_JUROS))))
            .andExpect(jsonPath("$.[*].rua").value(hasItem(DEFAULT_RUA)))
            .andExpect(jsonPath("$.[*].bairro").value(hasItem(DEFAULT_BAIRRO)))
            .andExpect(jsonPath("$.[*].cidade").value(hasItem(DEFAULT_CIDADE)))
            .andExpect(jsonPath("$.[*].cep").value(hasItem(DEFAULT_CEP)));
    }

    @Test
    @Transactional
    void getCarro() throws Exception {
        // Initialize the database
        carroRepository.saveAndFlush(carro);

        // Get the carro
        restCarroMockMvc
            .perform(get(ENTITY_API_URL_ID, carro.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(carro.getId().intValue()))
            .andExpect(jsonPath("$.nomeCliente").value(DEFAULT_NOME_CLIENTE))
            .andExpect(jsonPath("$.nomeVendedor").value(DEFAULT_NOME_VENDEDOR))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.marcaCarro").value(DEFAULT_MARCA_CARRO))
            .andExpect(jsonPath("$.anoCarro").value(DEFAULT_ANO_CARRO))
            .andExpect(jsonPath("$.modeloCarro").value(DEFAULT_MODELO_CARRO))
            .andExpect(jsonPath("$.formaPagamento").value(DEFAULT_FORMA_PAGAMENTO.toString()))
            .andExpect(jsonPath("$.gnv").value(DEFAULT_GNV.booleanValue()))
            .andExpect(jsonPath("$.valorTotalCarro").value(sameNumber(DEFAULT_VALOR_TOTAL_CARRO)))
            .andExpect(jsonPath("$.entrada").value(sameNumber(DEFAULT_ENTRADA)))
            .andExpect(jsonPath("$.valorParcela").value(sameNumber(DEFAULT_VALOR_PARCELA)))
            .andExpect(jsonPath("$.parcelas").value(DEFAULT_PARCELAS.intValue()))
            .andExpect(jsonPath("$.juros").value(sameNumber(DEFAULT_JUROS)))
            .andExpect(jsonPath("$.rua").value(DEFAULT_RUA))
            .andExpect(jsonPath("$.bairro").value(DEFAULT_BAIRRO))
            .andExpect(jsonPath("$.cidade").value(DEFAULT_CIDADE))
            .andExpect(jsonPath("$.cep").value(DEFAULT_CEP));
    }

    @Test
    @Transactional
    void getNonExistingCarro() throws Exception {
        // Get the carro
        restCarroMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
