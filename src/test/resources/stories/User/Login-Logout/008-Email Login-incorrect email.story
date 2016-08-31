Meta:
@Android
Scenario: Email Login-incorrect email

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using incorrect email: <username> and password: <password>
Then the user is able to tap Log in
And an error message occurs Incorrect email and/or password

Examples:
|Meta:|username|password|
|@Android|tetsaa.com|Test1234&|