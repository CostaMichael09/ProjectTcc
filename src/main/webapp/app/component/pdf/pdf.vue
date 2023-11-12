<template>
  <div>
    <!-- Lista de arquivos com estilo de tabela -->
    <div class="file-table">
      <div v-for="(arquivo, index) in arquivos" :key="index" class="file-item">
        <div class="table-cell">
          <a :href="arquivo.url" target="_blank">{{ arquivo.name }}</a>
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
        <label for="pdf-upload">Enviar Doc Regularizado:</label>
        <br/>
        <input type="file" id="pdf-upload" @change="handleFileUpload" multiple />
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
</style>


<script lang="ts" src="./pdf.component.ts">
</script>
