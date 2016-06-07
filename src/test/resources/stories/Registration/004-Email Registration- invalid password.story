Meta:
@Android
Scenario: Email Registration- invalid password

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email: <email> and invalid password: <password>
Then an error message shows on the input with a problem
And the Register button never becomes selectable and so registration cannot occur

Examples:
|Meta:|username|email|password|
|@Android|Test016|test12349@aa.com|Test12|