package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-inclusao-doc")
public class TaskInclusaoDocController {

    private final Logger log = LoggerFactory.getLogger(TaskInclusaoDocController.class);

    private final TaskInclusaoDocService taskInclusaoDocService;

    public TaskInclusaoDocController(TaskInclusaoDocService taskInclusaoDocService) {
        this.taskInclusaoDocService = taskInclusaoDocService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskInclusaoDocContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskInclusaoDocContextDTO taskInclusaoDocContext = taskInclusaoDocService.loadContext(id);
        return ResponseEntity.ok(taskInclusaoDocContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskInclusaoDocContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskInclusaoDocContextDTO taskInclusaoDocContext = taskInclusaoDocService.claim(id);
        return ResponseEntity.ok(taskInclusaoDocContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskInclusaoDocContextDTO taskInclusaoDocContext) {
        log.debug("REST request to complete EmpresaVeiculoProcess.TaskInclusaoDoc {}", taskInclusaoDocContext.getTaskInstance().getId());
        taskInclusaoDocService.complete(taskInclusaoDocContext);
        return ResponseEntity.noContent().build();
    }
}
