Meta:
@Android
Scenario: Email Login-tappable login button

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using valid username: <username> and valid password: <password>
Then Log in button should become tappable

Examples:
|Meta:|username|password|
|@Android|test1234@aa.com|Test1234&|