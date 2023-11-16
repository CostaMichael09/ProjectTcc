<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.home.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.estadoVeiculo')" for="task-verificar-estado-do-veiculo-estadoVeiculo">Estado Veiculo</label>
              <select
                class="form-control"
                name="estadoVeiculo"
                id="task-verificar-estado-do-veiculo-estadoVeiculo"
                data-cy="estadoVeiculo"
                :class="{
      valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.estadoVeiculo.$invalid,
      invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.estadoVeiculo.$invalid,
    }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.estadoVeiculo.$model"
              >
                <option value="true">Bom</option>
                <option value="false">Precisando de Reparo</option>
              </select>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskVerificarEstadoDoVeiculo.obsEstadoVeiculo')" for="task-verificar-estado-do-veiculo-obsEstadoVeiculo">Obs Estado Veiculo</label>
              <textarea
                class="form-control"
                name="obsEstadoVeiculo"
                id="task-verificar-estado-do-veiculo-obsEstadoVeiculo"
                data-cy="obsEstadoVeiculo"
                :class="{
      valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.obsEstadoVeiculo.$invalid,
      invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.obsEstadoVeiculo.$invalid,
    }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.obsEstadoVeiculo.$model"
                rows="5"
              ></textarea>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-verificar-estado-do-veiculo-execute.component.ts"></script>
