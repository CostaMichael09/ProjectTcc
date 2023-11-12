<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.home.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.estadoVeiculo')"
                >estadoVeiculo</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="estadoVeiculo"
                id="empresa-veiculo-estadoVeiculo"
                data-cy="estadoVeiculo"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.estadoVeiculo ? 'Bom' : 'Precisando de reparo'"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.obsEstadoVeiculo')" for="task-verificar-estado-do-veiculo-obsEstadoVeiculo">Obs Estado Veiculo</label>
              <textarea
                class="form-control"
                name="obsEstadoVeiculo"
                id="task-verificar-estado-do-veiculo-obsEstadoVeiculo"
                data-cy="obsEstadoVeiculo"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.obsEstadoVeiculo"
                rows="5"
                readonly
              ></textarea>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/EmpresaVeiculoProcess/task/TaskVerificarEstadoDoVeiculo/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-verificar-estado-do-veiculo-details.component.ts"></script>
