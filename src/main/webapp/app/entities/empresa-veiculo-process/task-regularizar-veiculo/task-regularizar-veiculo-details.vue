<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('newProjectApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskRegularizarVeiculo.renavam')">renavam</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="renavam"
                id="empresa-veiculo-renavam"
                data-cy="renavam"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.renavam"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskRegularizarVeiculo.placa')">placa</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="placa"
                id="empresa-veiculo-placa"
                data-cy="placa"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.placa"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskRegularizarVeiculo.docRegular')">docRegular</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="docRegular"
                id="empresa-veiculo-docRegular"
                data-cy="docRegular"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskRegularizarVeiculo.multa')">multa</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="multa"
                id="empresa-veiculo-multa"
                data-cy="multa"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.multa"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/EmpresaVeiculoProcess/task/TaskRegularizarVeiculo/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-regularizar-veiculo-details.component.ts"></script>
