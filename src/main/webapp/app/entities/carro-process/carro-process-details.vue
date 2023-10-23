<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="carroProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="carroProcessDetailsHeading">
          <span v-text="$t('newProjectApp.carroProcess.detail.title')">CarroProcess</span> {{ carroProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="carroProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('newProjectApp.carroProcess.detail.title')">CarroProcess</span> #{{ carroProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="carroProcess.carro">
              <h5 class="card-header">
                <span class="title"> Carro #{{ carroProcess.carro.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.nomeCliente')">nomeCliente</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="nomeCliente"
                    id="carro-nomeCliente"
                    data-cy="nomeCliente"
                    v-model="carroProcess.carro.nomeCliente"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.nomeVendedor')">nomeVendedor</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="nomeVendedor"
                    id="carro-nomeVendedor"
                    data-cy="nomeVendedor"
                    v-model="carroProcess.carro.nomeVendedor"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.startDate')">startDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="carro-startDate"
                    data-cy="startDate"
                    v-model="carroProcess.carro.startDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.endDate')">endDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="carro-endDate"
                    data-cy="endDate"
                    v-model="carroProcess.carro.endDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.marcaCarro')">marcaCarro</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="marcaCarro"
                    id="carro-marcaCarro"
                    data-cy="marcaCarro"
                    v-model="carroProcess.carro.marcaCarro"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.anoCarro')">anoCarro</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="anoCarro"
                    id="carro-anoCarro"
                    data-cy="anoCarro"
                    v-model="carroProcess.carro.anoCarro"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.modeloCarro')">modeloCarro</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="modeloCarro"
                    id="carro-modeloCarro"
                    data-cy="modeloCarro"
                    v-model="carroProcess.carro.modeloCarro"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.formaPagamento')">formaPagamento</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="formaPagamento"
                    id="carro-formaPagamento"
                    data-cy="formaPagamento"
                    v-model="carroProcess.carro.formaPagamento"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.gnv')">gnv</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="gnv"
                    id="carro-gnv"
                    data-cy="gnv"
                    v-model="carroProcess.carro.gnv"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.valorTotalCarro')">valorTotalCarro</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="valorTotalCarro"
                    id="carro-valorTotalCarro"
                    data-cy="valorTotalCarro"
                    v-model="carroProcess.carro.valorTotalCarro"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.entrada')">entrada</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="entrada"
                    id="carro-entrada"
                    data-cy="entrada"
                    v-model="carroProcess.carro.entrada"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.valorParcela')">valorParcela</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="valorParcela"
                    id="carro-valorParcela"
                    data-cy="valorParcela"
                    v-model="carroProcess.carro.valorParcela"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.parcelas')">parcelas</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="parcelas"
                    id="carro-parcelas"
                    data-cy="parcelas"
                    v-model="carroProcess.carro.parcelas"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.juros')">juros</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="juros"
                    id="carro-juros"
                    data-cy="juros"
                    v-model="carroProcess.carro.juros"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.rua')">rua</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="rua"
                    id="carro-rua"
                    data-cy="rua"
                    v-model="carroProcess.carro.rua"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.bairro')">bairro</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="bairro"
                    id="carro-bairro"
                    data-cy="bairro"
                    v-model="carroProcess.carro.bairro"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.cidade')">cidade</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="cidade"
                    id="carro-cidade"
                    data-cy="cidade"
                    v-model="carroProcess.carro.cidade"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.carroProcess.cep')">cep</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="cep"
                    id="carro-cep"
                    data-cy="cep"
                    v-model="carroProcess.carro.cep"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./carro-process-details.component.ts"></script>
