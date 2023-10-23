package com.mycompany.myapp.process.carroProcess;

import com.mycompany.myapp.service.dto.CarroProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class EscolherVeiculoContextDTO {

    private CarroProcessDTO carroProcess;
    private TaskInstanceDTO taskInstance;

    public CarroProcessDTO getCarroProcess() {
        return carroProcess;
    }

    public void setCarroProcess(CarroProcessDTO carroProcess) {
        this.carroProcess = carroProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
