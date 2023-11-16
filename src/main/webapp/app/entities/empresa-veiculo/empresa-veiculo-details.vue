<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="empresaVeiculo">
        <h2 class="jh-entity-heading" data-cy="empresaVeiculoDetailsHeading">
          <span v-text="$t('newProjectApp.empresaVeiculo.detail.title')">EmpresaVeiculo</span> {{ empresaVeiculo.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.renavam')">Renavam</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.renavam }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.placa')">Placa</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.placa }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.docRegular')">Doc Regular</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.docRegular }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.multa')">Multa</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.multa }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.marca')">Marca</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.marca }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.modelo')">Modelo</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.modelo }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.anoFabricacao')">Ano Fabricacao</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.anoFabricacao }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.anoModelo')">Ano Modelo</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.anoModelo }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.cor')">Cor</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.cor }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.estadoVeiculo')">Estado Veiculo</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.estadoVeiculo }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.obsEstadoVeiculo')">Obs Estado Veiculo</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.obsEstadoVeiculo }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.fotos')">Fotos</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.fotos }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.aprovarFotos')">Aprovar Fotos</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.aprovarFotos }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.preco')">Preco</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.preco }}</span>
          </dd>
          <dt>
            <span v-text="$t('newProjectApp.empresaVeiculo.anuncioAprovado')">Anuncio Aprovado</span>
          </dt>
          <dd>
            <span>{{ empresaVeiculo.anuncioAprovado }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./empresa-veiculo-details.component.ts"></script>
