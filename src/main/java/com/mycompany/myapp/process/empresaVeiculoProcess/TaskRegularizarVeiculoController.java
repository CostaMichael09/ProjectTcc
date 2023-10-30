package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-regularizar-veiculo")
public class TaskRegularizarVeiculoController {

    private final Logger log = LoggerFactory.getLogger(TaskRegularizarVeiculoController.class);

    private final TaskRegularizarVeiculoService taskRegularizarVeiculoService;

    public TaskRegularizarVeiculoController(TaskRegularizarVeiculoService taskRegularizarVeiculoService) {
        this.taskRegularizarVeiculoService = taskRegularizarVeiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRegularizarVeiculoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext = taskRegularizarVeiculoService.loadContext(id);
        return ResponseEntity.ok(taskRegularizarVeiculoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRegularizarVeiculoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext = taskRegularizarVeiculoService.claim(id);
        return ResponseEntity.ok(taskRegularizarVeiculoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRegularizarVeiculoContextDTO taskRegularizarVeiculoContext) {
        log.debug(
            "REST request to complete EmpresaVeiculoProcess.TaskRegularizarVeiculo {}",
            taskRegularizarVeiculoContext.getTaskInstance().getId()
        );
        taskRegularizarVeiculoService.complete(taskRegularizarVeiculoContext);
        return ResponseEntity.noContent().build();
    }
}
