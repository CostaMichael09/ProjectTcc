package com.mycompany.myapp.process.empresaVeiculoProcess;

import com.mycompany.myapp.repository.EmpresaVeiculoProcessRepository;
import com.mycompany.myapp.service.EmpresaVeiculoService;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
import com.mycompany.myapp.service.mapper.EmpresaVeiculoProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskVerificarEstadoDoVeiculoService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskVerificarEstadoDoVeiculoMapper taskVerificarEstadoDoVeiculoMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskVerificarEstadoDoVeiculoService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskVerificarEstadoDoVeiculoMapper taskVerificarEstadoDoVeiculoMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskVerificarEstadoDoVeiculoMapper = taskVerificarEstadoDoVeiculoMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskVerificarEstadoDoVeiculoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskVerificarEstadoDoVeiculoMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext = new TaskVerificarEstadoDoVeiculoContextDTO();
        taskVerificarEstadoDoVeiculoContext.setTaskInstance(taskInstanceDTO);
        taskVerificarEstadoDoVeiculoContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskVerificarEstadoDoVeiculoContext;
    }

    public TaskVerificarEstadoDoVeiculoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskVerificarEstadoDoVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        empresaVeiculoDTO.setEstadoVeiculo(
            taskVerificarEstadoDoVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getEstadoVeiculo()
        );
        empresaVeiculoDTO.setObsEstadoVeiculo(
            taskVerificarEstadoDoVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getObsEstadoVeiculo()
        );
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext) {
        save(taskVerificarEstadoDoVeiculoContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskVerificarEstadoDoVeiculoContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskVerificarEstadoDoVeiculoContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
