<template>
  <div>
    <h2 id="page-heading" data-cy="CarroHeading">
      <span v-text="$t('newProjectApp.carro.home.title')" id="carro-heading">Carros</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('newProjectApp.carro.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && carros && carros.length === 0">
      <span v-text="$t('newProjectApp.carro.home.notFound')">No carros found</span>
    </div>
    <div class="table-responsive" v-if="carros && carros.length > 0">
      <table class="table table-striped" aria-describedby="carros">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.nomeCliente')">Nome Cliente</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.nomeVendedor')">Nome Vendedor</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.marcaCarro')">Marca Carro</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.anoCarro')">Ano Carro</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.modeloCarro')">Modelo Carro</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.formaPagamento')">Forma Pagamento</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.gnv')">Gnv</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.valorTotalCarro')">Valor Total Carro</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.entrada')">Entrada</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.valorParcela')">Valor Parcela</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.parcelas')">Parcelas</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.juros')">Juros</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.rua')">Rua</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.bairro')">Bairro</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.cidade')">Cidade</span></th>
            <th scope="row"><span v-text="$t('newProjectApp.carro.cep')">Cep</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="carro in carros" :key="carro.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CarroView', params: { carroId: carro.id } }">{{ carro.id }}</router-link>
            </td>
            <td>{{ carro.nomeCliente }}</td>
            <td>{{ carro.nomeVendedor }}</td>
            <td>{{ carro.startDate }}</td>
            <td>{{ carro.endDate }}</td>
            <td>{{ carro.marcaCarro }}</td>
            <td>{{ carro.anoCarro }}</td>
            <td>{{ carro.modeloCarro }}</td>
            <td v-text="$t('newProjectApp.FormaPagamento.' + carro.formaPagamento)">{{ carro.formaPagamento }}</td>
            <td>{{ carro.gnv }}</td>
            <td>{{ carro.valorTotalCarro }}</td>
            <td>{{ carro.entrada }}</td>
            <td>{{ carro.valorParcela }}</td>
            <td>{{ carro.parcelas }}</td>
            <td>{{ carro.juros }}</td>
            <td>{{ carro.rua }}</td>
            <td>{{ carro.bairro }}</td>
            <td>{{ carro.cidade }}</td>
            <td>{{ carro.cep }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CarroView', params: { carroId: carro.id } }" custom v-slot="{ navigate }">
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
        ><span id="newProjectApp.carro.delete.question" data-cy="carroDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-carro-heading" v-text="$t('newProjectApp.carro.delete.question', { id: removeId })">
          Are you sure you want to delete this Carro?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-carro"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCarro()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./carro.component.ts"></script>
