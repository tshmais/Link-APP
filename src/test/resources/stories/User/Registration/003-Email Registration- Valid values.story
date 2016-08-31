Meta:
@Android
Scenario: Email Registration- Valid values

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
Then the server creates the account, logs the user in, and moves to the setup flow

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|