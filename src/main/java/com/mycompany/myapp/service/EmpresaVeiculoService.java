package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.repository.EmpresaVeiculoRepository;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import com.mycompany.myapp.service.mapper.EmpresaVeiculoMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link EmpresaVeiculo}.
 */
@Service
@Transactional
public class EmpresaVeiculoService {

    private final Logger log = LoggerFactory.getLogger(EmpresaVeiculoService.class);

    private final EmpresaVeiculoRepository empresaVeiculoRepository;

    private final EmpresaVeiculoMapper empresaVeiculoMapper;

    public EmpresaVeiculoService(EmpresaVeiculoRepository empresaVeiculoRepository, EmpresaVeiculoMapper empresaVeiculoMapper) {
        this.empresaVeiculoRepository = empresaVeiculoRepository;
        this.empresaVeiculoMapper = empresaVeiculoMapper;
    }

    /**
     * Save a empresaVeiculo.
     *
     * @param empresaVeiculoDTO the entity to save.
     * @return the persisted entity.
     */
    public EmpresaVeiculoDTO save(EmpresaVeiculoDTO empresaVeiculoDTO) {
        log.debug("Request to save EmpresaVeiculo : {}", empresaVeiculoDTO);
        EmpresaVeiculo empresaVeiculo = empresaVeiculoMapper.toEntity(empresaVeiculoDTO);
        empresaVeiculo = empresaVeiculoRepository.save(empresaVeiculo);
        return empresaVeiculoMapper.toDto(empresaVeiculo);
    }

    /**
     * Partially update a empresaVeiculo.
     *
     * @param empresaVeiculoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<EmpresaVeiculoDTO> partialUpdate(EmpresaVeiculoDTO empresaVeiculoDTO) {
        log.debug("Request to partially update EmpresaVeiculo : {}", empresaVeiculoDTO);

        return empresaVeiculoRepository
            .findById(empresaVeiculoDTO.getId())
            .map(
                existingEmpresaVeiculo -> {
                    empresaVeiculoMapper.partialUpdate(existingEmpresaVeiculo, empresaVeiculoDTO);
                    return existingEmpresaVeiculo;
                }
            )
            .map(empresaVeiculoRepository::save)
            .map(empresaVeiculoMapper::toDto);
    }

    /**
     * Get all the empresaVeiculos.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<EmpresaVeiculoDTO> findAll() {
        log.debug("Request to get all EmpresaVeiculos");
        return empresaVeiculoRepository
            .findAll()
            .stream()
            .map(empresaVeiculoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one empresaVeiculo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaVeiculoDTO> findOne(Long id) {
        log.debug("Request to get EmpresaVeiculo : {}", id);
        return empresaVeiculoRepository.findById(id).map(empresaVeiculoMapper::toDto);
    }

    /**
     * Delete the empresaVeiculo by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EmpresaVeiculo : {}", id);
        empresaVeiculoRepository.deleteById(id);
    }
}
