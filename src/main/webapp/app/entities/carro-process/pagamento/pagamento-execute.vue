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
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.nomeCliente')" for="pagamento-nomeCliente"
                >Nome Cliente</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCliente"
                id="pagamento-nomeCliente"
                readonly
                data-cy="nomeCliente"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.nomeCliente.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.nomeCliente.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.nomeCliente.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.nomeVendedor')" for="pagamento-nomeVendedor"
                >Nome Vendedor</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeVendedor"
                id="pagamento-nomeVendedor"
                readonly
                data-cy="nomeVendedor"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.nomeVendedor.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.nomeVendedor.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.nomeVendedor.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.marcaCarro')" for="pagamento-marcaCarro"
                >Marca Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="marcaCarro"
                id="pagamento-marcaCarro"
                readonly
                data-cy="marcaCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.marcaCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.marcaCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.marcaCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.anoCarro')" for="pagamento-anoCarro">Ano Carro</label>
              <input
                type="text"
                class="form-control"
                name="anoCarro"
                id="pagamento-anoCarro"
                readonly
                data-cy="anoCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.anoCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.anoCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.anoCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.modeloCarro')" for="pagamento-modeloCarro"
                >Modelo Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="modeloCarro"
                id="pagamento-modeloCarro"
                readonly
                data-cy="modeloCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.modeloCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.modeloCarro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.modeloCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.valorTotalCarro')" for="pagamento-valorTotalCarro"
                >Valor Total Carro</label
              >
              <input
                type="number"
                class="form-control"
                name="valorTotalCarro"
                id="pagamento-valorTotalCarro"
                readonly
                data-cy="valorTotalCarro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.valorTotalCarro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.valorTotalCarro.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.valorTotalCarro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.formaPagamento')" for="pagamento-formaPagamento"
                >Forma Pagamento</label
              >
              <select
                class="form-control"
                name="formaPagamento"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.formaPagamento.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.formaPagamento.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.formaPagamento.$model"
                id="pagamento-formaPagamento"
                data-cy="formaPagamento"
              >
                <option value="AVISTA" v-bind:label="$t('newProjectApp.FormaPagamento.AVISTA')">AVISTA</option>
                <option value="FINANCIADO" v-bind:label="$t('newProjectApp.FormaPagamento.FINANCIADO')">FINANCIADO</option>
              </select>
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.parcelas')" for="pagamento-parcelas">Parcelas</label>
              <input
                type="number"
                class="form-control"
                name="parcelas"
                id="pagamento-parcelas"
                data-cy="parcelas"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.parcelas.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.parcelas.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.parcelas.$model"
              />
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.pagamento.entrada')" for="pagamento-entrada">Entrada</label>
              <input
                type="number"
                class="form-control"
                name="entrada"
                id="pagamento-entrada"
                data-cy="entrada"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.entrada.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.entrada.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.entrada.$model"
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

<script lang="ts" src="./pagamento-execute.component.ts"></script>
