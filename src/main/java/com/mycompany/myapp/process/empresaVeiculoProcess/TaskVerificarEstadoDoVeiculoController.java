package com.mycompany.myapp.process.empresaVeiculoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa-veiculo-process/task-verificar-estado-do-veiculo")
public class TaskVerificarEstadoDoVeiculoController {

    private final Logger log = LoggerFactory.getLogger(TaskVerificarEstadoDoVeiculoController.class);

    private final TaskVerificarEstadoDoVeiculoService taskVerificarEstadoDoVeiculoService;

    public TaskVerificarEstadoDoVeiculoController(TaskVerificarEstadoDoVeiculoService taskVerificarEstadoDoVeiculoService) {
        this.taskVerificarEstadoDoVeiculoService = taskVerificarEstadoDoVeiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskVerificarEstadoDoVeiculoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext = taskVerificarEstadoDoVeiculoService.loadContext(id);
        return ResponseEntity.ok(taskVerificarEstadoDoVeiculoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskVerificarEstadoDoVeiculoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext = taskVerificarEstadoDoVeiculoService.claim(id);
        return ResponseEntity.ok(taskVerificarEstadoDoVeiculoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskVerificarEstadoDoVeiculoContextDTO taskVerificarEstadoDoVeiculoContext) {
        log.debug(
            "REST request to complete EmpresaVeiculoProcess.TaskVerificarEstadoDoVeiculo {}",
            taskVerificarEstadoDoVeiculoContext.getTaskInstance().getId()
        );
        taskVerificarEstadoDoVeiculoService.complete(taskVerificarEstadoDoVeiculoContext);
        return ResponseEntity.noContent().build();
    }
}
