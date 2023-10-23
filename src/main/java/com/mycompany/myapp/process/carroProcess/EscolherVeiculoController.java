package com.mycompany.myapp.process.carroProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carro-process/escolher-veiculo")
public class EscolherVeiculoController {

    private final Logger log = LoggerFactory.getLogger(EscolherVeiculoController.class);

    private final EscolherVeiculoService escolherVeiculoService;

    public EscolherVeiculoController(EscolherVeiculoService escolherVeiculoService) {
        this.escolherVeiculoService = escolherVeiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolherVeiculoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        EscolherVeiculoContextDTO escolherVeiculoContext = escolherVeiculoService.loadContext(id);
        return ResponseEntity.ok(escolherVeiculoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<EscolherVeiculoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        EscolherVeiculoContextDTO escolherVeiculoContext = escolherVeiculoService.claim(id);
        return ResponseEntity.ok(escolherVeiculoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody EscolherVeiculoContextDTO escolherVeiculoContext) {
        log.debug("REST request to complete CarroProcess.EscolherVeiculo {}", escolherVeiculoContext.getTaskInstance().getId());
        escolherVeiculoService.complete(escolherVeiculoContext);
        return ResponseEntity.noContent().build();
    }
}
