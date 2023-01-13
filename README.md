# Sample ofREST application

REST application that provides REST API.

Run CustomerService locally

### Access CustomerService using next REST requests:

GET: localhost:9966/api/v1/users/getUser/18

POST: localhost:9966/api/v1/users/saveUser 
      Request body: 
      { 
          "firstName": "Albert", 
          "lastName": "Pike" 
      }

PUT: localhost:9966/api/v1/users/updateUser 
      Request body: 
      { 
          "id": 20,
          "firstName": "Albert", 
          "lastName": "Pike" 
      }
      
DELETE: localhost:9966/api/v1/users/deleteUser/25

GET: localhost:9966/api/v1/users/getAllUsers

### Unit tests
Unit tests for the functionality of the application in the class UserRepositoryTests.
