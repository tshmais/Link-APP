Meta:
@Android
Scenario: Email Login

Given the user opens the app
When he is not logged in
And wants to log in with email
And logins using valid username: <username> and valid password: <password>
Then he can use the app to control the collar

Examples:
|Meta:|username|password|
|@Android|test1234@aa.com|Test1234&| 