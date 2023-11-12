<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('newProjectApp.taskAprovarFotos.home.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <img-component
              :view="true"
              :empresa-veiculo-process="taskContext.empresaVeiculoProcess"
              />
            <div class="form-group">
              <label class="form-control-label"
                     v-text="$t('newProjectApp.taskAprovarFotos.aprovarFotos')"
                     for="task-aprovar-fotos-aprovarFotos">Aprovar Fotos</label>

              <select class="form-control"
                      name="aprovarFotos"
                      id="task-aprovar-fotos-aprovarFotos"
                      data-cy="aprovarFotos"
                      v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.aprovarFotos.$model">

                <option :value="true"
                        :selected="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.aprovarFotos.$model === true">
                  Aprovado
                </option>

                <option :value="false"
                        :selected="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.aprovarFotos.$model === false">
                  Não Aprovado
                </option>

              </select>

              <!-- Adicione classes de validação conforme necessário -->
              <div :class="{
        valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.aprovarFotos.$invalid,
        invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.aprovarFotos.$invalid,
    }"></div>
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

<script lang="ts" src="./task-aprovar-fotos-execute.component.ts"></script>
