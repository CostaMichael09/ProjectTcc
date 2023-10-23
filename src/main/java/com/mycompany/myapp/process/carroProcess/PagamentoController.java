package com.mycompany.myapp.process.carroProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carro-process/pagamento")
public class PagamentoController {

    private final Logger log = LoggerFactory.getLogger(PagamentoController.class);

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        PagamentoContextDTO pagamentoContext = pagamentoService.loadContext(id);
        return ResponseEntity.ok(pagamentoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<PagamentoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        PagamentoContextDTO pagamentoContext = pagamentoService.claim(id);
        return ResponseEntity.ok(pagamentoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody PagamentoContextDTO pagamentoContext) {
        log.debug("REST request to complete CarroProcess.Pagamento {}", pagamentoContext.getTaskInstance().getId());
        pagamentoService.complete(pagamentoContext);
        return ResponseEntity.noContent().build();
    }
}
