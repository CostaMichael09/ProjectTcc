package com.mycompany.myapp.process.carroProcess;

import com.mycompany.myapp.repository.CarroProcessRepository;
import com.mycompany.myapp.service.CarroService;
import com.mycompany.myapp.service.dto.CarroDTO;
import com.mycompany.myapp.service.dto.CarroProcessDTO;
import com.mycompany.myapp.service.mapper.CarroProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class EscolherVeiculoService {

    private final TaskInstanceService taskInstanceService;

    private final CarroService carroService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CarroProcessRepository carroProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final EscolherVeiculoMapper escolherVeiculoMapper;

    private final CarroProcessMapper carroProcessMapper;

    public EscolherVeiculoService(
        TaskInstanceService taskInstanceService,
        CarroService carroService,
        TaskInstanceRepository taskInstanceRepository,
        CarroProcessRepository carroProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        EscolherVeiculoMapper escolherVeiculoMapper,
        CarroProcessMapper carroProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.carroService = carroService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.carroProcessRepository = carroProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.escolherVeiculoMapper = escolherVeiculoMapper;
        this.carroProcessMapper = carroProcessMapper;
    }

    public EscolherVeiculoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(escolherVeiculoMapper::toCarroProcessDTO)
            .orElseThrow();

        EscolherVeiculoContextDTO escolherVeiculoContext = new EscolherVeiculoContextDTO();
        escolherVeiculoContext.setTaskInstance(taskInstanceDTO);
        escolherVeiculoContext.setCarroProcess(carroProcess);

        return escolherVeiculoContext;
    }

    public EscolherVeiculoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(EscolherVeiculoContextDTO escolherVeiculoContext) {
        CarroDTO carroDTO = carroService.findOne(escolherVeiculoContext.getCarroProcess().getCarro().getId()).orElseThrow();
        carroDTO.setNomeCliente(escolherVeiculoContext.getCarroProcess().getCarro().getNomeCliente());
        carroDTO.setNomeVendedor(escolherVeiculoContext.getCarroProcess().getCarro().getNomeVendedor());
        carroDTO.setStartDate(escolherVeiculoContext.getCarroProcess().getCarro().getStartDate());
        carroDTO.setMarcaCarro(escolherVeiculoContext.getCarroProcess().getCarro().getMarcaCarro());
        carroDTO.setAnoCarro(escolherVeiculoContext.getCarroProcess().getCarro().getAnoCarro());
        carroDTO.setModeloCarro(escolherVeiculoContext.getCarroProcess().getCarro().getModeloCarro());
        carroDTO.setGnv(escolherVeiculoContext.getCarroProcess().getCarro().getGnv());
        carroDTO.setValorTotalCarro(escolherVeiculoContext.getCarroProcess().getCarro().getValorTotalCarro());
        carroService.save(carroDTO);
    }

    public void complete(EscolherVeiculoContextDTO escolherVeiculoContext) {
        save(escolherVeiculoContext);
        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(escolherVeiculoContext.getCarroProcess().getProcessInstance().getId())
            .map(carroProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(escolherVeiculoContext.getTaskInstance(), carroProcess);
    }
}
