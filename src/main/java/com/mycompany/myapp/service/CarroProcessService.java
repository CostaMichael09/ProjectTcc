package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.CarroProcess;
import com.mycompany.myapp.repository.CarroProcessRepository;
import com.mycompany.myapp.repository.CarroRepository;
import com.mycompany.myapp.service.dto.CarroProcessDTO;
import com.mycompany.myapp.service.mapper.CarroProcessMapper;
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
 * Service Implementation for managing {@link CarroProcess}.
 */
@Service
@Transactional
public class CarroProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "CarroProcess";

    private final Logger log = LoggerFactory.getLogger(CarroProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final CarroRepository carroRepository;

    private final CarroProcessRepository carroProcessRepository;

    private final CarroProcessMapper carroProcessMapper;

    public CarroProcessService(
        ProcessInstanceService processInstanceService,
        CarroRepository carroRepository,
        CarroProcessRepository carroProcessRepository,
        CarroProcessMapper carroProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.carroRepository = carroRepository;
        this.carroProcessRepository = carroProcessRepository;
        this.carroProcessMapper = carroProcessMapper;
    }

    /**
     * Save a carroProcess.
     *
     * @param carroProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public CarroProcessDTO create(CarroProcessDTO carroProcessDTO) {
        log.debug("Request to save CarroProcess : {}", carroProcessDTO);

        CarroProcess carroProcess = carroProcessMapper.toEntity(carroProcessDTO);

        //Saving the domainEntity
        carroRepository.save(carroProcess.getCarro());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Carro#" + carroProcess.getCarro().getId(),
            carroProcess
        );
        carroProcess.setProcessInstance(processInstance);

        //Saving the process entity
        carroProcess = carroProcessRepository.save(carroProcess);
        return carroProcessMapper.toDto(carroProcess);
    }

    /**
     * Get all the carroProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<CarroProcessDTO> findAll() {
        log.debug("Request to get all CarroProcesss");
        return carroProcessRepository.findAll().stream().map(carroProcessMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one carroProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CarroProcessDTO> findOne(Long id) {
        log.debug("Request to get CarroProcess : {}", id);
        return carroProcessRepository.findById(id).map(carroProcessMapper::toDto);
    }

    /**
     * Get one carroProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CarroProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get CarroProcess by  processInstanceId: {}", processInstanceId);
        return carroProcessRepository.findByProcessInstanceId(processInstanceId).map(carroProcessMapper::toDto);
    }
}
