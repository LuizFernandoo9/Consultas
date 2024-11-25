# Sistema de Gerenciamento de Consultas e Exames

## Descrição
API desenvolvida para gerenciar consultas, pacientes, exames e tipos de exames em um sistema de saúde. A aplicação oferece funcionalidades completas de **CRUD** e segue boas práticas de desenvolvimento, utilizando tecnologias robustas como Spring Boot e PostgreSQL.

---

## Funcionalidades
### **Pacientes**
- **Criar paciente**: Cadastro de novos pacientes no sistema.
- **Buscar pacientes**: Filtragem por nome e CPF.
- **Editar paciente**: Atualização de dados, como e-mail e telefone.
- **Excluir paciente**: Remoção de pacientes por ID.

### **Exames**
- **Criar exame**: Cadastro de exames associados a tipos de exames.
- **Buscar exames**: Busca por todos os exames ou por nome.
- **Editar exame**: Atualização de informações como nome e observações.
- **Excluir exame**: Remoção por ID.

### **Tipos de Exames**
- **Criar tipo de exame**: Cadastro de categorias com nome e descrição.
- **Buscar tipos de exames**: Busca geral ou específica por nome.
- **Editar tipo de exame**: Atualização de informações.
- **Excluir tipo de exame**: Remoção por ID.

### **Consultas**
- **Agendar consulta**: Cadastro de consultas vinculadas a pacientes e exames.
- **Selecionar paciente para consulta**: Busca detalhada por nome ou CPF para associar à consulta.
- **Selecionar exames por tipo de exame**: Retorna os exames disponíveis para o tipo de exame selecionado.

---

## Tecnologias Utilizadas
- **Java 17**: Linguagem principal.
- **Spring Boot**: Framework para construção de APIs REST.
- **PostgreSQL**: Banco de dados relacional.
- **Maven**: Gerenciamento de dependências.
- **Swagger** (Planejado): Documentação da API.

---

## Estrutura do Projeto
- **Controller**: Define os endpoints.
- **Service**: Implementa regras de negócio.
- **Repository**: Interface para interação com o banco de dados.
- **Model**: Representa entidades do banco de dados.
- **DTO**: Objetos de transferência de dados.
- **Exception**: Tratamento de erros personalizados.

---

## Endpoints
### **Pacientes**
- `POST /patients`: Cadastro de paciente.
- `GET /patients`: Listagem geral ou busca por filtros.
- `PUT /patients/{id}`: Atualização de paciente.
- `DELETE /patients/{id}`: Exclusão de paciente.

### **Exames**
- `POST /exams`: Cadastro de exame.
- `GET /exams`: Listagem geral ou busca por nome.
- `PUT /exams/{id}`: Atualização de exame.
- `DELETE /exams/{id}`: Exclusão de exame.

### **Tipos de Exames**
- `POST /type-exams`: Cadastro de tipo de exame.
- `GET /type-exams`: Listagem geral ou busca por nome.
- `PUT /type-exams/{id}`: Atualização de tipo de exame.
- `DELETE /type-exams/{id}`: Exclusão de tipo de exame.

### **Consultas**
- `POST /consults`: Agendamento de consulta.
- `GET /consults/patient`: Busca detalhada de paciente por nome ou CPF para consulta.
- `GET /consults/exams`: Lista os exames associados a um tipo de exame.
  
