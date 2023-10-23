package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Carro;
import com.mycompany.myapp.repository.CarroRepository;
import com.mycompany.myapp.service.dto.CarroDTO;
import com.mycompany.myapp.service.mapper.CarroMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Carro}.
 */
@Service
@Transactional
public class CarroService {

    private final Logger log = LoggerFactory.getLogger(CarroService.class);

    private final CarroRepository carroRepository;

    private final CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }

    /**
     * Save a carro.
     *
     * @param carroDTO the entity to save.
     * @return the persisted entity.
     */
    public CarroDTO save(CarroDTO carroDTO) {
        log.debug("Request to save Carro : {}", carroDTO);
        Carro carro = carroMapper.toEntity(carroDTO);
        carro = carroRepository.save(carro);
        return carroMapper.toDto(carro);
    }

    /**
     * Partially update a carro.
     *
     * @param carroDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CarroDTO> partialUpdate(CarroDTO carroDTO) {
        log.debug("Request to partially update Carro : {}", carroDTO);

        return carroRepository
            .findById(carroDTO.getId())
            .map(
                existingCarro -> {
                    carroMapper.partialUpdate(existingCarro, carroDTO);
                    return existingCarro;
                }
            )
            .map(carroRepository::save)
            .map(carroMapper::toDto);
    }

    /**
     * Get all the carros.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<CarroDTO> findAll() {
        log.debug("Request to get all Carros");
        return carroRepository.findAll().stream().map(carroMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one carro by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CarroDTO> findOne(Long id) {
        log.debug("Request to get Carro : {}", id);
        return carroRepository.findById(id).map(carroMapper::toDto);
    }

    /**
     * Delete the carro by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Carro : {}", id);
        carroRepository.deleteById(id);
    }
}
