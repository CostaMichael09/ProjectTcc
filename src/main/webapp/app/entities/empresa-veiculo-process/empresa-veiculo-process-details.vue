<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="empresaVeiculoProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="empresaVeiculoProcessDetailsHeading">
          <span v-text="$t('newProjectApp.empresaVeiculoProcess.detail.title')">EmpresaVeiculoProcess</span> {{ empresaVeiculoProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="empresaVeiculoProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('newProjectApp.empresaVeiculoProcess.detail.title')">EmpresaVeiculoProcess</span> #{{
              empresaVeiculoProcess.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="empresaVeiculoProcess.empresaVeiculo">
              <h5 class="card-header">
                <span class="title"> Empresa Veiculo #{{ empresaVeiculoProcess.empresaVeiculo.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.renavam')">renavam</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="renavam"
                    id="empresa-veiculo-renavam"
                    data-cy="renavam"
                    v-model="empresaVeiculoProcess.empresaVeiculo.renavam"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.placa')">placa</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="placa"
                    id="empresa-veiculo-placa"
                    data-cy="placa"
                    v-model="empresaVeiculoProcess.empresaVeiculo.placa"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.docRegular')">docRegular</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="docRegular"
                    id="empresa-veiculo-docRegular"
                    data-cy="docRegular"
                    v-model="empresaVeiculoProcess.empresaVeiculo.docRegular ? 'Sim' : 'Não'"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.multa')">multa</label>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">R$</span>
                    </div>
                    <currency-input
                      id="task-regularizar-veiculo-multa"
                      class="form-control"
                      data-cy="multa"
                      v-model="empresaVeiculoProcess.empresaVeiculo.multa"
                      readonly
                      :currency="null"
                      :precision="2"
                      :auto-decimal-mode="false"
                      :allow-negative="false"
                    />
                  </div>
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.marca')">marca</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="marca"
                    id="empresa-veiculo-marca"
                    data-cy="marca"
                    v-model="empresaVeiculoProcess.empresaVeiculo.marca"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.modelo')">modelo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="modelo"
                    id="empresa-veiculo-modelo"
                    data-cy="modelo"
                    v-model="empresaVeiculoProcess.empresaVeiculo.modelo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.anoFabricacao')">anoFabricacao</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="anoFabricacao"
                    id="empresa-veiculo-anoFabricacao"
                    data-cy="anoFabricacao"
                    v-model="empresaVeiculoProcess.empresaVeiculo.anoFabricacao"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.anoModelo')">anoModelo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="anoModelo"
                    id="empresa-veiculo-anoModelo"
                    data-cy="anoModelo"
                    v-model="empresaVeiculoProcess.empresaVeiculo.anoModelo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.cor')">cor</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="cor"
                    id="empresa-veiculo-cor"
                    data-cy="cor"
                    v-model="empresaVeiculoProcess.empresaVeiculo.cor"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.estadoVeiculo')">estadoVeiculo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="estadoVeiculo"
                    id="empresa-veiculo-estadoVeiculo"
                    data-cy="estadoVeiculo"
                    v-model="empresaVeiculoProcess.empresaVeiculo.estadoVeiculo ? 'Bom' : 'Precisando de reparo'"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.obsEstadoVeiculo')"
                    >obsEstadoVeiculo</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="obsEstadoVeiculo"
                    id="empresa-veiculo-obsEstadoVeiculo"
                    data-cy="obsEstadoVeiculo"
                    v-model="empresaVeiculoProcess.empresaVeiculo.obsEstadoVeiculo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.aprovarFotos')">aprovarFotos</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="aprovarFotos"
                    id="empresa-veiculo-aprovarFotos"
                    data-cy="aprovarFotos"
                    v-model="empresaVeiculoProcess.empresaVeiculo.aprovarFotos ? 'Aprovado' : 'Não Aprovado'"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.preco')">preco</label>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">R$</span>
                    </div>
                    <currency-input
                      id="task-regularizar-veiculo-multa"
                      class="form-control"
                      data-cy="preco"
                      v-model="empresaVeiculoProcess.empresaVeiculo.preco"
                      readonly
                      :currency="null"
                      :precision="2"
                      :auto-decimal-mode="false"
                      :allow-negative="false"
                    />
                  </div>
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('newProjectApp.empresaVeiculoProcess.anuncioAprovado')"
                    >anuncioAprovado</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="anuncioAprovado"
                    id="empresa-veiculo-anuncioAprovado"
                    data-cy="anuncioAprovado"
                    v-model="empresaVeiculoProcess.empresaVeiculo.anuncioAprovado"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label"
                  >Arquivos e Fotos:</label>
                  <pdf
                    :view="true"
                    :empresaVeiculoProcess="empresaVeiculoProcess">
                  </pdf>
                  </br>
                  <img-component
                    :view="true"
                    :empresa-veiculo-process="empresaVeiculoProcess">
                  </img-component>

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

<script lang="ts" src="./empresa-veiculo-process-details.component.ts"></script>
