# MS-Cliente-Cadastro
###### Projeto Back-end 
API Rest contendo operações e fluxo completo, para cadastro e manutenção de clientes


## Tecnologias

- Java JDK 17      -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Maven           -> https://maven.apache.org/
- Swagger         -> https://swagger.io/
- SpringBoot      -> https://spring.io/projects/spring-boot
- SpringData      -> https://spring.io/projects/spring-data
- Lombok          -> https://projectlombok.org/
- Hibernate       -> https://hibernate.org/
- H2 (Em Memoria) -> https://www.h2database.com/html/main.html


## Serviços

| Metodo  |  End Point  | Descrição |
| ------------| ---------|---------|
|  POST  | /clientes/v1/add     | Cria o Cadastro do Cliente  |
|  GET  |  /clientes/v1/find     | Obtém a informação de um Cliente |
|  GET  |  /clientes/v1/list   | Obtém a lista de todos os clientes |
|  DELETE  |  /clientes/v1/{id}     | Exclui o Cadastro do Cliente. |
|  PUT  |  /clientes/v1/edit     | Atualiza o Cadastro do Cliente. |

## Documentação
https://documenter.getpostman.com/view/16523713/UyrHfYfm

## Swagger - Local Porta 8080
http://localhost:8080/clientes/swagger-ui/index.html
  
## Executar projeto (Maven)
1 - Entrar na pasta do projeto

2 - mvn clean package

3 - java -jar target/ms-cliente-cadastro-0.0.1-SNAPSHOT.jar




 **Contato**
* leonardobarrosbhz@gmail.com
