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
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.nomeCliente')">nomeCliente</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="nomeCliente"
                id="carro-nomeCliente"
                data-cy="nomeCliente"
                v-model="taskContext.carroProcess.carro.nomeCliente"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.nomeVendedor')">nomeVendedor</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="nomeVendedor"
                id="carro-nomeVendedor"
                data-cy="nomeVendedor"
                v-model="taskContext.carroProcess.carro.nomeVendedor"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="startDate"
                id="carro-startDate"
                data-cy="startDate"
                v-model="taskContext.carroProcess.carro.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.marcaCarro')">marcaCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="marcaCarro"
                id="carro-marcaCarro"
                data-cy="marcaCarro"
                v-model="taskContext.carroProcess.carro.marcaCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.anoCarro')">anoCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="anoCarro"
                id="carro-anoCarro"
                data-cy="anoCarro"
                v-model="taskContext.carroProcess.carro.anoCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.modeloCarro')">modeloCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="modeloCarro"
                id="carro-modeloCarro"
                data-cy="modeloCarro"
                v-model="taskContext.carroProcess.carro.modeloCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.gnv')">gnv</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="gnv"
                id="carro-gnv"
                data-cy="gnv"
                v-model="taskContext.carroProcess.carro.gnv"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.valorTotalCarro')">valorTotalCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="valorTotalCarro"
                id="carro-valorTotalCarro"
                data-cy="valorTotalCarro"
                v-model="taskContext.carroProcess.carro.valorTotalCarro"
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
          :to="`/process-definition/CarroProcess/task/EscolherVeiculo/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./escolher-veiculo-details.component.ts"></script>
