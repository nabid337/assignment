# assignment

# Task:A (Search Website Search Website)
source code can be found for this task \src\main\java\com\nabid\assignment\controller\SearchController.java

Functionality can be checked at http://localhost:8080/search

# Task:B (DB Seeder)
source code can be found for this task \src\main\java\com\nabid\assignment\seeder\DatabaseSeeder.java

Functionality can be checked on hosting the application at console and reflections can be seen at database.

# Task:C (Front End)
source code can be found for this task \src\main\java\com\nabid\assignment\controller\interviewController

Functionality can checked at http://localhost:8080/interviews

JQuery, AJAX & Bootstrap is used for UI

# Task:D (API)
Authorization Authentication is not implemented in the API's.

source code can be found for this task \src\main\java\com\nabid\assignment\controller\ApiController

GET request:
/getDeveloper/{id} will return developer details by given id in the request. Produces JSON body in the response.

POST request:
/createDeveloper will create a new developer. Sample request body {"email": "bazinga@gmail.com"}. Produces JSON body with newly added developer ID.

PUT request:
/updateDeveloper will update an existing developer. Samle request body 
{"id":1,
"newEmail":"sheldon.cooper@gmail.com"
}
Existing email will be updated by "newEmail".

DELETE request:
/deleteDeveloper/{id} will delete the given ID developer if exists. 
