# API RESTful para Gerenciamento de Contatos

Este projeto consiste em uma **API RESTful** desenvolvida com **Spring Boot** em Java para o gerenciamento de contatos, integrando **JPARepository** para simplificar a interação com o banco de dados por meio de ORM (Object-Relational Mapping).

## Como Utilizar a API

Para utilizar a API, siga os passos abaixo:

1. **Baixar ou Clonar o Repositório:**
   - Você pode baixar o código-fonte ou clonar este repositório em sua máquina local.

2. **Ambiente de Desenvolvimento:**
   - Certifique-se de ter um ambiente que suporte o desenvolvimento com Spring, como **Spring Tools ou VS Code**.

3. **Ambiente MySQL:**
   - É necessário ter um ambiente MySQL configurado em sua máquina. Como por exemplo **MySQL Workbench**.

4. **Criar um Banco de Dados:**
   - Utilize o seguinte comando SQL para criar o banco de dados necessário:
     ```sql
     CREATE DATABASE IF NOT EXISTS contatos;
     ```

5. **Configuração do Banco de Dados:**
   - Altere as configurações do arquivo [application.properties](https://github.com/FabricioMacena/SpringBootContatosAPI/blob/main/src/main/resources/application.properties) com a rota, nome de usuário e senha do seu banco de dados.

6. **Ambiente de Testes:**
   - É recomendável utilizar um ambiente de testes, como **Postman ou Insomnia**, para acessar as URLs da API e testar suas funcionalidades.

## Funcionalidades Principais

- **Cadastro de Contatos:** Permite criar novos contatos com informações como nome, e-mail, telefone, etc.
- **Consulta de Contatos:** Possibilita visualizar os detalhes de um contato específico.
- **Atualização de Contatos:** Permite atualizar as informações de um contato existente.
- **Exclusão de Contatos:** Permite excluir um contato da base de dados.

## Exemplo de Uso

### Criar um Novo Contato
```
POST http://localhost:8080/contacts
{
    "name": "Luís",
    "lastName": "Almeida",
    "age": 52,
    "nacionality": "Brasileiro",
    "email": "luis@gmail.com"
}
```

### Consultar Todos os Contatos Existentes
```
GET http://localhost:8080/contacts
```

  - É possível fazer o uso de dois parâmetros nesse GET:
    - *order*: **'asc'** (ascendente) ou **'desc'** (descendente) em relação ao nome dos contatos existentes
    -  *nacionality*: esse parâmetro receberá a nacionalidade dos contatos requeridos.

    ```
    GET http://localhost:8080/contacts?nacionality=Brasileiro&order=desc
    ```

### Consultar um Único Contato
```
GET http://localhost:8080/contacts/{ id }
```

### Atualizar um Contato
```
PUT http://localhost:8080/contacts/{ id }
{
    "name": "Santiago",
    "lastName": "Martínez",
    "age": 22,
    "nacionality": "Angentino",
    "email": "martinez@gmail.com"
}
```

### Excluir um Contato
```
DELETE http://localhost:8080/contacts/{ id }
```
