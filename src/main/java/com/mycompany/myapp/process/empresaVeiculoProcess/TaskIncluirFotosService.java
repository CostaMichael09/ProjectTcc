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
public class TaskIncluirFotosService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskIncluirFotosMapper taskIncluirFotosMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskIncluirFotosService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskIncluirFotosMapper taskIncluirFotosMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskIncluirFotosMapper = taskIncluirFotosMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskIncluirFotosContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskIncluirFotosMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskIncluirFotosContextDTO taskIncluirFotosContext = new TaskIncluirFotosContextDTO();
        taskIncluirFotosContext.setTaskInstance(taskInstanceDTO);
        taskIncluirFotosContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskIncluirFotosContext;
    }

    public TaskIncluirFotosContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskIncluirFotosContextDTO taskIncluirFotosContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskIncluirFotosContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        //        empresaVeiculoDTO.setFotos(taskIncluirFotosContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getFotos());
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskIncluirFotosContextDTO taskIncluirFotosContext) {
        save(taskIncluirFotosContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskIncluirFotosContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskIncluirFotosContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
