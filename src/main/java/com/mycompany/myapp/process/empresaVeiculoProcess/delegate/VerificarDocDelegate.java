package com.mycompany.myapp.process.empresaVeiculoProcess.delegate;

import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.service.EmpresaVeiculoService;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;
import java.util.Optional;
import java.util.Random;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificarDocDelegate implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(VerificarDocDelegate.class);

    @Autowired
    private EmpresaVeiculoService empresaVeiculoService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String businessKey = delegateExecution.getBusinessKey();
        String idVeiculo[] = businessKey.split("#");

        Optional<EmpresaVeiculoDTO> empresaVeiculoDTO = empresaVeiculoService.findOne(Long.valueOf(idVeiculo[1]));

        if (empresaVeiculoDTO.isPresent()) {
            Random random = new Random();
            empresaVeiculoDTO.get().setDocRegular(random.nextBoolean());
            empresaVeiculoService.save(empresaVeiculoDTO.get());
        } else {
            log.info("Veiculo nao encontrado no VerificarDocDelegate");
        }
    }
}
