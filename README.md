# Java Films

###

Java Films é uma aplicação web que permite aos usuários acessar informações sobre séries de TV, utilizando a API OMDb para obter detalhes das séries e a API do ChatGPT para tradução de sinopses. A aplicação é construída com o framework Spring Boot e utiliza o banco de dados PostgreSQL para armazenamento de dados.

###

##

## Funcionalidades

### Obter lista de séries
- `/series`: Retorna uma lista de todas as séries cadastradas no sistema.
- `/top5`: Retorna as 5 séries mais bem avaliadas.
- `/lancamentos`: Retorna as últimas séries adicionadas ao sistema.
### Obter informações de uma série
- `/{id}`: Retorna as informações de uma série específica, identificado pelo ID.
### Obter episódios de uma série
- `/{id}/temporadas/todas`: Retorna todos os episódios de uma série específica, identificado pelo ID.
- `/{id}/temporadas/{numero}`: Retorna os episódios de uma temporada específica de uma série, identificado pelo ID da série e o número da temporada.
### Obter melhores episódios de uma série:
- `/{id}/temporadas/top`: Retorna os 5 melhores episódios de uma série específica, identificado pelo ID.
### Buscar séries por título:
- `/busca?q={titulo}`: Retorna uma lista de séries que contêm o título especificado na busca. 

###

## Tecnologias Utilizadas

###

- Framework: Spring Boot
- Banco de Dados: PostgreSQL
#### APIs Externas:
- [OMDb API](https://www.omdbapi.com/)
- [ChatGPT API](https://chat.openai.com/)

###

## Instruções de Uso

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
mvn spring-boot:run
```

4. Acesse a aplicação no navegador:

```bash
Abra um navegador web e acesse a URL http://localhost:8080.
```

###

## Observações

###

- A aplicação utiliza um banco de dados PostgreSQL. Certifique-se de ter o PostgreSQL instalado e configurado em sua máquina antes de executar o projeto.
- Para utilizar a API do ChatGPT, é necessário ter uma conta na plataforma OpenAI e obter uma chave API.

###

## Integração com Frontend React + TypeScript

###

Este projeto backend, Java Films, se integra com um projeto frontend desenvolvido em React + TypeScript, chamado [reactFilms.](https://github.com/LeonardoSardagna/reactFilms) O projeto frontend consome as APIs do backend para exibir as informações das séries aos usuários de forma interativa.

### Clone do Repositório React:

1. Clone o repositório do front-end:

```bash
git clone https://github.com/LeonardoSardagna/reactFilms.git
```

2. Acesse o diretório do projeto:

```bash
cd reactFilms
```

3. Execute o projeto:

```bash
npm run dev
```
