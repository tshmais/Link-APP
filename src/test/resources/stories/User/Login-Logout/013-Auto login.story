Meta:
@Android
Scenario: Auto login

Given the user opens the app
When he taps on I already have an account on the Welcome view
And the user logs in to his account on the app username: <username> password: <password>
And the login is saved on the app
Then the user doesn't have to log in every time when opening the app

Examples:
|Meta:|username|password|
|@Android|test1234@aa.com|Test1234&|