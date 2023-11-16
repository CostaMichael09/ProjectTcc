package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.EmpresaVeiculoProcessService;
import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.EmpresaVeiculoProcess}.
 */
@RestController
@RequestMapping("/api")
public class EmpresaVeiculoProcessResource {

    private final Logger log = LoggerFactory.getLogger(EmpresaVeiculoProcessResource.class);

    private static final String ENTITY_NAME = "empresaVeiculoProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EmpresaVeiculoProcessService empresaVeiculoProcessService;

    public EmpresaVeiculoProcessResource(EmpresaVeiculoProcessService empresaVeiculoProcessService) {
        this.empresaVeiculoProcessService = empresaVeiculoProcessService;
    }

    /**
     * {@code POST  /empresa-veiculo-processes} : Create a new empresaVeiculoProcess.
     *
     * @param empresaVeiculoProcessDTO the empresaVeiculoProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new empresaVeiculoProcessDTO, or with status {@code 400 (Bad Request)} if the empresaVeiculoProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/empresa-veiculo-processes")
    public ResponseEntity<EmpresaVeiculoProcessDTO> create(@RequestBody EmpresaVeiculoProcessDTO empresaVeiculoProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save EmpresaVeiculoProcess : {}", empresaVeiculoProcessDTO);
        if (empresaVeiculoProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new empresaVeiculoProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmpresaVeiculoProcessDTO result = empresaVeiculoProcessService.create(empresaVeiculoProcessDTO);
        return ResponseEntity
            .created(new URI("/api/empresa-veiculo-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /empresa-veiculo-processes} : get all the empresaVeiculoProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of empresaVeiculoProcesss in body.
     */
    @GetMapping("/empresa-veiculo-processes")
    public List<EmpresaVeiculoProcessDTO> getAllEmpresaVeiculoProcesss() {
        log.debug("REST request to get all EmpresaVeiculoProcesss");
        return empresaVeiculoProcessService.findAll();
    }

    @GetMapping("/empresa-veiculo-processes/anuncios-aprovado")
    public List<EmpresaVeiculoProcessDTO> getAllAnunciosAprovadoEmpresaVeiculoProcesss() {
        log.debug("REST request to get all EmpresaVeiculoProcesss");
        return empresaVeiculoProcessService.findAllByAnuncioTrue();
    }

    /**
     * {@code GET  /empresa-veiculo-processes/:id} : get the "id" empresaVeiculoProcess.
     *
     * @param processInstanceId the id of the empresaVeiculoProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the empresaVeiculoProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/empresa-veiculo-processes/{processInstanceId}")
    public ResponseEntity<EmpresaVeiculoProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get EmpresaVeiculoProcess by processInstanceId : {}", processInstanceId);
        Optional<EmpresaVeiculoProcessDTO> empresaVeiculoProcessDTO = empresaVeiculoProcessService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(empresaVeiculoProcessDTO);
    }
}
