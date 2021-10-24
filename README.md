# Foobar

demo-mybank is a demo app for spring boot rest api backend for accounts and get transactions for an account.

## Run the application locally

Follow below command to run the application.

```bash
	- Clone the project from github repo.
	- mvn clean install
	- mvnw spring-boot:run

```

## Using docker

Follow below command to run the application as docker images

```bash
- docker build -t assignment/mycompany-accounts .
- docker run -p 8080:8080 assignment/mycompany-accounts

```
## Documentation
After running the application , we can see the Open API documentation at below path:

**http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/** 



## Endpoints

**/accounts** \
**/accounts/{id}** \
**/accounts/{id}/transactions**

## Test application.
1) Open **http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/** \

![alt text](https://github.com/vipinsaini434/demo-mybank/blob/main/documentaion.PNG?raw=true)

2) Go to Get /accounts and execute, We will get list of accounts which were added at the start of application. \

3) We can take any accountId ,say 52 and we make another call to fetch info of account using /accounts/52 \

4) To fetch transactions of an account we can use third end point.
/accounts/52/transactions






