
Pease use below sample jason data for spring boot rest api testing.

Method: POST
http://localhost:9090/api/register


{
        "userName": "TestUser",
        "userFirstName": "TestFirstName",
        "userLastName": "TestLastName",
        "userPassword": "Password",
        "emailId": "testemail@gmail.com",
        "phoneNumber": "1234567890"
}

Method:POST 
http://localhost:9090/api/login

{
     "userName": "TestUser",
    "userPassword": "Password"
}

Sample output
User:TestUser successfully logged in and JWT Token is : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqaXR1ZGVzYWxlIiwiZXhwIjoxNjUzMjgxNjg1LCJpYXQiOjE2NTMyNjM2ODV9.g0d0AVrV1uo9gH2er45NbSiJPvqXX27KwgzvhCXKUHHJi8bwW2ElQRrnWvPzw6kf0XFjlnuuljsVRcVWGqZN1w



Method:GET  Use the above token in header get the user details
http://localhost:9090/api/users/{uuid}
e.g.
http://localhost:9090/api/users/TestUser
Sample output
{
		"userName": "TestUser",
        "userFirstName": "TestFirstName",
        "userLastName": "TestLastName",
        "emailId": "testemail@gmail.com",
        "phoneNumber": "1234567890"
}

Method: POST update the user
http://localhost:9090/api/users/{uuid}
e.g.
http://localhost:9090/api/users/TestUser
sample output

{
        "userName": "TestUserupdate",
        "userFirstName": "TestFirstNameUpdate",
        "userLastName": "TestLastNameUpdate",
        "emailId": "testemailupdate@gmail.com",
        "phoneNumber": "0912345677"
}

