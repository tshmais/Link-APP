Meta:
@Android

Scenario: Menu

Given the user opens the app
When wants to log in with email
And logins using valid username: <username> and valid password: <password>
And I want to see my owner profile
Then I am shown the options Edit my info, Change my password, Log out, Close my account

Examples:
|Meta:|username|password|
|@Android|qaa1@gmail.com|P@ssw0rd|