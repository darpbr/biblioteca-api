
# Biblioteca API

Bem-vindo à API de Biblioteca!

Este projeto utiliza o [Quarkus](https://quarkus.io/), um framework Java moderno para aplicações rápidas e eficientes.

## Sumário
- [Visão Geral](#visão-geral)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Execução](#execução)
- [Endpoints](#endpoints)
- [Testes](#testes)
- [Documentação](#documentação)
- [Contribuição](#contribuição)

## Visão Geral
Esta API permite gerenciar livros em uma biblioteca, incluindo cadastro, consulta, atualização e remoção de livros.

## Pré-requisitos
- Java 17+
- Maven 3.8+
- Docker (opcional, para builds nativos)

## Instalação
Clone o repositório e instale as dependências:
```bash
git clone <url-do-repositorio>
cd biblioteca-api
./mvnw clean install
```

## Execução
### Modo desenvolvimento
```bash
./mvnw quarkus:dev
```
Acesse o Dev UI: [http://localhost:8080/q/dev/](http://localhost:8080/q/dev/)

### Modo produção
```bash
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
```

### Build nativo
```bash
./mvnw package -Dnative
./target/biblioteca-api-*-runner
```

## Endpoints
Abaixo estão exemplos dos principais endpoints REST disponíveis:

### Listar livros
`GET /books`

### Buscar livro por ID
`GET /books/{id}`

### Adicionar livro
`POST /books`
```json
{
  "titulo": "Nome do Livro",
  "autor": "Autor",
  "ano": 2024
}
```

### Atualizar livro
`PUT /books/{id}`
```json
{
  "titulo": "Novo Título",
  "autor": "Novo Autor",
  "ano": 2025
}
```

### Remover livro
`DELETE /books/{id}`

## Testes
Para executar os testes:
```bash
./mvnw test
```

## Documentação
Acesse a documentação OpenAPI/Swagger em:
[http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)

## Contribuição
Contribuições são bem-vindas! Abra uma issue ou envie um pull request.

---

> Para dúvidas, consulte os guias oficiais do Quarkus ou entre em contato com os mantenedores do projeto.
