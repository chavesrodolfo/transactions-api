# Transactions API

## Rotina de transações 
Cada portador de cartão (cliente) possui uma conta com seus dados. 
A cada operação realizada pelo cliente uma transação é criada e associada à sua respectiva conta. 
Cada transação possui um tipo (compra a vista, compra parcelada, saque ou pagamento), um valor e uma data de criação. 
Transações de tipo **compra e saque** são registradas com **valor negativo**, enquanto transações de **pagamento** são registradas com **valor positivo**.

### Entidades
*Account*

| id | document |
| - | - |
| 1 | 12345678900 |

*OperationType*

*enum*

| id | description |
| - | - |
| 1 | COMPRA A VISTA |
| 2 | COMPRA PARCELADA |
| 3 | SAQUE |
| 4 | PAGAMENTO |

*Transaction*

| id | account_id | operationType_id | amount | eventDate |
| - | - | - | - | - |
| 1 | 1 | 1 | -50.0 | 2020-01-01T10:32:07.7199222 |
| 2 | 1 | 1 | -23.5 | 2020-01-01T10:48:12.2135875 |
| 3 | 1 | 1 | -18.7 | 2020-01-02T19:01:23.1458543 |
| 4 | 1 | 4 | 60.0 | 2020-01-05T09:34:18.5893223 |

Na tabela de `Transaction`, a coluna `amount` guarda o valor da transação e a coluna `eventDate` guarda o momento em que ocorreu a transação.


### Endpoints

* POST /accounts (criação de uma conta)

    Request Body:

    ```properties
    { 
        "document_number": "12345678900"
    }
    ```

* GET /accounts/:id (consulta de informações de uma conta)   

    Response Body:

    ```properties
    { 
        "account_id": 1,
        "document_number": "12345678900"
    }
    ```

* POST /transactions (criação de uma transação) 

    Request Body: 

    ```properties
    { 
        "account_id": 1,
        "operation_type_id": 4,
        "amount": 123.45
    }
    ```

## Uso

Execute `mvn install`para gerar o pacote no `target`.

Execute `mvn spring-boot:run` para executar o serviço com Maven/Spring Boot.

Execute `docker build -t transactions_api .` no diretório raiz para gerar a imagem Docker.

Execute `docker run --name transactions_api -p 8081:8080 transactions_api` para colocar o container em execução.

Execute `docker start transactions_api` para iniciar o container já criado.

Execute `docker rm -f transactions_api` para remover o container.