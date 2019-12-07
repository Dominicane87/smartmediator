To run application create spring configuration and 
assign stc21.smartmediator.Application as main class.

You also have to perform sql migration on your local postgres server.

USER REST API

User list: GET http://localhost:8080/user 

Search by id: GET http://localhost:8080/user/{id}

Insert user with role "user" and status "new":
POST http://localhost:8080/user
request body: {"email": "user_email", "password_hash": "user_password_hash", "full_name": "user_name"}

Edit user: PUT http://localhost:8080/user/{id}
request body (unchanged fields can be omitted): 
{
    "email": "new_user_email", 
    "password_hash": "new_user_password_hash", 
    "full_name": "new_user_name", 
    "status": "new_status"
}

Delete user: DELETE http://localhost:8080/user/{id}