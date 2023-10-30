package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-incluir-fotos")
public class TaskIncluirFotosController {

    private final Logger log = LoggerFactory.getLogger(TaskIncluirFotosController.class);

    private final TaskIncluirFotosService taskIncluirFotosService;

    public TaskIncluirFotosController(TaskIncluirFotosService taskIncluirFotosService) {
        this.taskIncluirFotosService = taskIncluirFotosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskIncluirFotosContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskIncluirFotosContextDTO taskIncluirFotosContext = taskIncluirFotosService.loadContext(id);
        return ResponseEntity.ok(taskIncluirFotosContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskIncluirFotosContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskIncluirFotosContextDTO taskIncluirFotosContext = taskIncluirFotosService.claim(id);
        return ResponseEntity.ok(taskIncluirFotosContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskIncluirFotosContextDTO taskIncluirFotosContext) {
        log.debug("REST request to complete EmpresaVeiculoProcess.TaskIncluirFotos {}", taskIncluirFotosContext.getTaskInstance().getId());
        taskIncluirFotosService.complete(taskIncluirFotosContext);
        return ResponseEntity.noContent().build();
    }
}
