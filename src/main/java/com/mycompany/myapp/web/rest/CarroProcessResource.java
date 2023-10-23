package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CarroProcessService;
import com.mycompany.myapp.service.dto.CarroProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.CarroProcess}.
 */
@RestController
@RequestMapping("/api")
public class CarroProcessResource {

    private final Logger log = LoggerFactory.getLogger(CarroProcessResource.class);

    private static final String ENTITY_NAME = "carroProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CarroProcessService carroProcessService;

    public CarroProcessResource(CarroProcessService carroProcessService) {
        this.carroProcessService = carroProcessService;
    }

    /**
     * {@code POST  /carro-processes} : Create a new carroProcess.
     *
     * @param carroProcessDTO the carroProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new carroProcessDTO, or with status {@code 400 (Bad Request)} if the carroProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/carro-processes")
    public ResponseEntity<CarroProcessDTO> create(@RequestBody CarroProcessDTO carroProcessDTO) throws URISyntaxException {
        log.debug("REST request to save CarroProcess : {}", carroProcessDTO);
        if (carroProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new carroProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CarroProcessDTO result = carroProcessService.create(carroProcessDTO);
        return ResponseEntity
            .created(new URI("/api/carro-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /carro-processes} : get all the carroProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of carroProcesss in body.
     */
    @GetMapping("/carro-processes")
    public List<CarroProcessDTO> getAllCarroProcesss() {
        log.debug("REST request to get all CarroProcesss");
        return carroProcessService.findAll();
    }

    /**
     * {@code GET  /carro-processes/:id} : get the "id" carroProcess.
     *
     * @param processInstanceId the id of the carroProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the carroProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/carro-processes/{processInstanceId}")
    public ResponseEntity<CarroProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get CarroProcess by processInstanceId : {}", processInstanceId);
        Optional<CarroProcessDTO> carroProcessDTO = carroProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(carroProcessDTO);
    }
}
