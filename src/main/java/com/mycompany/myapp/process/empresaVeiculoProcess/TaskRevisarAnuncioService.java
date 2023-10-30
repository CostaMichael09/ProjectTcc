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
public class TaskRevisarAnuncioService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRevisarAnuncioMapper taskRevisarAnuncioMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskRevisarAnuncioService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRevisarAnuncioMapper taskRevisarAnuncioMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRevisarAnuncioMapper = taskRevisarAnuncioMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskRevisarAnuncioContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRevisarAnuncioMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext = new TaskRevisarAnuncioContextDTO();
        taskRevisarAnuncioContext.setTaskInstance(taskInstanceDTO);
        taskRevisarAnuncioContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskRevisarAnuncioContext;
    }

    public TaskRevisarAnuncioContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        empresaVeiculoDTO.setRenavam(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getRenavam());
        empresaVeiculoDTO.setPlaca(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPlaca());
        empresaVeiculoDTO.setDocRegular(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getDocRegular());
        empresaVeiculoDTO.setMulta(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMulta());
        empresaVeiculoDTO.setMarca(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMarca());
        empresaVeiculoDTO.setModelo(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getModelo());
        empresaVeiculoDTO.setAnoFabricacao(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoFabricacao());
        empresaVeiculoDTO.setAnoModelo(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoModelo());
        empresaVeiculoDTO.setCor(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getCor());
        empresaVeiculoDTO.setPreco(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPreco());
        empresaVeiculoDTO.setAnuncioAprovado(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnuncioAprovado());
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext) {
        save(taskRevisarAnuncioContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskRevisarAnuncioContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRevisarAnuncioContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
