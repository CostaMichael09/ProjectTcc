package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-aprovar-fotos")
public class TaskAprovarFotosController {

    private final Logger log = LoggerFactory.getLogger(TaskAprovarFotosController.class);

    private final TaskAprovarFotosService taskAprovarFotosService;

    public TaskAprovarFotosController(TaskAprovarFotosService taskAprovarFotosService) {
        this.taskAprovarFotosService = taskAprovarFotosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskAprovarFotosContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAprovarFotosContextDTO taskAprovarFotosContext = taskAprovarFotosService.loadContext(id);
        return ResponseEntity.ok(taskAprovarFotosContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskAprovarFotosContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAprovarFotosContextDTO taskAprovarFotosContext = taskAprovarFotosService.claim(id);
        return ResponseEntity.ok(taskAprovarFotosContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskAprovarFotosContextDTO taskAprovarFotosContext) {
        log.debug("REST request to complete EmpresaVeiculoProcess.TaskAprovarFotos {}", taskAprovarFotosContext.getTaskInstance().getId());
        taskAprovarFotosService.complete(taskAprovarFotosContext);
        return ResponseEntity.noContent().build();
    }
}
