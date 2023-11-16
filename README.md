# Gerenciamento de Estoque de uma Concessionária

<img src="https://i.imgur.com/RGx1Oqd.png">

<p><b>✅ Projeto Finalizado</b></p>
<p><b>📆 Data de entrega:</b> 13/11/2023</p> 
<!--- <p><b>🎓 Nota:</b> 10</p> --->

## 💬 Descrição

Repositório para armazenar o Trabalho de Conclusão de Curso do Centro Universitário Unicarioca. O projeto tem como orientador o pelo professor [Alberto Tavares da Silva](https://www.linkedin.com/in/alberto-tavares-da-silva-b03a5069/) se trata de uma Aplicação Vue.JS com Spring Boot, máquina de processos com camunda
para gerenciamento de estoque de uma concessionária.

O trabalho vai ser entregue em novembro de 2023.

## 📚 Requisitos do projeto

Esta aplicação foi gerada usando o JHipster 7.0.1. Você pode encontrar a documentação e ajuda em [https://www.jhipster.tech/documentation-archive/v7.0.1](https://www.jhipster.tech/documentation-archive/v7.0.1).

## Desenvolvimento

Antes de construir este projeto, você deve instalar e configurar as seguintes dependências em sua máquina:

1. [Node.js][]: Usamos o Node para executar um servidor web de desenvolvimento e construir o projeto. Dependendo do seu sistema, você pode instalar o Node seja a partir do código-fonte ou como um pacote pré-empacotado.

Após instalar o Node, você deverá conseguir executar o seguinte comando para instalar as ferramentas de desenvolvimento. Você só precisará executar este comando quando as dependências mudarem no [package.json](package.json).

```
npm install
```

Nós utilizamos scripts do npm e o [Webpack][] como nosso sistema de construção.

Execute os seguintes comandos em dois terminais separados para criar uma experiência de desenvolvimento agradável, onde o seu navegador é atualizado automaticamente quando os arquivos são modificados no seu disco rígido.

```
./mvnw
npm start
```
O npm também é utilizado para gerenciar as dependências de CSS e JavaScript utilizadas nesta aplicação. Você pode atualizar as dependências especificando uma versão mais recente no arquivo package.json. Você também pode executar `npm update` e `npm install` para gerenciar as dependências. 
Adicione a flag `help` a qualquer comando para ver como você pode usá-lo. Por exemplo,`npm help update`.

O comando `npm run` irá listar todos os scripts disponíveis para execução neste projeto.

### Suporte a PWA
O JHipster vem com suporte a PWA (Progressive Web App), e ele está desativado por padrão. Um dos principais componentes de uma PWA é um service worker.

O código de inicialização do service worker está comentado por padrão. Para ativá-lo, descomente o seguinte código em `src/main/webapp/index.html`:

```html
<script>
  if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('./service-worker.js').then(function () {
      console.log('Service Worker Registered');
    });
  }
</script>
```
Note: [Workbox](https://developers.google.com/web/tools/workbox/) O service worker do JHipster é alimentado por Powers. Ele gera dinamicamente o arquivo `service-worker.js`.

## Gerenciando dependências
Por exemplo, para adicionar a biblioteca [Leaflet][] como uma dependência em tempo de execução da sua aplicação, você executaria o seguinte comando:

```
npm install --save --save-exact leaflet
```

Para aproveitar as definições de tipo TypeScript do repositório [DefinitelyTyped][] durante o desenvolvimento, você executaria o seguinte comando:

```
npm install --save-dev --save-exact @types/leaflet
```


Em seguida, você importaria os arquivos JS e CSS especificados nas instruções de instalação da biblioteca para que o [Webpack][] tenha conhecimento sobre eles:
Nota: Ainda há algumas outras coisas a serem feitas para o Leaflet que não detalharemos aqui.

Para mais instruções sobre como desenvolver com o JHipster, dê uma olhada em [Usando o JHipster no desenvolvimento][].

## Construindo para produção
### Empacotando como jar

Para construir o jar final e otimizar a aplicação newProject para produção, execute:

```
./mvnw -Pprod clean verify
```

Isso irá concatenar e minificar os arquivos CSS e JavaScript do cliente. Também modificará o `index.html` para referenciar esses novos arquivos.
Para garantir que tudo funcionou, execute:

```
java -jar target/*.jar
```

Em seguida, acesse http://localhost:8080 no seu navegador.

Consulte [Usando o JHipster em produção][] para mais detalhes.

### Packaging as war

Para empacotar sua aplicação como um arquivo war para implantá-la em um servidor de aplicação, execute:

```
./mvnw -Pprod,war clean verify
```

## Testing

Para iniciar os testes da sua aplicação, execute:

```
./mvnw verify
```

### Client tests

Os testes unitários são executados pelo [Jest][]. Eles estão localizados em src/test/javascript/ e podem ser executados com:

```
npm test
```

Para mais informações, consulte a página [Running tests][].

## Qualidade do código

O Sonar é utilizado para analisar a qualidade do código. Você pode iniciar um servidor Sonar local (acessível em http://localhost:9001) com:

```
docker-compose -f src/main/docker/sonar.yml up -d
```

Observação: desativamos a autenticação em src/main/docker/sonar.yml para proporcionar uma experiência pronta para uso ao experimentar o SonarQube; para casos de uso reais, ative-a novamente.

Você pode executar uma análise do Sonar usando o sonar-scanner ou usando o plugin Maven.

Em seguida, execute uma análise do Sonar:

```
./mvnw -Pprod clean verify sonar:sonar
```

Se precisar executar novamente a fase do Sonar, certifique-se de especificar pelo menos a fase `initialize`, pois as propriedades do Sonar são carregadas a partir do arquivo sonar-project.properties.

```
./mvnw initialize sonar:sonar
```

Para mais informações, consulte a página [Code quality][].

## Usando o Docker para simplificar o desenvolvimento (opcional)\

Você pode usar o Docker para melhorar sua experiência de desenvolvimento com o JHipster. Várias configurações do docker-compose estão disponíveis na pasta src/main/docker para iniciar serviços de terceiros necessários.

Por exemplo, para iniciar um banco de dados PostgreSQL em um contêiner Docker, execute:

```
docker-compose -f src/main/docker/postgresql.yml up -d
```

Para pará-lo e remover o contêiner, execute:

```
docker-compose -f src/main/docker/postgresql.yml down
```

Você também pode dockerizar completamente sua aplicação e todos os serviços dos quais ela depende. Para fazer isso, primeiro construa uma imagem Docker da sua aplicação executando:

```
./mvnw -Pprod verify jib:dockerBuild
```

Em seguida, execute:

```
docker-compose -f src/main/docker/app.yml up -d
```

Para mais informações, consulte [Using Docker and Docker-Compose][], esta página também contém informações sobre o sub-gerador docker-compose (`jhipster docker-compose`), que é capaz de gerar configurações docker para uma ou várias aplicações JHipster.

Para configurar CI para o seu projeto, execute o sub-gerador ci-cd (`jhipster ci-cd`). Isso permitirá que você gere arquivos de configuração para vários sistemas de Integração Contínua. Consulte a página [Configurando Integração Contínua][] para obter mais informações.

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 7.0.1 archive]: https://www.jhipster.tech/documentation-archive/v7.0.1
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v7.0.1/development/
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v7.0.1/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v7.0.1/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v7.0.1/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v7.0.1/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v7.0.1/setting-up-ci/
[node.js]: https://nodejs.org/
[webpack]: https://webpack.github.io/
[browsersync]: https://www.browsersync.io/
[jest]: https://facebook.github.io/jest/
[jasmine]: https://jasmine.github.io/2.0/introduction.html
[protractor]: https://angular.github.io/protractor/
[leaflet]: https://leafletjs.com/
[definitelytyped]: https://definitelytyped.org/

## 👨‍🎓 Autores do Projeto

<table>
  <tr>
    <td align="center">
      <a target="_blank" href="https://github.com/CostaMichael09"><img src="https://avatars.githubusercontent.com/u/76540459?v=4" width="140px">
        <br>
        <b>Michael Costa</b>
      </a>
      <br>
      <a href="https://www.linkedin.com/in/michael-costa-3a3633144/">
      <sub>
      <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white">
      </a>
      <br>
      <a target="_blank" href="https://github.com/CostaMichael09"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">
      </sub>
      </a>
    </td>
        
  <td align="center">
      <a target="_blank" href="https://github.com/camposwenderson"><img src="https://avatars.githubusercontent.com/u/49501669?v=4" width="140px">
        <br>
        <b>Wenderson Campos</b>
      </a>
      <br>
      <a href="https://www.linkedin.com/in/camposwenderson/">
      <sub>
      <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white">
      </a>
      <br>
      <a target="_blank" href="https://github.com/camposwenderson"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">
      </sub>
      </a>
    </td>

  <td align="center">
      <a target="_blank" href="https://github.com/Vinicius-Lima31"><img src="https://avatars.githubusercontent.com/u/62820033?v=4" width="140px">
        <br>
        <b>Vinícius Lima</b>
      </a>
      <br>
      <a href="https://www.linkedin.com/in/vin%C3%ADcius-lima-b8a1b9165/">
      <sub>
      <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white">
      </a>
      <br>
      <a target="_blank" href="https://github.com/Vinicius-Lima31"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">
      </sub>
      </a>
    </td>
        
</tr>    
</table>
