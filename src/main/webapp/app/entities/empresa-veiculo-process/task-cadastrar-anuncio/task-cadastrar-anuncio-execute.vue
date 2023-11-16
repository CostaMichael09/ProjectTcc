<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('newProjectApp.taskCadastrarAnuncio.home.title')" id="task-instance-heading">Task Execution</span>
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
                readonly
                type="text"
                class="form-control"
                name="docRegular"
                id="empresa-veiculo-docRegular"
                data-cy="docRegular"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$model ? 'Sim' : 'Não'"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.multa')" for="task-cadastrar-anuncio-multa"
                >Multa</label
              >
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">R$</span>
                </div>
                <currency-input
                  id="task-regularizar-veiculo-multa"
                  class="form-control"
                  data-cy="multa"
                  v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$model"
                  readonly
                  :currency="null"
                  :precision="2"
                  :auto-decimal-mode="false"
                  :allow-negative="false"
                />
              </div>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskCadastrarAnuncio.marca')" for="task-cadastrar-anuncio-marca"
                >Marca</label
              >
              <select
                v-if="!taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                class="form-control"
                name="marca"
                id="task-inclusao-doc-marca"
                data-cy="marca"
                :class="{
      valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$invalid,
      invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$invalid,
    }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.marca.$model"
              >
                <option value="Fiat">Fiat</option>
                <option value="Ford">Ford</option>
                <option value="Chevrolet">Chevrolet</option>
                <option value="Volkswagen">Volkswagen</option>
                <option value="Citroen">Citroen</option>
                <option value="Renault">Renault</option>
                <option value="Peugeot">Peugeot</option>
                <option value="Toyota">Toyota</option>
                <option value="Honda">Honda</option>
              </select>
              <input
                v-else
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
                v-if="!taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                type="text"
                class="form-control"
                name="modelo"
                id="task-cadastrar-anuncio-modelo"
                data-cy="modelo"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$model"
              />
              <input
                v-else
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
                v-if="!taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                type="number"
                class="form-control"
                name="anoFabricacao"
                id="task-cadastrar-anuncio-anoFabricacao"
                data-cy="anoFabricacao"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$model"
              />
              <input
                v-else
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
              <select
                v-if="!taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                class="form-control"
                name="anoModelo"
                id="task-inclusao-doc-anoModelo"
                data-cy="anoModelo"
                :class="{
        valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$invalid,
        invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$invalid,
      }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoModelo.$model"
              >
                <option
                  v-for="year in availableYears"
                  :key="year"
                  :value="year"
                >{{ year }}</option>
              </select>
              <input
                v-else
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
                v-if="!taskContext.empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                type="text"
                class="form-control"
                name="cor"
                id="task-cadastrar-anuncio-cor"
                data-cy="cor"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$model"
              />
              <input
                v-else
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
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">R$</span>
                </div>
                <currency-input
                  id="task-regularizar-veiculo-multa"
                  class="form-control"
                  data-cy="preco"
                  v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.preco.$model"
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
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-cadastrar-anuncio-execute.component.ts"></script>
