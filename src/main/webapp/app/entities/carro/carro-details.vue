<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="carro">
        <h2 class="jh-entity-heading" data-cy="carroDetailsHeading">
          <span v-text="$t('newProjectApp.carro.detail.title')">Carro</span> {{ carro.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('newProjectApp.carro.nomeCliente')">Nome Cliente</span>
          </dt>
          <dd>
            <span>{{ carro.nomeCliente }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.nomeVendedor')">Nome Vendedor</span>
          </dt>
          <dd>
            <span>{{ carro.nomeVendedor }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ carro.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ carro.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.marcaCarro')">Marca Carro</span>
          </dt>
          <dd>
            <span>{{ carro.marcaCarro }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.anoCarro')">Ano Carro</span>
          </dt>
          <dd>
            <span>{{ carro.anoCarro }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.modeloCarro')">Modelo Carro</span>
          </dt>
          <dd>
            <span>{{ carro.modeloCarro }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.formaPagamento')">Forma Pagamento</span>
          </dt>
          <dd>
            <span v-text="$t('newProjectApp.FormaPagamento.' + carro.formaPagamento)">{{ carro.formaPagamento }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.gnv')">Gnv</span>
          </dt>
          <dd>
            <span>{{ carro.gnv }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.valorTotalCarro')">Valor Total Carro</span>
          </dt>
          <dd>
            <span>{{ carro.valorTotalCarro }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.entrada')">Entrada</span>
          </dt>
          <dd>
            <span>{{ carro.entrada }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.valorParcela')">Valor Parcela</span>
          </dt>
          <dd>
            <span>{{ carro.valorParcela }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.parcelas')">Parcelas</span>
          </dt>
          <dd>
            <span>{{ carro.parcelas }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.juros')">Juros</span>
          </dt>
          <dd>
            <span>{{ carro.juros }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.rua')">Rua</span>
          </dt>
          <dd>
            <span>{{ carro.rua }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.bairro')">Bairro</span>
          </dt>
          <dd>
            <span>{{ carro.bairro }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.cidade')">Cidade</span>
          </dt>
          <dd>
            <span>{{ carro.cidade }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.carro.cep')">Cep</span>
          </dt>
          <dd>
            <span>{{ carro.cep }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./carro-details.component.ts"></script>
