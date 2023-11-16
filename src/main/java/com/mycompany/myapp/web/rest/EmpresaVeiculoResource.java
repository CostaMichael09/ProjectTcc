package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.EmpresaVeiculoRepository;
import com.mycompany.myapp.service.EmpresaVeiculoService;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.EmpresaVeiculo}.
 */
@RestController
@RequestMapping("/api")
public class EmpresaVeiculoResource {

    private final Logger log = LoggerFactory.getLogger(EmpresaVeiculoResource.class);

    private final EmpresaVeiculoService empresaVeiculoService;

    private final EmpresaVeiculoRepository empresaVeiculoRepository;

    public EmpresaVeiculoResource(EmpresaVeiculoService empresaVeiculoService, EmpresaVeiculoRepository empresaVeiculoRepository) {
        this.empresaVeiculoService = empresaVeiculoService;
        this.empresaVeiculoRepository = empresaVeiculoRepository;
    }

    /**
     * {@code GET  /empresa-veiculos} : get all the empresaVeiculos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of empresaVeiculos in body.
     */
    @GetMapping("/empresa-veiculos")
    public List<EmpresaVeiculoDTO> getAllEmpresaVeiculos() {
        log.debug("REST request to get all EmpresaVeiculos");
        return empresaVeiculoService.findAll();
    }

    @GetMapping("/empresa-veiculos/anuncio-aprovado")
    public List<EmpresaVeiculoDTO> getAllEmpresaVeiculosAnuncioAprovado() {
        log.debug("REST request to get all EmpresaVeiculos");
        return empresaVeiculoService.findAllByAnuncioTrue();
    }

    /**
     * {@code GET  /empresa-veiculos/:id} : get the "id" empresaVeiculo.
     *
     * @param id the id of the empresaVeiculoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the empresaVeiculoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/empresa-veiculos/{id}")
    public ResponseEntity<EmpresaVeiculoDTO> getEmpresaVeiculo(@PathVariable Long id) {
        log.debug("REST request to get EmpresaVeiculo : {}", id);
        Optional<EmpresaVeiculoDTO> empresaVeiculoDTO = empresaVeiculoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(empresaVeiculoDTO);
    }
}
