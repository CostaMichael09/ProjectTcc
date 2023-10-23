<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="newProjectApp.carroStartForm.home.createOrEditLabel"
          data-cy="CarroStartFormCreateUpdateHeading"
          v-text="$t('newProjectApp.carroStartForm.home.createOrEditLabel')"
        >
          Create or edit a CarroStartForm
        </h2>
        <div v-if="carroProcess.processInstance">
          <akip-show-process-definition :processDefinition="carroProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="carroProcess.carro">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('newProjectApp.carroStartForm.nomeCliente')"
                    for="carro-start-form-nomeCliente"
                    >Nome Cliente</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nomeCliente"
                    id="carro-start-form-nomeCliente"
                    data-cy="nomeCliente"
                    :class="{ valid: !$v.carroProcess.carro.nomeCliente.$invalid, invalid: $v.carroProcess.carro.nomeCliente.$invalid }"
                    v-model="$v.carroProcess.carro.nomeCliente.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('newProjectApp.carroStartForm.nomeVendedor')"
                    for="carro-start-form-nomeVendedor"
                    >Nome Vendedor</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nomeVendedor"
                    id="carro-start-form-nomeVendedor"
                    data-cy="nomeVendedor"
                    :class="{ valid: !$v.carroProcess.carro.nomeVendedor.$invalid, invalid: $v.carroProcess.carro.nomeVendedor.$invalid }"
                    v-model="$v.carroProcess.carro.nomeVendedor.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroStartForm.startDate')" for="carro-start-form-startDate"
                    >Start Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="carro-start-form-startDate"
                        v-model="$v.carroProcess.carro.startDate.$model"
                        name="startDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="carro-start-form-startDate"
                      data-cy="startDate"
                      type="text"
                      class="form-control"
                      name="startDate"
                      :class="{ valid: !$v.carroProcess.carro.startDate.$invalid, invalid: $v.carroProcess.carro.startDate.$invalid }"
                      v-model="$v.carroProcess.carro.startDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroStartForm.endDate')" for="carro-start-form-endDate"
                    >End Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="carro-start-form-endDate"
                        v-model="$v.carroProcess.carro.endDate.$model"
                        name="endDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="carro-start-form-endDate"
                      data-cy="endDate"
                      type="text"
                      class="form-control"
                      name="endDate"
                      :class="{ valid: !$v.carroProcess.carro.endDate.$invalid, invalid: $v.carroProcess.carro.endDate.$invalid }"
                      v-model="$v.carroProcess.carro.endDate.$model"
                    />
                  </b-input-group>
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
            :disabled="$v.carroProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./carro-start-form-init.component.ts"></script>
