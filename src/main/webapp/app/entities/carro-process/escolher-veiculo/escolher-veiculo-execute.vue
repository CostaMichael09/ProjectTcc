<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('newProjectApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.nomeCliente')" for="escolher-veiculo-nomeCliente"
                >Nome Cliente</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCliente"
                id="escolher-veiculo-nomeCliente"
                readonly
                data-cy="nomeCliente"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.nomeCliente.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.nomeCliente.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.nomeCliente.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.escolherVeiculo.nomeVendedor')"
                for="escolher-veiculo-nomeVendedor"
                >Nome Vendedor</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeVendedor"
                id="escolher-veiculo-nomeVendedor"
                readonly
                data-cy="nomeVendedor"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.nomeVendedor.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.nomeVendedor.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.nomeVendedor.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.startDate')" for="escolher-veiculo-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="escolher-veiculo-startDate"
                  readonly
                  data-cy="startDate"
                  type="text"
                  class="form-control"
                  name="startDate"
                  :class="{
                    valid: !$v.taskContext.carroProcess.carro.startDate.$invalid,
                    invalid: $v.taskContext.carroProcess.carro.startDate.$invalid,
                  }"
                  v-model="$v.taskContext.carroProcess.carro.startDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.marcaCarro')" for="escolher-veiculo-marcaCarro"
                >Marca Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="marcaCarro"
                id="escolher-veiculo-marcaCarro"
                data-cy="marcaCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.marcaCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.marcaCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.marcaCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.anoCarro')" for="escolher-veiculo-anoCarro"
                >Ano Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="anoCarro"
                id="escolher-veiculo-anoCarro"
                data-cy="anoCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.anoCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.anoCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.anoCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.modeloCarro')" for="escolher-veiculo-modeloCarro"
                >Modelo Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="modeloCarro"
                id="escolher-veiculo-modeloCarro"
                data-cy="modeloCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.modeloCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.modeloCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.modeloCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.escolherVeiculo.gnv')" for="escolher-veiculo-gnv">Gnv</label>
              <input
                type="checkbox"
                class="form-check"
                name="gnv"
                id="escolher-veiculo-gnv"
                data-cy="gnv"
                :class="{ valid: !$v.taskContext.carroProcess.carro.gnv.$invalid, invalid: $v.taskContext.carroProcess.carro.gnv.$invalid }"
                v-model="$v.taskContext.carroProcess.carro.gnv.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.escolherVeiculo.valorTotalCarro')"
                for="escolher-veiculo-valorTotalCarro"
                >Valor Total Carro</label
              >
              <input
                type="number"
                class="form-control"
                name="valorTotalCarro"
                id="escolher-veiculo-valorTotalCarro"
                data-cy="valorTotalCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.valorTotalCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.valorTotalCarro.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.valorTotalCarro.$model"
              />
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

<script lang="ts" src="./escolher-veiculo-execute.component.ts"></script>
