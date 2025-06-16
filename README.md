# API RESTful de Produtos

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

Este projeto é uma API RESTful simples para realizar operações CRUD (Criar, Ler, Atualizar, Deletar) de produtos. Foi construído com **Java, Spring Boot, Spring Data JPA e o banco de dados PostgreSQL.**

A API também implementa o conceito de **HATEOAS (Hypermedia as the Engine of Application State)**, enriquecendo as respostas com links para recursos relacionados, o que melhora a navegabilidade e a descoberta de funcionalidades da API.

## Tabela de Conteúdos

- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Autenticação](#autenticação)
- [Banco de Dados](#banco-de-dados)
- [Contribuição](#contribuição)

## Instalação

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/juaovictor0101/estudos-springboot.git](https://github.com/juaovictor0101/estudos-springboot.git)
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd estudos-springboot/primeira-api-restful
    ```
3.  Instale o [PostgreSQL](https://www.postgresql.org/) em sua máquina, caso ainda não o tenha.
4.  O projeto utiliza Maven, que cuidará do download das dependências do projeto assim que for iniciado.

## Configuração

1.  Crie um banco de dados no seu PostgreSQL para a aplicação.
2.  Configure as credenciais de acesso ao banco de dados no arquivo `src/main/resources/application.properties`. Altere os valores conforme a sua configuração local:

    ```properties
    # Exemplo de configuração para o PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
    spring.datasource.username=seu_usuario_postgres
    spring.datasource.password=sua_senha_postgres

    # Dialeto do Hibernate para PostgreSQL
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

    # Gerenciamento automático do schema pelo Hibernate (cria/atualiza tabelas)
    spring.jpa.hibernate.ddl-auto=update
    ```

## Uso

1.  Após configurar o banco de dados, inicie a aplicação diretamente pela sua IDE ou utilizando o Maven no terminal:
    ```bash
    mvn spring-boot:run
    ```
2.  A API estará acessível em `http://localhost:8080`.

## Endpoints da API

A API fornece os seguintes endpoints para o gerenciamento de produtos:

```http
POST   /products -> Registra um novo produto.
GET    /products -> Retorna uma lista de todos os produtos.
GET    /products/{id} -> Retorna um único produto pelo seu ID.
PUT    /products/{id} -> Atualiza os dados de um produto existente.
DELETE /products/{id} -> Deleta um produto pelo seu ID.
