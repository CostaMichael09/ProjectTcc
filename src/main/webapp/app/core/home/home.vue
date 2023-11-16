<template>
  <div class="home row">
    <div class="col-md-9" v-if="!authenticated">
      <h1 class="display-4" v-html="$t('home.title')">Welcome</h1>
      <div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span v-text="$t('global.messages.info.authenticated.prefix')">If you want to </span>
          <a class="alert-link" v-on:click="openLogin()" v-text="$t('global.messages.info.authenticated.link')">sign in</a
          ><span v-html="$t('global.messages.info.authenticated.suffix')"
            >, you can try the default accounts:<br />- Administrator (login="admin" and password="admin") <br />- User (login="user" and
            password="user").</span
          >
        </div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span v-text="$t('global.messages.info.register.noaccount')">You don't have an account yet?</span>&nbsp;
          <router-link class="alert-link" to="/register" v-text="$t('global.messages.info.register.link')"
            >Register a new account
          </router-link>
        </div>
      </div>

      <p v-text="$t('home.question')">If you have any question on JHipster:</p>

      <ul>
        <li>
          <a
            href="https://www.linkedin.com/in/michael-costa-3a3633144/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinMichael')"
            >LinkeDin do Michael</a
          >
        </li>
        <li>
          <a
            href="https://www.linkedin.com/in/camposwenderson/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinWenderson')"
            >LinkeDin do Wenderson</a
          >
        </li>
        <li>
          <a
            href="https://www.linkedin.com/in/vin%C3%ADcius-lima-b8a1b9165/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinVinicius')"
            >LinkeDin do Vinicius</a
          >
        </li>
      </ul>

      <p>
        <span v-text="$t('home.like')">If you like AgileKip Generator, don't forget to give us a star on</span>
        <a href="https://github.com/CostaMichael09/ProjectTcc" target="_blank" rel="noopener noreferrer" v-text="$t('home.github')"
          >GitHub</a
        >!
      </p>
    </div>

    <div v-else>
      <div class="row">
        <div class="col-6">
          <h1 class="display-4">Estoque</h1>
          <h2 v-if="empresaVeiculos.length === 0" class="display-4">Vazio!</h2>
        </div>
        <div class="col-2">
          <router-link
            :to="`/process-definition/EmpresaVeiculoProcess/init`"
            tag="button"
            class="btn btn-info btn-sm details"
            data-cy="entityDetailsButton"
          >
            <span class="d-none d-md-inline">Adicionar Veiculo</span>
          </router-link>
        </div>
      </div>
      <div class="row">
        <div class="card-container" v-for="(veiculo, index) in empresaVeiculos" :key="index">
          <div class="col-md-4">
            <div class="veiculo-card">
              <div class="table-cell">
                <div class="image-frame">
                  <img
                    v-bind:src="`data:${arquivos[index][veiculo.empresaVeiculo.currentPhotoIndex].type};base64,${
                      arquivos[index][veiculo.empresaVeiculo.currentPhotoIndex].fotos
                    }`"
                    alt="Imagem"
                    class="thumbnail"
                  />
                </div>
              </div>

              <!-- Botões para navegação -->
              <div class="nav-buttons">
                <!-- Botão para voltar a foto -->
                <b-button
                  class="nav-button prev m-2"
                  v-if="veiculo.empresaVeiculo.totalPhotos > 1"
                  @click="prevPhoto(veiculo.empresaVeiculo)"
                >
                  <font-awesome-icon icon="arrow-left"></font-awesome-icon>
                </b-button>

                <!-- Botão para avançar a foto -->
                <b-button
                  class="nav-button next m-2"
                  v-if="veiculo.empresaVeiculo.totalPhotos > 1"
                  @click="nextPhoto(veiculo.empresaVeiculo)"
                >
                  <font-awesome-icon icon="arrow-right"></font-awesome-icon>
                </b-button>
              </div>

              <div class="info-veiculo">
                <div>{{ veiculo.empresaVeiculo.marca }} {{ veiculo.empresaVeiculo.modelo }}</div>
                <div>{{ veiculo.empresaVeiculo.anoFabricacao }} / {{ veiculo.empresaVeiculo.anoModelo }}</div>
                <div>{{ veiculo.empresaVeiculo.preco.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' }) }}</div>
                <router-link
                  :to="`/process-definition/EmpresaVeiculoProcess/instance/${veiculo.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>

<style scoped>
.veiculo-card {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 5px; /* Margem externa */
  width: 200px;
  display: inline-block;
  text-align: center;
  position: relative;
}

/* Adicionando margem interna aos elementos dentro do veiculo-card */
.file-item,
.file-table,
.file-item .table-cell {
  margin-bottom: 10px; /* Ajuste conforme necessário */
}

.info-veiculo {
  background-color: #f2f2f2; /* Cor cinza de fundo, ajuste conforme necessário */
  padding: 10px; /* Adiciona algum espaçamento interno */
}

.thumbnail {
  width: 100%; /* Ocupa 100% da largura do contêiner */
  height: 100%; /* Ocupa 100% da altura do contêiner */
  object-fit: contain;
  display: block;
}

.card-container {
  margin-bottom: 15px;
  height: 400px; /* Defina uma altura máxima para os cards, ajuste conforme necessário */
}

.table-cell {
  display: flex;
  align-items: center;
  padding: 0.5rem;
  overflow: hidden; /* Impede que o conteúdo transborde da moldura */
}

/* Adicione um estilo à div que envolve a imagem para criar uma moldura */
.image-frame {
  border: 1px solid #ddd; /* Cor e largura da moldura, ajuste conforme necessário */
}
</style>
