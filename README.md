# API de Cursos

## Descrição
API REST completa desenvolvida em Spring Boot com persistência em PostgreSQL.

## Tecnologias
- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- PostgreSQL 18

## Arquitetura em Camadas


## Endpoints

| Método | URL | Status | Descrição |
|--------|-----|--------|-----------|
| GET | /cursos | 200 OK | Listar todos os cursos |
| POST | /cursos | 201 Created | Criar novo curso |
| GET | /cursos/{id} | 200 OK | Buscar curso por ID |
| PUT | /cursos/{id} | 200 OK | Atualizar curso |
| DELETE | /cursos/{id} | 204 No Content | Remover curso |

## Modelo de Dados

```json
{
  "id": 1,
  "nome": "Back-End Frameworks",
  "cargaHoraria": 60
}
```

## Validações
- Nome: obrigatório e não pode estar em branco
- Carga Horária: deve ser maior que zero

## Como Executar

1. Crie o banco no PostgreSQL:
```sql
CREATE DATABASE api_cursos;
```

2. Configure `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/api_cursos
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute a aplicação
4. Acesse: `http://localhost:8080/cursos`

## Status da Entrega
- ✅ Aula 01: Fluxo cliente-servidor documentado
- ✅ Aula 02: Spring Boot + Beans + Injeção
- ✅ Aula 03: HTTP, REST, CRUD em memória
- ✅ Aula 04: Arquitetura em Camadas
- ✅ Aula 05: PostgreSQL + JPA + Persistência
