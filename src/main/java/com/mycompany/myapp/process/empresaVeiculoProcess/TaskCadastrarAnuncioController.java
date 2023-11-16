package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-cadastrar-anuncio")
public class TaskCadastrarAnuncioController {

    private final Logger log = LoggerFactory.getLogger(TaskCadastrarAnuncioController.class);

    private final TaskCadastrarAnuncioService taskCadastrarAnuncioService;

    public TaskCadastrarAnuncioController(TaskCadastrarAnuncioService taskCadastrarAnuncioService) {
        this.taskCadastrarAnuncioService = taskCadastrarAnuncioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskCadastrarAnuncioContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext = taskCadastrarAnuncioService.loadContext(id);
        return ResponseEntity.ok(taskCadastrarAnuncioContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskCadastrarAnuncioContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext = taskCadastrarAnuncioService.claim(id);
        return ResponseEntity.ok(taskCadastrarAnuncioContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskCadastrarAnuncioContextDTO taskCadastrarAnuncioContext) {
        log.debug(
            "REST request to complete EmpresaVeiculoProcess.TaskCadastrarAnuncio {}",
            taskCadastrarAnuncioContext.getTaskInstance().getId()
        );
        taskCadastrarAnuncioService.complete(taskCadastrarAnuncioContext);
        return ResponseEntity.noContent().build();
    }
}
