<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="newProjectApp.empresaVeiculoStartForm.home.createOrEditLabel"
          data-cy="EmpresaVeiculoStartFormCreateUpdateHeading"
          v-text="$t('newProjectApp.empresaVeiculoStartForm.home.createOrEditLabel')"
        >
          Create or edit a EmpresaVeiculoStartForm
        </h2>
        <div v-if="empresaVeiculoProcess.processInstance">
          <akip-show-process-definition :processDefinition="empresaVeiculoProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="empresaVeiculoProcess.empresaVeiculo">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('newProjectApp.empresaVeiculoStartForm.renavam')"
                    for="empresa-veiculo-start-form-renavam"
                    >Renavam</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="renavam"
                    id="empresa-veiculo-start-form-renavam"
                    data-cy="renavam"
                    :class="{
                      valid: !$v.empresaVeiculoProcess.empresaVeiculo.renavam.$invalid,
                      invalid: $v.empresaVeiculoProcess.empresaVeiculo.renavam.$invalid,
                    }"
                    v-model="$v.empresaVeiculoProcess.empresaVeiculo.renavam.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('newProjectApp.empresaVeiculoStartForm.placa')"
                    for="empresa-veiculo-start-form-placa"
                    >Placa</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="placa"
                    id="empresa-veiculo-start-form-placa"
                    data-cy="placa"
                    :class="{
                      valid: !$v.empresaVeiculoProcess.empresaVeiculo.placa.$invalid,
                      invalid: $v.empresaVeiculoProcess.empresaVeiculo.placa.$invalid,
                    }"
                    v-model="$v.empresaVeiculoProcess.empresaVeiculo.placa.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.empresaVeiculoProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./empresa-veiculo-start-form-init.component.ts"></script>
