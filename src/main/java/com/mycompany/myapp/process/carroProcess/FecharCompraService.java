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
public class FecharCompraService {

    private final TaskInstanceService taskInstanceService;

    private final CarroService carroService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CarroProcessRepository carroProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final FecharCompraMapper fecharCompraMapper;

    private final CarroProcessMapper carroProcessMapper;

    public FecharCompraService(
        TaskInstanceService taskInstanceService,
        CarroService carroService,
        TaskInstanceRepository taskInstanceRepository,
        CarroProcessRepository carroProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        FecharCompraMapper fecharCompraMapper,
        CarroProcessMapper carroProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.carroService = carroService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.carroProcessRepository = carroProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.fecharCompraMapper = fecharCompraMapper;
        this.carroProcessMapper = carroProcessMapper;
    }

    public FecharCompraContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(fecharCompraMapper::toCarroProcessDTO)
            .orElseThrow();

        FecharCompraContextDTO fecharCompraContext = new FecharCompraContextDTO();
        fecharCompraContext.setTaskInstance(taskInstanceDTO);
        fecharCompraContext.setCarroProcess(carroProcess);

        return fecharCompraContext;
    }

    public FecharCompraContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(FecharCompraContextDTO fecharCompraContext) {
        CarroDTO carroDTO = carroService.findOne(fecharCompraContext.getCarroProcess().getCarro().getId()).orElseThrow();
        carroDTO.setNomeCliente(fecharCompraContext.getCarroProcess().getCarro().getNomeCliente());
        carroDTO.setNomeVendedor(fecharCompraContext.getCarroProcess().getCarro().getNomeVendedor());
        carroDTO.setMarcaCarro(fecharCompraContext.getCarroProcess().getCarro().getMarcaCarro());
        carroDTO.setAnoCarro(fecharCompraContext.getCarroProcess().getCarro().getAnoCarro());
        carroDTO.setModeloCarro(fecharCompraContext.getCarroProcess().getCarro().getModeloCarro());
        carroDTO.setValorTotalCarro(fecharCompraContext.getCarroProcess().getCarro().getValorTotalCarro());
        carroDTO.setFormaPagamento(fecharCompraContext.getCarroProcess().getCarro().getFormaPagamento());
        carroDTO.setEntrada(fecharCompraContext.getCarroProcess().getCarro().getEntrada());
        carroDTO.setParcelas(fecharCompraContext.getCarroProcess().getCarro().getParcelas());
        carroDTO.setValorParcela(fecharCompraContext.getCarroProcess().getCarro().getValorParcela());
        carroDTO.setJuros(fecharCompraContext.getCarroProcess().getCarro().getJuros());
        carroDTO.setRua(fecharCompraContext.getCarroProcess().getCarro().getRua());
        carroDTO.setBairro(fecharCompraContext.getCarroProcess().getCarro().getBairro());
        carroDTO.setCidade(fecharCompraContext.getCarroProcess().getCarro().getCidade());
        carroDTO.setCep(fecharCompraContext.getCarroProcess().getCarro().getCep());
        carroService.save(carroDTO);
    }

    public void complete(FecharCompraContextDTO fecharCompraContext) {
        save(fecharCompraContext);
        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(fecharCompraContext.getCarroProcess().getProcessInstance().getId())
            .map(carroProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(fecharCompraContext.getTaskInstance(), carroProcess);
    }
}
