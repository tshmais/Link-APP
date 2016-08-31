Meta:
@Android

Scenario: Email Login

Given the user opens the app
When he is not logged in
And I want to open a connection to MySQL DB
And I want to pull the data from the DB using $query query with $id
And wants to log in with email
And logins using valid username: <username> and valid password: <password>
Then he can use the app to control the collar