# Java Films

###

Java Films é uma aplicação web que permite aos usuários acessar informações sobre séries de TV, utilizando a API OMDb para obter detalhes das séries e a API do ChatGPT para tradução de sinopses. A aplicação é construída com o framework Spring Boot e utiliza o banco de dados PostgreSQL para armazenamento de dados.

###

##

## Endereços URL Controller:

API possui o SpringDoc como dependência onde se encontra todas as requisições possíveis. Coloque a seguinte url para verificar os caminhos que podem ser realizados: http://localhost:8080/swagger-ui/index.html

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
