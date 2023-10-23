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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.nomeCliente')">nomeCliente</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.nomeVendedor')">nomeVendedor</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.marcaCarro')">marcaCarro</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.anoCarro')">anoCarro</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.modeloCarro')">modeloCarro</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.valorTotalCarro')">valorTotalCarro</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.formaPagamento')">formaPagamento</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.entrada')">entrada</label>
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
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.parcelas')">parcelas</label>
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.valorParcela')">valorParcela</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="valorParcela"
                id="carro-valorParcela"
                data-cy="valorParcela"
                v-model="taskContext.carroProcess.carro.valorParcela"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.juros')">juros</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="juros"
                id="carro-juros"
                data-cy="juros"
                v-model="taskContext.carroProcess.carro.juros"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.rua')">rua</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="rua"
                id="carro-rua"
                data-cy="rua"
                v-model="taskContext.carroProcess.carro.rua"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.bairro')">bairro</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="bairro"
                id="carro-bairro"
                data-cy="bairro"
                v-model="taskContext.carroProcess.carro.bairro"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.cidade')">cidade</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="cidade"
                id="carro-cidade"
                data-cy="cidade"
                v-model="taskContext.carroProcess.carro.cidade"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.cep')">cep</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="cep"
                id="carro-cep"
                data-cy="cep"
                v-model="taskContext.carroProcess.carro.cep"
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
          :to="`/process-definition/CarroProcess/task/FecharCompra/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./fechar-compra-details.component.ts"></script>
