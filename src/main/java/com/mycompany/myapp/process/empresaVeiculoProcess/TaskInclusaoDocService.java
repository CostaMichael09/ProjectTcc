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
public class TaskInclusaoDocService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskInclusaoDocMapper taskInclusaoDocMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskInclusaoDocService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskInclusaoDocMapper taskInclusaoDocMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskInclusaoDocMapper = taskInclusaoDocMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskInclusaoDocContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskInclusaoDocMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskInclusaoDocContextDTO taskInclusaoDocContext = new TaskInclusaoDocContextDTO();
        taskInclusaoDocContext.setTaskInstance(taskInstanceDTO);
        taskInclusaoDocContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskInclusaoDocContext;
    }

    public TaskInclusaoDocContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskInclusaoDocContextDTO taskInclusaoDocContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        empresaVeiculoDTO.setRenavam(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getRenavam());
        empresaVeiculoDTO.setPlaca(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPlaca());
        empresaVeiculoDTO.setDocRegular(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getDocRegular());
        empresaVeiculoDTO.setMulta(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMulta());
        empresaVeiculoDTO.setMarca(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMarca());
        empresaVeiculoDTO.setModelo(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getModelo());
        empresaVeiculoDTO.setAnoFabricacao(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoFabricacao());
        empresaVeiculoDTO.setAnoModelo(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoModelo());
        empresaVeiculoDTO.setCor(taskInclusaoDocContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getCor());
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskInclusaoDocContextDTO taskInclusaoDocContext) {
        save(taskInclusaoDocContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInclusaoDocContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskInclusaoDocContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
