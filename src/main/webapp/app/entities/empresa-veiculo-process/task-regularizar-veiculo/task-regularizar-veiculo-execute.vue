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
                v-text="$t('newProjectApp.taskRegularizarVeiculo.renavam')"
                for="task-regularizar-veiculo-renavam"
                >Renavam</label
              >
              <input
                type="text"
                class="form-control"
                name="renavam"
                id="task-regularizar-veiculo-renavam"
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
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskRegularizarVeiculo.placa')"
                for="task-regularizar-veiculo-placa"
                >Placa</label
              >
              <input
                type="text"
                class="form-control"
                name="placa"
                id="task-regularizar-veiculo-placa"
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
                v-text="$t('newProjectApp.taskRegularizarVeiculo.docRegular')"
                for="task-regularizar-veiculo-docRegular"
                >Doc Regular</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="docRegular"
                id="task-regularizar-veiculo-docRegular"
                data-cy="docRegular"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$invalid,
                }"
                v-model="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.docRegular.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.taskRegularizarVeiculo.multa')"
                for="task-regularizar-veiculo-multa"
                >Multa</label
              >
              <input
                type="number"
                class="form-control"
                name="multa"
                id="task-regularizar-veiculo-multa"
                data-cy="multa"
                :class="{
                  valid: !$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                  invalid: $v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$invalid,
                }"
                v-model.number="$v.taskContext.empresaVeiculoProcess.empresaVeiculo.multa.$model"
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

<script lang="ts" src="./task-regularizar-veiculo-execute.component.ts"></script>
