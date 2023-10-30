package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-revisar-anuncio")
public class TaskRevisarAnuncioController {

    private final Logger log = LoggerFactory.getLogger(TaskRevisarAnuncioController.class);

    private final TaskRevisarAnuncioService taskRevisarAnuncioService;

    public TaskRevisarAnuncioController(TaskRevisarAnuncioService taskRevisarAnuncioService) {
        this.taskRevisarAnuncioService = taskRevisarAnuncioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRevisarAnuncioContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext = taskRevisarAnuncioService.loadContext(id);
        return ResponseEntity.ok(taskRevisarAnuncioContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRevisarAnuncioContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext = taskRevisarAnuncioService.claim(id);
        return ResponseEntity.ok(taskRevisarAnuncioContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRevisarAnuncioContextDTO taskRevisarAnuncioContext) {
        log.debug(
            "REST request to complete EmpresaVeiculoProcess.TaskRevisarAnuncio {}",
            taskRevisarAnuncioContext.getTaskInstance().getId()
        );
        taskRevisarAnuncioService.complete(taskRevisarAnuncioContext);
        return ResponseEntity.noContent().build();
    }
}
