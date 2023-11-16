<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('newProjectApp.taskInclusaoDoc.home.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.renavam')">renavam</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.placa')">placa</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.docRegular')">docRegular</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.multa')">multa</label>
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
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.marca')">marca</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="marca"
                id="empresa-veiculo-marca"
                data-cy="marca"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.marca"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.modelo')">modelo</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="modelo"
                id="empresa-veiculo-modelo"
                data-cy="modelo"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.modelo"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.anoFabricacao')">anoFabricacao</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="anoFabricacao"
                id="empresa-veiculo-anoFabricacao"
                data-cy="anoFabricacao"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.anoModelo')">anoModelo</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="anoModelo"
                id="empresa-veiculo-anoModelo"
                data-cy="anoModelo"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.cor')">cor</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="cor"
                id="empresa-veiculo-cor"
                data-cy="cor"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.cor"
              />
            </div>
            <pdf
              :view="true"
              :empresaVeiculoProcess="taskContext.empresaVeiculoProcess"></pdf>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/EmpresaVeiculoProcess/task/TaskInclusaoDoc/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-inclusao-doc-details.component.ts"></script>
