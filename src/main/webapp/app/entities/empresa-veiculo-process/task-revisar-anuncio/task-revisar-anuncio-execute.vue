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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.renavam')" for="task-revisar-anuncio-renavam"
                >Renavam</label
              >
              <input
                type="text"
                class="form-control"
                name="renavam"
                id="task-revisar-anuncio-renavam"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.placa')" for="task-revisar-anuncio-placa"
                >Placa</label
              >
              <input
                type="text"
                class="form-control"
                name="placa"
                id="task-revisar-anuncio-placa"
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
                v-text="$t('newProjectApp.taskRevisarAnuncio.docRegular')"
                for="task-revisar-anuncio-docRegular"
                >Doc Regular</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="docRegular"
                id="task-revisar-anuncio-docRegular"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.multa')" for="task-revisar-anuncio-multa"
                >Multa</label
              >
              <input
                type="number"
                class="form-control"
                name="multa"
                id="task-revisar-anuncio-multa"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.marca')" for="task-revisar-anuncio-marca"
                >Marca</label
              >
              <input
                type="text"
                class="form-control"
                name="marca"
                id="task-revisar-anuncio-marca"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.modelo')" for="task-revisar-anuncio-modelo"
                >Modelo</label
              >
              <input
                type="text"
                class="form-control"
                name="modelo"
                id="task-revisar-anuncio-modelo"
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
                v-text="$t('newProjectApp.taskRevisarAnuncio.anoFabricacao')"
                for="task-revisar-anuncio-anoFabricacao"
                >Ano Fabricacao</label
              >
              <input
                type="number"
                class="form-control"
                name="anoFabricacao"
                id="task-revisar-anuncio-anoFabricacao"
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
                v-text="$t('newProjectApp.taskRevisarAnuncio.anoModelo')"
                for="task-revisar-anuncio-anoModelo"
                >Ano Modelo</label
              >
              <input
                type="number"
                class="form-control"
                name="anoModelo"
                id="task-revisar-anuncio-anoModelo"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.cor')" for="task-revisar-anuncio-cor"
                >Cor</label
              >
              <input
                type="text"
                class="form-control"
                name="cor"
                id="task-revisar-anuncio-cor"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskRevisarAnuncio.preco')" for="task-revisar-anuncio-preco"
                >Preco</label
              >
              <input
                type="number"
                class="form-control"
                name="preco"
                id="task-revisar-anuncio-preco"
                readonly
                data-cy="preco"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskRevisarAnuncio.anuncioAprovado')"
                for="task-revisar-anuncio-anuncioAprovado"
                >Anuncio Aprovado</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="anuncioAprovado"
                id="task-revisar-anuncio-anuncioAprovado"
                data-cy="anuncioAprovado"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado.$model"
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

<script lang="ts" src="./task-revisar-anuncio-execute.component.ts"></script>
