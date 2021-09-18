# Souq : an online shop
## Installation
Download and install [Java 8](https://www.java.com/en/), [Maven](https://maven.apache.org/), [Mysql](https://www.mysql.com/) to get your environment ready to run the API.
## Run
Using Command Line:
- Run Mysql db
- Generate a JAR file `mvnw package && java -jar`.
- Run the app `mvn spring-boot:run`.
   
## Usage
Navigate to http://localhost:8080 for Home Page. Click Login button.
#### User Login:
>#### Requirements in Login Object
>- email.
>- Password.
```json
{
    "email": "test@test.com",
    "password": "test"
}
```
---
#### Create User endpoint (http://localhost:8080/register)
>#### Requirements in Sign Up
>- email.
>- username.
>- Password.
