<template>
  <div>
    <!-- Lista de arquivos com estilo de tabela -->
    <div class="file-table">
      <div v-for="(arquivo, index) in arquivos" :key="index" class="file-item">
        <div class="table-cell">
          <!-- Adicionando a imagem ao lado do nome -->
          <img v-bind:src="`data:${arquivo.type};base64,${arquivo.fotos}`" alt="Imagem" class="thumbnail" />
          <a target="_blank">{{ arquivo.name }}</a>
        </div>
        <div class="table-cell">
          <b-button v-if="!view" @click="deleteFile(arquivo.id)" class="btn btn-danger btn">
            <font-awesome-icon :icon="['fas', 'times']"></font-awesome-icon>
          </b-button>
          <b-button @click="downloadFile(arquivo)" class="btn btn-info ml-2">
            <font-awesome-icon icon="download" />
          </b-button>
        </div>
      </div>
    </div>

    <div v-if="!view">
      <div class="form-group mt-3 mb-3">
        <label for="img-upload">Enviar Imagem:</label>
        <br/>
        <input type="file" id="img-upload" @change="handleFileUpload" multiple />
        <div v-if="selectedImgFiles.length > 0" v-for="(arquivosSelected, index) in selectedImgFiles" :key="index" class="file-item">
          <div class="table-cell">
            <a target="_blank">{{ arquivosSelected.name }}</a>
          </div>
          <div class="table-cell">
            <b-button v-if="!view" @click="deleteFilePreview(index)" class="btn btn-danger btn">
              <font-awesome-icon :icon="['fas', 'times']"></font-awesome-icon>
            </b-button>
          </div>
        </div>
      </div>
      <b-button v-if="!view" @click="uploadPdf" class="btn btn-success mb-3">Adicionar Arquivo</b-button>
    </div>
  </div>
</template>


<style>
/* Estilos da tabela de arquivos */
.file-table {
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 1rem;
}

/* Estilo para cada item de arquivo */
.file-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ddd; /* Adiciona uma linha separadora */
  padding: 0.5rem 0;
}

.table-cell {
  display: flex;
  align-items: center;
  padding: 0.5rem;
}

.btn-danger:hover {
  background-color: #c82333;
}

.thumbnail {
  max-width: 200px; /* Ajuste o tamanho conforme necessário */
  max-height: 200px;
  margin-right: 5px; /* Adicione margem entre a imagem e o texto */
}
</style>
<script lang="ts" src="./img.component.ts"></script>
