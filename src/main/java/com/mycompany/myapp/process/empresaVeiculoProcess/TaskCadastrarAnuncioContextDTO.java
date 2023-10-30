package com.mycompany.myapp.process.empresaVeiculoProcess;

import com.mycompany.myapp.service.dto.EmpresaVeiculoProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskCadastrarAnuncioContextDTO {

    private EmpresaVeiculoProcessDTO empresaVeiculoProcess;
    private TaskInstanceDTO taskInstance;

    public EmpresaVeiculoProcessDTO getEmpresaVeiculoProcess() {
        return empresaVeiculoProcess;
    }

    public void setEmpresaVeiculoProcess(EmpresaVeiculoProcessDTO empresaVeiculoProcess) {
        this.empresaVeiculoProcess = empresaVeiculoProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
