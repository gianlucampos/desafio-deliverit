## Desafio técnico Java

Aplicação feita com o objetivo de ilustrar a resolução para o desafio técnico proposto pela DeliverIT.

## Tecnologias utilizadas
Neste projeto foram utilizadas as seguintes tecnologias:

- Java 8
- Spring Boot
- Maven
- JPA
- PostgreSQL 
- Flyway
- Docker 

---

### Pré-requisitos
Para executar aplicação é necessário instalar 2 ferramentas: **Docker** & **Docker Compose**.

**Docker**
Para ambientes [Linux](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/) e [Mac](https://docs.docker.com/docker-for-mac/install/) .

**Docker Compose** 
Nos ambientes *Windows* e *Mac* já são instalados juntos com o Docker, para Linux basta [seguir as instruções](https://docs.docker.com/compose/install/) .


### Como rodar a aplicação?

Para subir aplicação:

```
$ docker-compose up -d
```

Para parar aplicação:

```
$ docker-compose down
```

### Como testar a aplicação?
Recomendo utilizar uma ferramenta de teste de serviços RestFul como [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download/).

## Endpoints
Listagem de contas cadastradas [GET]
**http://localhost:8082/contas**

Inclusão de contas a pagar [POST]
**http://localhost:8082/contas**


---
