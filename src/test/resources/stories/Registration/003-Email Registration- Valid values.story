Meta:
@Android
Scenario: Email Registration- Valid values

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email: <email> and valid password: <password>
And tap creat account
Then the server creates the account, logs the user in, and moves to the setup flow

Examples:
|Meta:|username|email|password|
|@Android|Test011|test12340@aa.com|Test1234&|