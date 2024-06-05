<h1 align="left">Java Films</h1>

###

<p align="left">Este projeto, chamado Java Films, é uma aplicação web que fornece aos usuários acesso a informações sobre séries de TV, utilizando a API OMDb e a API do ChatGPT para tradução de sinopses. O projeto utiliza o framework Spring Boot e o banco de dados PostgreSQL para armazenamento de dados.</p>

###

<h2 align="left">Funcionalidades</h2>

###

<ul>
  <h3>Obter lista de séries:</h3>
  <li>`/series:` Retorna uma lista de todas as séries cadastradas no sistema.</li>
  <li>`/top5:` Retorna as 5 séries mais bem avaliadas.</li>
  <li>`/lancamentos:` Retorna as últimas séries adicionadas ao sistema.</li>
  <h3>Obter informações de uma série:</h3>
  <li>`/{id}:` Retorna as informações de uma série específica, identificado pelo ID.</li>
  <h3>Obter episódios de uma série:</h3>
  <li>`/{id}/temporadas/todas:` Retorna todos os episódios de uma série específica, identificado pelo ID.</li>
  <li>`/{id}/temporadas/{numero}:` Retorna os episódios de uma temporada específica de uma série, identificado pelo ID da série e o número da temporada.</li>
  <h3>Obter melhores episódios de uma série:</h3>
  <li>`/{id}/temporadas/top:` Retorna os 5 melhores episódios de uma série específica, identificado pelo ID.</li>
  <h3>Buscar séries por título:</h3>
  <li>`/busca?q={titulo}:` Retorna uma lista de séries que contêm o título especificado na busca.</li>
  <h3>Obter tradução da sinopse:</h3>
  <li>A tradução da sinopse das séries é feita utilizando a API do ChatGPT.</li>
</ul>

###

<h2 align="left">Tecnologias Utilizadas</h2>

###

<ul>
  <li>Framework: Spring Boot</li>
  <li>Banco de Dados: PostgreSQL</li>
  <h3>APIs Externas:</h3>
  <li>OMDb API: https://www.omdbapi.com/</li>
  <li>ChatGPT API: https://chat.openai.com/</li>
</ul>

###

<h2 align="left">Instruções de Uso</h2>

###

1. Clone o repositório do front-end:

```bash
git clone https://github.com/LeonardoSardagna/javaFilms.git
```

###

2. Acesse o diretório do projeto:

```bash
cd javaFilms
```

###

3. Execute o projeto:

```bash
./gradlew bootRun
```

4. Acesse a aplicação no navegador:

```bash
Abra um navegador web e acesse a URL http://localhost:8080.
```

###

<h2 align="left">Observações</h2>

###

<ul>
  <li>A aplicação utiliza um banco de dados PostgreSQL. Certifique-se de ter o PostgreSQL instalado e configurado em sua máquina antes de executar o projeto.</li>
  <li>Para utilizar a API do ChatGPT, é necessário ter uma conta na plataforma OpenAI e obter uma chave API.</li>
</ul>

###

<h2 align="left">Integração com Frontend React + TypeScript</h2>

###

<p align="left">Este projeto backend, Java Films, se integra com um projeto frontend desenvolvido em React + TypeScript, chamado [reactFilms.]("https://github.com/LeonardoSardagna/reactFilms")</a> O projeto frontend consome as APIs do backend para exibir as informações das séries aos usuários de forma interativa.

  <h3>Clone do Repositório React:</h3>

<p>Para clonar o repositório do projeto frontend, utilize o seguinte comando:</p>  

1. Clone o repositório do front-end:

```bash
git clone https://github.com/LeonardoSardagna/reactFilms.git
```
