# Desafio projeto integrador individual

- [Descrição](#descrico)
- [Tecnologias](#tech)
- [Como Utilizar](#setting)
- [Requisitos](#requisito)
- [Requisição](#requisicao)
- [Postman](#postman)
- [Swagger](#swagger)


<a id="descrico"></a>
# Descrição

Esse projeto implementa o backend de uma aplicação que permite cadastrar no marketplace de frios produtos, setores de localização, vendedores, 
gerentes do CD de distribuição e também os depósitos de armazenamento para a distribuição- CD.

O objetivo deste projeto é utilizar a regra de negócio acima para exercitar os conceitos de testes, validações, requisição API Rest e portanto,
neste projeto foi criado os seguintes endpoints:

* US-0001: Cadastrar produtos.
* US-0002: Cadastrar Vendedor.
* US-0003: Cadastrar setores de armazenamento.
* US-0004: Cadastrar responsável pelo setor de armazenamento.
* US-0005: Cadastrar Central de armazenamento vinculado.


Cada produto deve ter:
- um nome do produto.
- o tipo de produto (frios, perecíveis).
- data de validade.
- preço do produto.
- ID do vendedor responsável.
- quantidade de produtos.

Um vendedor deve ter:
- nome do vendedor.

Cada setor deve ter:
- uma categoria.
- capacidade de armazenamento.
- Id do Galpão vinculado.

Cada responsável deve ter: 
- nome.
- galpão vinculado.

Cada central de armazenamento deve ter:
- ID do responsável.



<a id="tech"></a>
## Tecnologias 
O projeto desenvolvido utiliza as seguintes tecnologias:

- [Maven](https://maven.apache.org/)
- [Java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Spring](https://spring.io/)
- [Lombok](https://projectlombok.org/)
- [Junit](https://junit.org/junit5/docs/current/user-guide/)
- [Github actions](https://github.com/features/actions) - CI(Maven, docker)
- [Docker](https://www.docker.com/)
- [Docker-compose](https://docs.docker.com/compose/compose-file/compose-file-v3/)
- [MySQL](https://www.mysql.com/)
- [Swagger](https://swagger.io/)

<a id="requisito"></a>
## Requisitos para rodar o projeto:

- [Docker](https://docker-docs.netlify.app/docker-for-mac/install/#where-to-go-next)
- [Docker-compose](https://docker-docs.netlify.app/compose/install/)

```bash
#Após os requisitos instalados, é possível inicializar o projeto
```
<a id="setting"></a>
## Como utilizar:

```bash
# Clone o Repositório
$ git clone https://github.com/amandaamabili/projeto-individuall.git
```
```bash
# Após estar na pasta do projeto, escreva o comando no terminal para buildar o container
$ docker-compose up -d --build
```
```bash
# Inicialize o projeto na IDE na porta 8080
```

### Inicie as requisições no postman
[Postman](#postman)

### Passos adicionais
```bash
# Para pausar o container
$ docker-compose down
```
```bash
# Para subir o container novamente
$ docker-compose up -d
```
<a id="requisicao"></a>
## Requisições

```sh
(POST)   http://localhost:8080/api/v1/fresh-products/product
(POST)   http://localhost:8080/api/v1/fresh-products/seller
(POST)   http://localhost:8080/api/v1/fresh-products/sector
(POST)   http://localhost:8080/api/v1/fresh-products/manager
(POST)   http://localhost:8080/api/v1/fresh-products/warehouse
(GET)    http://localhost:8080/api/v1/fresh-products/product/count?productName=Banana

   ```
 -Para maiores detalhes sobre retorno dos endpoints, encontra-se no link do swagger após o projeto rodando na porta 8080.
 
<a id="postman"></a>
### Postman
Coleção disponibilizada no postman.

https://www.getpostman.com/collections/99f2cb2bafc3082f2302

<a id="swagger"></a>
### Swagger

Endereço: http://localhost:8080/swagger-ui/index.html

```
{"openapi":"3.0.1","info":{"title":"OpenAPI definition","version":"v0"},"servers":[{"url":"http://localhost:8080","description":"Generated server url"}],"paths":{"/api/v1/fresh-products/inboundorder/update":{"put":{"tags":["in-bound-order-controller"],"operationId":"updateInBoundOrder","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/InboundOrderRequestDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/warehouse":{"post":{"tags":["ware-house-controller"],"operationId":"insertWareHouse","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/WareHouseDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/seller":{"post":{"tags":["seller-controller"],"operationId":"insertSeller","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/SellerDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/sector":{"post":{"tags":["sector-controller"],"operationId":"insertSector","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/SectorDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/product":{"post":{"tags":["product-controller"],"operationId":"insertProduct","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/ProductDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/manager":{"post":{"tags":["manager-controller"],"operationId":"insertManager","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/ManagerDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}},"/api/v1/fresh-products/inboundorder/insert":{"post":{"tags":["in-bound-order-controller"],"operationId":"create","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/InboundOrderRequestDTO"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"object"}}}}}}}},"components":{"schemas":{"BatchStockDTO":{"type":"object","properties":{"batchNumber":{"type":"integer","format":"int64"},"product":{"type":"integer","format":"int64"},"currentTemperature":{"type":"number","format":"float"},"minimumTemperature":{"type":"number","format":"float"},"initialQuantity":{"type":"integer","format":"int64"},"currentQuantity":{"type":"integer","format":"int64"},"manufacturingDate":{"type":"string","format":"date-time"},"manufacturingTime":{"type":"string","format":"date-time"},"dueDate":{"type":"string","format":"date-time"}}},"InboundOrderRequestDTO":{"type":"object","properties":{"orderId":{"type":"integer","format":"int64"},"dateTime":{"type":"string","format":"date-time"},"sector":{"$ref":"#/components/schemas/SectorDTO"},"batchStockList":{"type":"array","items":{"$ref":"#/components/schemas/BatchStockDTO"}},"sectorID":{"type":"integer","format":"int64"}}},"SectorDTO":{"type":"object","properties":{"sectorId":{"type":"integer","format":"int64"},"category":{"type":"string"},"capacity":{"type":"number","format":"double"},"idWareHouse":{"type":"integer","format":"int64"}}},"WareHouseDTO":{"type":"object","properties":{"wareHouseId":{"type":"integer","format":"int64"},"id_manager":{"type":"integer","format":"int64"}}},"SellerDTO":{"type":"object","properties":{"sellerName":{"type":"string"}}},"ProductDTO":{"type":"object","properties":{"productName":{"type":"string"},"productType":{"type":"string"},"validateDate":{"type":"string","format":"date-time"},"price":{"type":"number","format":"double"},"idSeller":{"type":"integer","format":"int64"},"bulk":{"type":"number","format":"double"}}},"Manager":{"type":"object","properties":{"managerId":{"type":"integer","format":"int64"},"managerName":{"type":"string"}}},"ManagerDTO":{"type":"object","properties":{"managerId":{"type":"integer","format":"int64"},"managerName":{"type":"string"},"wareHouse":{"$ref":"#/components/schemas/WareHouse"}}},"WareHouse":{"type":"object","properties":{"wareHouseId":{"type":"integer","format":"int64"},"manager":{"$ref":"#/components/schemas/Manager"}}}}}}
```
