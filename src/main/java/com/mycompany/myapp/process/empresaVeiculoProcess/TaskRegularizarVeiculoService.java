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

@Component
public class TaskRegularizarVeiculoService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRegularizarVeiculoMapper taskRegularizarVeiculoMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskRegularizarVeiculoService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRegularizarVeiculoMapper taskRegularizarVeiculoMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRegularizarVeiculoMapper = taskRegularizarVeiculoMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskRegularizarVeiculoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRegularizarVeiculoMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext = new TaskRegularizarVeiculoContextDTO();
        taskRegularizarVeiculoContext.setTaskInstance(taskInstanceDTO);
        taskRegularizarVeiculoContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskRegularizarVeiculoContext;
    }

    public TaskRegularizarVeiculoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        empresaVeiculoDTO.setRenavam(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getRenavam());
        empresaVeiculoDTO.setPlaca(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPlaca());
        empresaVeiculoDTO.setDocRegular(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getDocRegular());
        empresaVeiculoDTO.setMulta(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMulta());
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext) {
        save(taskRegularizarVeiculoContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskRegularizarVeiculoContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRegularizarVeiculoContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
