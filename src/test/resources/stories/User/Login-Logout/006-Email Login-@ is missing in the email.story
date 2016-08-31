Meta:
@Android
Scenario: Email Login-@ is missing in the email

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using email without @: <username> and  password: <password>
Then Descriptive messages appear on the proper inputs after he has given focus to each field and move onto the next field
And the login button is not enabled

Examples:
|Meta:|username|password|
|@Android|test1234aa.com|Test1234&|