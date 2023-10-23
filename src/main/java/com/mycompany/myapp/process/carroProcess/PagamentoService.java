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
public class PagamentoService {

    private final TaskInstanceService taskInstanceService;

    private final CarroService carroService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CarroProcessRepository carroProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final PagamentoMapper pagamentoMapper;

    private final CarroProcessMapper carroProcessMapper;

    public PagamentoService(
        TaskInstanceService taskInstanceService,
        CarroService carroService,
        TaskInstanceRepository taskInstanceRepository,
        CarroProcessRepository carroProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        PagamentoMapper pagamentoMapper,
        CarroProcessMapper carroProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.carroService = carroService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.carroProcessRepository = carroProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.pagamentoMapper = pagamentoMapper;
        this.carroProcessMapper = carroProcessMapper;
    }

    public PagamentoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(pagamentoMapper::toCarroProcessDTO)
            .orElseThrow();

        PagamentoContextDTO pagamentoContext = new PagamentoContextDTO();
        pagamentoContext.setTaskInstance(taskInstanceDTO);
        pagamentoContext.setCarroProcess(carroProcess);

        return pagamentoContext;
    }

    public PagamentoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(PagamentoContextDTO pagamentoContext) {
        CarroDTO carroDTO = carroService.findOne(pagamentoContext.getCarroProcess().getCarro().getId()).orElseThrow();
        carroDTO.setNomeCliente(pagamentoContext.getCarroProcess().getCarro().getNomeCliente());
        carroDTO.setNomeVendedor(pagamentoContext.getCarroProcess().getCarro().getNomeVendedor());
        carroDTO.setMarcaCarro(pagamentoContext.getCarroProcess().getCarro().getMarcaCarro());
        carroDTO.setAnoCarro(pagamentoContext.getCarroProcess().getCarro().getAnoCarro());
        carroDTO.setModeloCarro(pagamentoContext.getCarroProcess().getCarro().getModeloCarro());
        carroDTO.setValorTotalCarro(pagamentoContext.getCarroProcess().getCarro().getValorTotalCarro());
        carroDTO.setFormaPagamento(pagamentoContext.getCarroProcess().getCarro().getFormaPagamento());
        carroDTO.setParcelas(pagamentoContext.getCarroProcess().getCarro().getParcelas());
        carroDTO.setEntrada(pagamentoContext.getCarroProcess().getCarro().getEntrada());
        carroService.save(carroDTO);
    }

    public void complete(PagamentoContextDTO pagamentoContext) {
        save(pagamentoContext);
        CarroProcessDTO carroProcess = carroProcessRepository
            .findByProcessInstanceId(pagamentoContext.getCarroProcess().getProcessInstance().getId())
            .map(carroProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(pagamentoContext.getTaskInstance(), carroProcess);
    }
}
