Meta:
@Android
Scenario: Email Registration

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email: <email> and valid password: <password>
And tap creat account
Then he can use the collar without involving any social networks

Examples:
|Meta:|username|email|password|
|@Android|Test011|test12349@aa.com|Test1234&|