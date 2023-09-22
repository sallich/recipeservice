# Recipe service
## About service
The program is a multi-user web service based on Spring Boot that allows storing, retrieving, updating, and deleting recipes. Also service  supports the registration process, can handle a lot of users, and each of them can add their own recipes.
## How to Run
* An installed docker is required.
* Assemble the image using the command 
    `docker build -t <image_name> <path to Dockerfile>`
* After successfully assembling the image, you can launch the container using
   `docker run <image_name>`.
* You will get a working service on port 8080.
## Allowed endpoints
### GET /recipe/{name}
Returns a JSON array of all recipes with the names that contain the specified parameter. Search is case-insensitive
### GET /recipe/{id}
Returns a recipe with a specified id as a JSON object (where {id} is the id of a recipe). The server should respond with the 200 (Ok) status code. If a recipe with a specified id does not exist, the server should respond with 404 (Not found).
### GET /recipe/{category}
Returns a JSON array of all recipes of the specified category. Search is case-insensitive.
### POST /recipe/new
Receives a recipe as a JSON object and returns a JSON object with one id field.
### DELETE /recipe/{id}
Deletes a recipe with a specified id.
### PUT /recipe/{id}
Receives a recipe as a JSON object and updates a recipe with a specified id. Also, update the date field too. The server should return the 204 (No Content) status code. If a recipe with a specified id does not exist, the server should return 404 (Not found). The server should respond with 400 (Bad Request) if a recipe doesn't follow the restrictions indicated above
### GET /user/{id}
Returns a user with a specified id as a JSON object (where {id} is the id of a user). The server should respond with the 200 (Ok) status code. If a user with a specified id does not exist, the server should respond with 404 (Not found).
### GET /alluser
Returns all users
### POST /user/new
Receives a user as a JSON object and registers a user
### DELETE /user/{id}
Deletes a user with a specified id.

