<template>
  <div>
    <h2 id="page-heading" data-cy="EmpresaVeiculoHeading">
      <span v-text="$t('newProjectApp.empresaVeiculo.home.title')" id="empresa-veiculo-heading">Empresa Veiculos</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('newProjectApp.empresaVeiculo.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && empresaVeiculos && empresaVeiculos.length === 0">
      <span v-text="$t('newProjectApp.empresaVeiculo.home.notFound')">No empresaVeiculos found</span>
    </div>
    <div class="table-responsive" v-if="empresaVeiculos && empresaVeiculos.length > 0">
      <table class="table table-striped" aria-describedby="empresaVeiculos">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.renavam')">Renavam</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.placa')">Placa</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.docRegular')">Doc Regular</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.multa')">Multa</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.marca')">Marca</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.modelo')">Modelo</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.anoFabricacao')">Ano Fabricacao</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.anoModelo')">Ano Modelo</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.cor')">Cor</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.estadoVeiculo')">Estado Veiculo</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.obsEstadoVeiculo')">Obs Estado Veiculo</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.fotos')">Fotos</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.aprovarFotos')">Aprovar Fotos</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.preco')">Preco</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.empresaVeiculo.anuncioAprovado')">Anuncio Aprovado</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="empresaVeiculo in empresaVeiculos" :key="empresaVeiculo.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'EmpresaVeiculoView', params: { empresaVeiculoId: empresaVeiculo.id } }">{{
                empresaVeiculo.id
              }}</router-link>
            </td>
            <td>{{ empresaVeiculo.renavam }}</td>
            <td>{{ empresaVeiculo.placa }}</td>
            <td>{{ empresaVeiculo.docRegular }}</td>
            <td>{{ empresaVeiculo.multa }}</td>
            <td>{{ empresaVeiculo.marca }}</td>
            <td>{{ empresaVeiculo.modelo }}</td>
            <td>{{ empresaVeiculo.anoFabricacao }}</td>
            <td>{{ empresaVeiculo.anoModelo }}</td>
            <td>{{ empresaVeiculo.cor }}</td>
            <td>{{ empresaVeiculo.estadoVeiculo }}</td>
            <td>{{ empresaVeiculo.obsEstadoVeiculo }}</td>
            <td>{{ empresaVeiculo.fotos }}</td>
            <td>{{ empresaVeiculo.aprovarFotos }}</td>
            <td>{{ empresaVeiculo.preco }}</td>
            <td>{{ empresaVeiculo.anuncioAprovado }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'EmpresaVeiculoView', params: { empresaVeiculoId: empresaVeiculo.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="newProjectApp.empresaVeiculo.delete.question"
          data-cy="empresaVeiculoDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-empresaVeiculo-heading" v-text="$t('newProjectApp.empresaVeiculo.delete.question', { id: removeId })">
          Are you sure you want to delete this Empresa Veiculo?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-empresaVeiculo"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEmpresaVeiculo()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./empresa-veiculo.component.ts"></script>
