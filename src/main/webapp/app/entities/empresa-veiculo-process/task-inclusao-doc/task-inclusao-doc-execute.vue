<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('newProjectApp.taskInclusaoDoc.home.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr/>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.renavam')"
                     for="task-inclusao-doc-renavam"
              >Renavam</label
              >
              <input
                type="text"
                class="form-control"
                name="renavam"
                id="task-inclusao-doc-renavam"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.placa')"
                     for="task-inclusao-doc-placa"
              >Placa</label
              >
              <input
                type="text"
                class="form-control"
                name="placa"
                id="task-inclusao-doc-placa"
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
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.docRegular')"
                     for="task-inclusao-doc-docRegular">Doc Regular</label>
              <input
                type="text"
                class="form-control"
                name="docRegular"
                id="task-inclusao-doc-docRegular"
                readonly
                data-cy="docRegular"
                :class="{
      valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
      invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
    }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$model ? 'Sim' : 'Não'"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.multa')"
                     for="task-inclusao-doc-multa"
              >Multa</label
              >
              <input
                type="number"
                class="form-control"
                name="multa"
                id="task-inclusao-doc-multa"
                readonly
                data-cy="multa"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$model"
              />
            </div>
            <pdf
              :view="true"
              :empresaVeiculoProcess="taskContext.empresaVeiculoProcess">
            </pdf>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.marca')" for="task-inclusao-doc-marca">Marca</label>
              <select
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
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.modelo')"
                     for="task-inclusao-doc-modelo"
              >Modelo</label
              >
              <input
                type="text"
                class="form-control"
                name="modelo"
                id="task-inclusao-doc-modelo"
                data-cy="modelo"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.modelo.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.anoFabricacao')" for="task-inclusao-doc-anoFabricacao">Ano Fabricacao</label>
              <input
                type="number"
                class="form-control"
                name="anoFabricacao"
                id="task-inclusao-doc-anoFabricacao"
                data-cy="anoFabricacao"
                :class="{
        valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
        invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$invalid,
      }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.anoFabricacao.$model"
              />
            </div>

            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.anoModelo')" for="task-inclusao-doc-anoModelo">Ano Modelo</label>
              <select
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
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.taskInclusaoDoc.cor')"
                     for="task-inclusao-doc-cor">Cor</label>
              <input
                type="text"
                class="form-control"
                name="cor"
                id="task-inclusao-doc-cor"
                data-cy="cor"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.cor.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br/>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info"
                data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span
          v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-inclusao-doc-execute.component.ts"></script>
