Meta:
@Android
Scenario: Email Registration- invalid email

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and invalid email: <email> and valid password: <password>
Then an error message shows on the input with problem
And the Register button never becomes selectable and so registration cannot occur

Examples:
|Meta:|username|email|password|
|@Android|Test016|test12349aa.com|Test12378|