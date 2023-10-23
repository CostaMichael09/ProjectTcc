package com.mycompany.myapp.process.carroProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carro-process/fechar-compra")
public class FecharCompraController {

    private final Logger log = LoggerFactory.getLogger(FecharCompraController.class);

    private final FecharCompraService fecharCompraService;

    public FecharCompraController(FecharCompraService fecharCompraService) {
        this.fecharCompraService = fecharCompraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FecharCompraContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FecharCompraContextDTO fecharCompraContext = fecharCompraService.loadContext(id);
        return ResponseEntity.ok(fecharCompraContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<FecharCompraContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        FecharCompraContextDTO fecharCompraContext = fecharCompraService.claim(id);
        return ResponseEntity.ok(fecharCompraContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody FecharCompraContextDTO fecharCompraContext) {
        log.debug("REST request to complete CarroProcess.FecharCompra {}", fecharCompraContext.getTaskInstance().getId());
        fecharCompraService.complete(fecharCompraContext);
        return ResponseEntity.noContent().build();
    }
}
