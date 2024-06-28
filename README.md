# Java Films

###

Java Films is a web application that allows users to access information about TV series, using the OMDb API to obtain series details and the ChatGPT API for synopsis translation. The application is built with the Spring Boot framework and uses a PostgreSQL database for data storage.

###

## URL Controller Endpoints:

The API includes SpringDoc as a dependency, where all possible requests can be found. Use the following URL to check the available paths: http://localhost:8080/swagger-ui/index.html

## Technologies Used

###

- Framework: Spring Boot
- Database: PostgreSQL

#### External APIs:

- OMDb API
- ChatGPT API

###

## Usage Instructions

###

1. Clone the front-end repository:

```bash
git clone https://github.com/LeonardoSardagna/javaFilms.git
```

###

2. Navigate to the project directory:

```bash
cd javaFilms
```

###

3. Run the project:

```bash
mvn spring-boot:run
```

4. Access the application in the browser:

```bash
Abra um navegador web e acesse a URL http://localhost:8080.
```

###

## Notes

###

- The application uses a PostgreSQL database. Make sure to have PostgreSQL installed and configured on your machine before running the project.
- To use the ChatGPT API, you need an account on the OpenAI platform and an API key.

###

## Integration with React + TypeScript Frontend

###

This backend project, Java Films, integrates with a frontend project developed in React + TypeScript, called [reactFilms.](https://github.com/LeonardoSardagna/reactFilms) The frontend project consumes the backend APIs to display series information to users interactively.
