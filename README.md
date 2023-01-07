# Sample ofREST application

REST application that provides REST API.

Run CustomerService locally

### Access CustomerService using next REST requests:

GET: localhost:9966/api/v1/users/ - get all customers GET: localhost:9966/api/v1/users/3 - get customer with ID 3

POST: localhost:9966/api/v1/users/ Request body: { "firstName": "Albert", "lastName": "Pike" }

PUT: localhost:9966/api/v1/users/ Request body: { "id": 8, "firstName": "Albert", "lastName": "Wesker" }

DELETE: localhost:9966/api/v1/users/8 - delete customer with ID 8
