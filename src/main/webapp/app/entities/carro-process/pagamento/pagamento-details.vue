<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('newProjectApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.nomeCliente')">nomeCliente</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="nomeCliente"
                id="carro-nomeCliente"
                data-cy="nomeCliente"
                v-model="taskContext.carroProcess.carro.nomeCliente"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.nomeVendedor')">nomeVendedor</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="nomeVendedor"
                id="carro-nomeVendedor"
                data-cy="nomeVendedor"
                v-model="taskContext.carroProcess.carro.nomeVendedor"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.marcaCarro')">marcaCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="marcaCarro"
                id="carro-marcaCarro"
                data-cy="marcaCarro"
                v-model="taskContext.carroProcess.carro.marcaCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.anoCarro')">anoCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="anoCarro"
                id="carro-anoCarro"
                data-cy="anoCarro"
                v-model="taskContext.carroProcess.carro.anoCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.modeloCarro')">modeloCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="modeloCarro"
                id="carro-modeloCarro"
                data-cy="modeloCarro"
                v-model="taskContext.carroProcess.carro.modeloCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.valorTotalCarro')">valorTotalCarro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="valorTotalCarro"
                id="carro-valorTotalCarro"
                data-cy="valorTotalCarro"
                v-model="taskContext.carroProcess.carro.valorTotalCarro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.formaPagamento')">formaPagamento</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="formaPagamento"
                id="carro-formaPagamento"
                data-cy="formaPagamento"
                v-model="taskContext.carroProcess.carro.formaPagamento"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.parcelas')">parcelas</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="parcelas"
                id="carro-parcelas"
                data-cy="parcelas"
                v-model="taskContext.carroProcess.carro.parcelas"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.entrada')">entrada</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="entrada"
                id="carro-entrada"
                data-cy="entrada"
                v-model="taskContext.carroProcess.carro.entrada"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/CarroProcess/task/Pagamento/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./pagamento-details.component.ts"></script>
