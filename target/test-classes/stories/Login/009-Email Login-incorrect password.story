Meta:
@Android
Scenario: Email Login-incorrect password

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using correct email: <username> and incorrect password: <password>
Then the user is able to tap Log in
And an error message occurs Incorrect email and/or password

Examples:
|Meta:|username|password|
|@Android|test1234@aa.com|Test10988|