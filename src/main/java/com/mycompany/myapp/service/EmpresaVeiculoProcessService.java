package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.EmpresaVeiculoProcess;
import com.mycompany.myapp.repository.EmpresaVeiculoProcessRepository;
import com.mycompany.myapp.repository.EmpresaVeiculoRepository;
import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
import com.mycompany.myapp.service.mapper.EmpresaVeiculoProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link EmpresaVeiculoProcess}.
 */
@Service
@Transactional
public class EmpresaVeiculoProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "EmpresaVeiculoProcess";

    private final Logger log = LoggerFactory.getLogger(EmpresaVeiculoProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final EmpresaVeiculoRepository empresaVeiculoRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public EmpresaVeiculoProcessService(
        ProcessInstanceService processInstanceService,
        EmpresaVeiculoRepository empresaVeiculoRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.empresaVeiculoRepository = empresaVeiculoRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    /**
     * Save a empresaVeiculoProcess.
     *
     * @param empresaVeiculoProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public EmpresaVeiculoProcessDTO create(EmpresaVeiculoProcessDTO empresaVeiculoProcessDTO) {
        log.debug("Request to save EmpresaVeiculoProcess : {}", empresaVeiculoProcessDTO);

        EmpresaVeiculoProcess empresaVeiculoProcess = empresaVeiculoProcessMapper.toEntity(empresaVeiculoProcessDTO);

        //Saving the domainEntity
        empresaVeiculoRepository.save(empresaVeiculoProcess.getEmpresaVeiculo());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "EmpresaVeiculo#" + empresaVeiculoProcess.getEmpresaVeiculo().getId(),
            empresaVeiculoProcess
        );
        empresaVeiculoProcess.setProcessInstance(processInstance);

        //Saving the process entity
        empresaVeiculoProcess = empresaVeiculoProcessRepository.save(empresaVeiculoProcess);
        return empresaVeiculoProcessMapper.toDto(empresaVeiculoProcess);
    }

    /**
     * Get all the empresaVeiculoProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<EmpresaVeiculoProcessDTO> findAll() {
        log.debug("Request to get all EmpresaVeiculoProcesss");
        return empresaVeiculoProcessRepository
            .findAll()
            .stream()
            .map(empresaVeiculoProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one empresaVeiculoProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaVeiculoProcessDTO> findOne(Long id) {
        log.debug("Request to get EmpresaVeiculoProcess : {}", id);
        return empresaVeiculoProcessRepository.findById(id).map(empresaVeiculoProcessMapper::toDto);
    }

    /**
     * Get one empresaVeiculoProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaVeiculoProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get EmpresaVeiculoProcess by  processInstanceId: {}", processInstanceId);
        return empresaVeiculoProcessRepository.findByProcessInstanceId(processInstanceId).map(empresaVeiculoProcessMapper::toDto);
    }
}
