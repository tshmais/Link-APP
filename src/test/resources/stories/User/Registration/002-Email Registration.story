Meta:
@Android
Scenario: Email Registration

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
Then he can use the collar without involving any social networks

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|