package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.CarroProcessService;
import com.mycompany.myapp.service.CarroService;
import com.mycompany.myapp.service.dto.CarroDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Component
public class CalcularParcelaDelegate implements JavaDelegate {

    @Autowired
    CarroService carroService;

    @Autowired
    CarroProcessService carroProcessService;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String businessKey = delegateExecution.getBusinessKey();
        String idCarro[] = businessKey.split("#");
        Optional<CarroDTO> carro = carroService.findOne(Long.valueOf(idCarro[1]));

        carro.get().setJuros(gerarJuros());

        BigDecimal valorFinalEntrada = carro.get().getValorTotalCarro().subtract(carro.get().getEntrada());

        if (carro.get().getJuros().compareTo(BigDecimal.valueOf(1)) < 0) {
            carro.get().setJuros(carro.get().getJuros().add(BigDecimal.valueOf(1)));
        }

        carro.get().setValorParcela((valorFinalEntrada.multiply(carro.get().getJuros()))
            .divide(BigDecimal.valueOf(carro.get().getParcelas()), RoundingMode.UP));

        carroService.save(carro.get());

    }

    public BigDecimal gerarJuros() {
        BigDecimal juros = BigDecimal.valueOf(Math.random() * 3).setScale(2, RoundingMode.UP);
        return juros;
    }
}
