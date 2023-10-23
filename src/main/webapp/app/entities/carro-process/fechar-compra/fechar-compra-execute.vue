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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.nomeCliente')" for="fechar-compra-nomeCliente"
                >Nome Cliente</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCliente"
                id="fechar-compra-nomeCliente"
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.nomeVendedor')" for="fechar-compra-nomeVendedor"
                >Nome Vendedor</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeVendedor"
                id="fechar-compra-nomeVendedor"
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.marcaCarro')" for="fechar-compra-marcaCarro"
                >Marca Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="marcaCarro"
                id="fechar-compra-marcaCarro"
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.anoCarro')" for="fechar-compra-anoCarro"
                >Ano Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="anoCarro"
                id="fechar-compra-anoCarro"
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.modeloCarro')" for="fechar-compra-modeloCarro"
                >Modelo Carro</label
              >
              <input
                type="text"
                class="form-control"
                name="modeloCarro"
                id="fechar-compra-modeloCarro"
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
              <label
                class="form-control-label"
                v-text="$t('newProjectApp.fecharCompra.valorTotalCarro')"
                for="fechar-compra-valorTotalCarro"
                >Valor Total Carro</label
              >
              <input
                type="number"
                class="form-control"
                name="valorTotalCarro"
                id="fechar-compra-valorTotalCarro"
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
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.formaPagamento')" for="fechar-compra-formaPagamento"
                >Forma Pagamento</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="formaPagamento"
                id="carro-formaPagamento"
                data-cy="formaPagamento"
                v-model="$v.taskContext.carroProcess.carro.formaPagamento.$model"
              />
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.entrada')" for="fechar-compra-entrada"
                >Entrada</label
              >
              <input
                type="number"
                class="form-control"
                name="entrada"
                id="fechar-compra-entrada"
                readonly
                data-cy="entrada"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.entrada.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.entrada.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.entrada.$model"
              />
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.parcelas')" for="fechar-compra-parcelas"
                >Parcelas</label
              >
              <input
                type="number"
                class="form-control"
                name="parcelas"
                id="fechar-compra-parcelas"
                readonly
                data-cy="parcelas"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.parcelas.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.parcelas.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.parcelas.$model"
              />
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.valorParcela')" for="fechar-compra-valorParcela"
                >Valor Parcela</label
              >
              <input
                type="number"
                class="form-control"
                name="valorParcela"
                id="fechar-compra-valorParcela"
                data-cy="valorParcela"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.valorParcela.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.valorParcela.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.valorParcela.$model"
              />
            </div>
            <div v-show="$v.taskContext.carroProcess.carro.formaPagamento.$model === 'FINANCIADO'" class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.juros')" for="fechar-compra-juros">Juros</label>
              <input
                type="number"
                class="form-control"
                name="juros"
                id="fechar-compra-juros"
                data-cy="juros"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.juros.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.juros.$invalid,
                }"
                v-model.number="$v.taskContext.carroProcess.carro.juros.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.rua')" for="fechar-compra-rua">Rua</label>
              <input
                type="text"
                class="form-control"
                name="rua"
                id="fechar-compra-rua"
                data-cy="rua"
                :class="{ valid: !$v.taskContext.carroProcess.carro.rua.$invalid, invalid: $v.taskContext.carroProcess.carro.rua.$invalid }"
                v-model="$v.taskContext.carroProcess.carro.rua.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.bairro')" for="fechar-compra-bairro">Bairro</label>
              <input
                type="text"
                class="form-control"
                name="bairro"
                id="fechar-compra-bairro"
                data-cy="bairro"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.bairro.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.bairro.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.bairro.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.cidade')" for="fechar-compra-cidade">Cidade</label>
              <input
                type="text"
                class="form-control"
                name="cidade"
                id="fechar-compra-cidade"
                data-cy="cidade"
                :class="{
                  valid: !$v.taskContext.carroProcess.carro.cidade.$invalid,
                  invalid: $v.taskContext.carroProcess.carro.cidade.$invalid,
                }"
                v-model="$v.taskContext.carroProcess.carro.cidade.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('newProjectApp.fecharCompra.cep')" for="fechar-compra-cep">Cep</label>
              <input
                type="text"
                class="form-control"
                name="cep"
                id="fechar-compra-cep"
                data-cy="cep"
                :class="{ valid: !$v.taskContext.carroProcess.carro.cep.$invalid, invalid: $v.taskContext.carroProcess.carro.cep.$invalid }"
                v-model="$v.taskContext.carroProcess.carro.cep.$model"
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

<script lang="ts" src="./fechar-compra-execute.component.ts"></script>
