<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('newProjectApp.taskCadastrarAnuncio.home.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.renavam')">renavam</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.placa')">placa</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.docRegular')">docRegular</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="docRegular"
                id="empresa-veiculo-docRegular"
                data-cy="docRegular"
                v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular ? 'Sim' : 'Não'"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.multa')">multa</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">R$</span>
                </div>
                <currency-input
                  id="task-regularizar-veiculo-multa"
                  class="form-control"
                  data-cy="multa"
                  v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.multa"
                  readonly
                  :currency="null"
                  :precision="2"
                  :auto-decimal-mode="false"
                  :allow-negative="false"
                />
              </div>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.marca')">marca</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.modelo')">modelo</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.anoFabricacao')">anoFabricacao</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.anoModelo')">anoModelo</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.cor')">cor</label>
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
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.preco')">preco</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">R$</span>
                </div>
                <currency-input
                  id="task-regularizar-veiculo-multa"
                  class="form-control"
                  data-cy="preco"
                  v-model="taskContext.empresaVeiculoProcess.empresaVeiculo.preco"
                  readonly
                  :currency="null"
                  :precision="2"
                  :auto-decimal-mode="false"
                  :allow-negative="false"
                />
              </div>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/EmpresaVeiculoProcess/task/TaskCadastrarAnuncio/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-cadastrar-anuncio-details.component.ts"></script>
