Meta:
@Android
Scenario: Email Login-blank password

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using username: <username> and empty password: <password>
Then Descriptive message appear on the proper inputs after he has given focus to each field and move onto the next field
And the login button is not enabled

Examples:
|Meta:|username|password|
|@Android|test1234@aa.com||