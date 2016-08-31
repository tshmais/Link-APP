Meta:
@Android

Scenario: Logout

Given the user opens the app
When wants to log in with email
And logins using valid username: <username> and valid password: <password>
And I am presented a menu option to Sign Out
Then on Success, I am brought to the Welcome View upon successful sign out

Examples:
|Meta:|username|password|
|@Android|qaa1@gmail.com|P@ssw0rd|