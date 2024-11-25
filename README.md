# API de Gerenciamento de Consultas e Exames  

📝 **Descrição**  
API desenvolvida para gerenciar consultas, pacientes, exames e tipos de exames em um sistema de saúde. A aplicação oferece funcionalidades completas de CRUD e segue boas práticas de desenvolvimento, utilizando Java 17, Spring Boot e PostgreSQL.  

---

🚀 **Tecnologias Utilizadas**  
- Java 17  
- Spring Boot  
- PostgreSQL  
- Swagger (documentação das rotas)  
- JUnit 5 (implementação futura para testes)  

---

✨ **Funcionalidades**  

### **Pacientes**  
- **Criação de paciente**: Adiciona um novo paciente ao banco de dados com dados como nome, CPF e contato.  
- **Listagem de pacientes**: Exibe todos os pacientes cadastrados ou realiza busca por nome ou CPF.  
- **Edição de paciente**: Permite atualizar dados como e-mail e telefone.  
- **Exclusão de paciente**: Remove pacientes do banco de dados pelo ID.  

### **Exames**  
- **Criação de exame**: Cadastra exames associados a tipos de exames específicos.  
- **Listagem de exames**: Exibe todos os exames ou realiza busca filtrada por nome ou tipo de exame.  
- **Edição de exame**: Permite atualização de informações como nome e observação.  
- **Exclusão de exame**: Remove exames pelo ID.  

### **Tipos de Exames**  
- **Criação de tipo de exame**: Cadastra categorias como laboratoriais ou por imagem.  
- **Listagem de tipos de exames**: Exibe todas as categorias cadastradas.  
- **Edição de tipo de exame**: Permite atualizar nome e descrição.  
- **Exclusão de tipo de exame**: Remove categorias pelo ID.  

### **Consultas**  
- **Agendamento de consulta**: Cadastra uma nova consulta associando paciente, tipo de exame, exame e data.  
- **Seleção de paciente**: Busca detalhada de pacientes por nome ou CPF para associar à consulta.  
- **Seleção de exames**: Retorna os exames cadastrados associados a um tipo de exame.  

---

📑 **Estrutura das Rotas e Regras de Negócio**  

| **Método** | **Rota**             | **Descrição**                                                                                                                                     |  
|------------|----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|  
| `POST`     | `/patients`          | Cria um novo paciente com informações pessoais como nome, CPF, e contato.                                                                        |  
| `GET`      | `/patients`          | Lista todos os pacientes ou realiza busca por nome e CPF.                                                                                        |  
| `PUT`      | `/patients/{id}`     | Atualiza informações do paciente, como e-mail ou telefone.                                                                                       |  
| `DELETE`   | `/patients/{id}`     | Remove um paciente cadastrado pelo ID.                                                                                                           |  
| `POST`     | `/exams`             | Cadastra um novo exame associado a um tipo de exame.                                                                                             |  
| `GET`      | `/exams`             | Lista todos os exames ou realiza busca por nome.                                                                                                 |  
| `PUT`      | `/exams/{id}`        | Atualiza informações do exame, como nome e observação.                                                                                           |  
| `DELETE`   | `/exams/{id}`        | Remove um exame do sistema pelo ID.                                                                                                              |  
| `POST`     | `/type-exams`        | Cria um novo tipo de exame com nome e descrição.                                                                                                 |  
| `GET`      | `/type-exams`        | Lista todos os tipos de exames cadastrados.                                                                                                      |  
| `PUT`      | `/type-exams/{id}`   | Atualiza informações de um tipo de exame.                                                                                                        |  
| `DELETE`   | `/type-exams/{id}`   | Remove um tipo de exame do sistema pelo ID.                                                                                                      |  
| `POST`     | `/consults/`         | Agenda uma nova consulta associando paciente, tipo de exame, exame e data.                                                                       |  
| `GET`      | `/consults/patient`  | Busca detalhada por pacientes a partir do nome ou CPF.                                                                                           |  
| `GET`      | `/consults/exams`    | Retorna exames cadastrados para o tipo de exame selecionado.                                                                                     |  

---

🗂️ **Estrutura do Projeto**  
- `/src/main/java`: Código fonte da aplicação.  
- `/src/main/resources`: Configurações da aplicação, incluindo o arquivo `application.properties` para conexão com o banco de dados.  
- `/src/test`: Testes unitários e de integração para validação de funcionalidades (em desenvolvimento).  

---

📦 **Dependências**  

- **Spring Boot Starter Data JPA**: Integração com o banco de dados.  
- **Spring Boot Starter Validation**: Validações automáticas de dados.  
- **Spring Boot Starter Web**: Criação de endpoints REST.  
- **PostgreSQL Driver**: Conexão com o banco de dados PostgreSQL.  
- **Lombok**: Simplificação de código com geração automática de getters, setters e builders.  
- **Spring Boot Starter Test**: Framework para testes (JUnit 5).  

---

📜 **Documentação da API**  
O Swagger foi implementado para facilitar a visualização e o uso das rotas.  

---

⚙️ **Como Executar o Projeto**  

1. Clone o repositório:  
   ```bash  
   git clone https://github.com/seu-usuario/api-gerenciamento.git

2. Acesse o repositório:  
   ```bash  
   cd api-gerenciamento  

3. Instale as depêndencias:  
   ```bash  
   mvn install  

4. Configure o banco de dados no arquivo application.properties:  
   ```properties  
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu-banco  
   spring.datasource.username=seu-usuario  
   spring.datasource.password=sua-senha  

5. Execute a aplicação:  
   ```bash  
   mvn spring-boot:run    
