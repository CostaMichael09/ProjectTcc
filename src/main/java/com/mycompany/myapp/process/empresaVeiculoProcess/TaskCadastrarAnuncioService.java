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
public class TaskCadastrarAnuncioService {

    private final TaskInstanceService taskInstanceService;

    private final EmpresaVeiculoService empresaVeiculoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskCadastrarAnuncioMapper taskCadastrarAnuncioMapper;

    private final EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper;

    public TaskCadastrarAnuncioService(
        TaskInstanceService taskInstanceService,
        EmpresaVeiculoService empresaVeiculoService,
        TaskInstanceRepository taskInstanceRepository,
        EmpresaVeiculoProcessRepository empresaVeiculoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskCadastrarAnuncioMapper taskCadastrarAnuncioMapper,
        EmpresaVeiculoProcessMapper empresaVeiculoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.empresaVeiculoService = empresaVeiculoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.empresaVeiculoProcessRepository = empresaVeiculoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskCadastrarAnuncioMapper = taskCadastrarAnuncioMapper;
        this.empresaVeiculoProcessMapper = empresaVeiculoProcessMapper;
    }

    public TaskCadastrarAnuncioContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskCadastrarAnuncioMapper::toEmpresaVeiculoProcessDTO)
            .orElseThrow();

        TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext = new TaskCadastrarAnuncioContextDTO();
        taskCadastrarAnuncioContext.setTaskInstance(taskInstanceDTO);
        taskCadastrarAnuncioContext.setEmpresaVeiculoProcess(empresaVeiculoProcess);

        return taskCadastrarAnuncioContext;
    }

    public TaskCadastrarAnuncioContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext) {
        EmpresaVeiculoDTO empresaVeiculoDTO = empresaVeiculoService
            .findOne(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getId())
            .orElseThrow();
        empresaVeiculoDTO.setRenavam(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getRenavam());
        empresaVeiculoDTO.setPlaca(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPlaca());
        empresaVeiculoDTO.setDocRegular(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getDocRegular());
        empresaVeiculoDTO.setMulta(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMulta());
        empresaVeiculoDTO.setMarca(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getMarca());
        empresaVeiculoDTO.setModelo(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getModelo());
        empresaVeiculoDTO.setAnoFabricacao(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoFabricacao());
        empresaVeiculoDTO.setAnoModelo(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getAnoModelo());
        empresaVeiculoDTO.setCor(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getCor());
        empresaVeiculoDTO.setPreco(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getEmpresaVeiculo().getPreco());
        empresaVeiculoService.save(empresaVeiculoDTO);
    }

    public void complete(TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext) {
        save(taskCadastrarAnuncioContext);
        EmpresaVeiculoProcessDTO empresaVeiculoProcess = empresaVeiculoProcessRepository
            .findByProcessInstanceId(taskCadastrarAnuncioContext.getEmpresaVeiculoProcess().getProcessInstance().getId())
            .map(empresaVeiculoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskCadastrarAnuncioContext.getTaskInstance(), empresaVeiculoProcess);
    }
}
