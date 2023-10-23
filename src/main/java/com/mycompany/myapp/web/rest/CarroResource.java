package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.CarroRepository;
import com.mycompany.myapp.service.CarroService;
import com.mycompany.myapp.service.dto.CarroDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.Carro}.
 */
@RestController
@RequestMapping("/api")
public class CarroResource {

    private final Logger log = LoggerFactory.getLogger(CarroResource.class);

    private final CarroService carroService;

    private final CarroRepository carroRepository;

    public CarroResource(CarroService carroService, CarroRepository carroRepository) {
        this.carroService = carroService;
        this.carroRepository = carroRepository;
    }

    /**
     * {@code GET  /carros} : get all the carros.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of carros in body.
     */
    @GetMapping("/carros")
    public List<CarroDTO> getAllCarros() {
        log.debug("REST request to get all Carros");
        return carroService.findAll();
    }

    /**
     * {@code GET  /carros/:id} : get the "id" carro.
     *
     * @param id the id of the carroDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the carroDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/carros/{id}")
    public ResponseEntity<CarroDTO> getCarro(@PathVariable Long id) {
        log.debug("REST request to get Carro : {}", id);
        Optional<CarroDTO> carroDTO = carroService.findOne(id);
        return ResponseUtil.wrapOrNotFound(carroDTO);
    }
}
