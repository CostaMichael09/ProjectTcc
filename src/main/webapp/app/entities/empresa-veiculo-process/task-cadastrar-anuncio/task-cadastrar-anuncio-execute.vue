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
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskCadastrarAnuncio.renavam')"
                for="task-cadastrar-anuncio-renavam"
                >Renavam</label
              >
              <input
                type="text"
                class="form-control"
                name="renavam"
                id="task-cadastrar-anuncio-renavam"
                readonly
                data-cy="renavam"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.renavam.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.renavam.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.renavam.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.placa')" for="task-cadastrar-anuncio-placa"
                >Placa</label
              >
              <input
                type="text"
                class="form-control"
                name="placa"
                id="task-cadastrar-anuncio-placa"
                readonly
                data-cy="placa"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.placa.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.placa.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.placa.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskCadastrarAnuncio.docRegular')"
                for="task-cadastrar-anuncio-docRegular"
                >Doc Regular</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="docRegular"
                id="task-cadastrar-anuncio-docRegular"
                readonly
                data-cy="docRegular"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.multa')" for="task-cadastrar-anuncio-multa"
                >Multa</label
              >
              <input
                type="number"
                class="form-control"
                name="multa"
                id="task-cadastrar-anuncio-multa"
                readonly
                data-cy="multa"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.marca')" for="task-cadastrar-anuncio-marca"
                >Marca</label
              >
              <input
                type="text"
                class="form-control"
                name="marca"
                id="task-cadastrar-anuncio-marca"
                readonly
                data-cy="marca"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.modelo')" for="task-cadastrar-anuncio-modelo"
                >Modelo</label
              >
              <input
                type="text"
                class="form-control"
                name="modelo"
                id="task-cadastrar-anuncio-modelo"
                readonly
                data-cy="modelo"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskCadastrarAnuncio.anoFabricacao')"
                for="task-cadastrar-anuncio-anoFabricacao"
                >Ano Fabricacao</label
              >
              <input
                type="number"
                class="form-control"
                name="anoFabricacao"
                id="task-cadastrar-anuncio-anoFabricacao"
                readonly
                data-cy="anoFabricacao"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskCadastrarAnuncio.anoModelo')"
                for="task-cadastrar-anuncio-anoModelo"
                >Ano Modelo</label
              >
              <input
                type="number"
                class="form-control"
                name="anoModelo"
                id="task-cadastrar-anuncio-anoModelo"
                readonly
                data-cy="anoModelo"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.cor')" for="task-cadastrar-anuncio-cor"
                >Cor</label
              >
              <input
                type="text"
                class="form-control"
                name="cor"
                id="task-cadastrar-anuncio-cor"
                readonly
                data-cy="cor"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.preco')" for="task-cadastrar-anuncio-preco"
                >Preco</label
              >
              <input
                type="number"
                class="form-control"
                name="preco"
                id="task-cadastrar-anuncio-preco"
                data-cy="preco"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$model"
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

<script lang="ts" src="./task-cadastrar-anuncio-execute.component.ts"></script>
