# API de Consultas

## 📝 Descrição
Esta API foi desenvolvida para gerenciar consultas médicas, pacientes, tipos de exame e exames, com operações CRUD completas e regras de negócio específicas. Criada com foco em boas práticas e escalabilidade, a API utiliza Java 17, Spring Boot e PostgreSQL.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **Swagger**
- **JUnit 5** (implementação futura para testes)

## ✨ Funcionalidades
- **Cadastro de pacientes:** Permite adicionar pacientes com validação de CPF único, e-mail e telefone.  
- **Cadastro de tipos de exame:** Adiciona categorias de exames com nome e descrição.  
- **Cadastro de exames:** Cria exames vinculados a um tipo, com opção de observações.  
- **Listagem e busca de pacientes e exames:** Oferece filtros por nome, CPF ou categoria.  
- **Agendamento de consultas:** Agenda consultas médicas vinculando pacientes e exames a uma data/hora, garantindo que não haja conflitos de horários.  
- **Alteração de dados:** Atualização de pacientes, tipos de exame e exames.  

## 📑 Estrutura das Rotas e Regras de Negócio

| Método | Rota                    | Descrição                                                                                      |
|--------|--------------------------|------------------------------------------------------------------------------------------------|
| POST   | `/pacientes`            | Cria um novo paciente com validações de CPF, e-mail e telefone.                               |
| GET    | `/pacientes`            | Lista todos os pacientes, com filtro por nome ou CPF.                                         |
| PUT    | `/pacientes/:id`        | Atualiza informações de um paciente pelo `id`.                                               |
| DELETE | `/pacientes/:id`        | Remove um paciente, exceto se vinculado a consultas futuras.                                  |
| POST   | `/tipos-exame`          | Cria um novo tipo de exame com nome e descrição.                                              |
| GET    | `/tipos-exame`          | Lista os tipos de exame cadastrados.                                                         |
| POST   | `/exames`               | Cria um exame vinculado a um tipo de exame, com campo opcional para observações.              |
| GET    | `/exames`               | Lista exames cadastrados, com filtros opcionais por nome e tipo.                             |
| POST   | `/consultas`            | Agenda uma nova consulta, verificando conflitos de horário e gerando número de protocolo.     |

## 🗂️ Estrutura do Projeto
- **`/src/main/java`**: Código fonte da aplicação.
- **`/src/main/resources`**: Configurações, como o `application.properties` com detalhes de conexão ao banco de dados.
- **`/src/test`**: Testes unitários e de integração para validação das rotas e regras de negócio (em desenvolvimento).

## 📦 Dependências
Este projeto utiliza as seguintes dependências:

- **Spring Boot Starter Data JPA**: Para integração com o banco de dados e manipulação de dados.
- **Spring Boot Starter Validation**: Validações de dados de entrada.
- **Spring Boot Starter Web**: Para criação e gerenciamento de endpoints REST.
- **PostgreSQL Driver**: Conexão com o banco de dados PostgreSQL.
- **Lombok**: Simplifica o código com anotações para geração automática de getters, setters e construtores.
- **Spring Boot Starter Test**: Framework de testes (JUnit 5) para validação de funcionalidades e rotas (ainda a ser implementado).

## 📜 Documentação da API
O **Swagger** foi utilizado para documentar os endpoints, facilitando a compreensão e teste da API. Acesse a interface de documentação em `/swagger-ui.html` após iniciar a aplicação.

## ⚙️ Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/api-consultas.git
   
2. **Instale as dependencias**:
   mvn install

3. **Execute a aplicação**:
   mvn spring-boot:run 