Meta:
@Android
Scenario: Email Registration- already registered

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and already registered email: <email> and valid password: <password>
Then the user should see an informative message indicating that the provided email address is already registered
And the message should prompt the user to login instead

Examples:
|Meta:|username|email|password|
|@Android|Test016|test12349aa.com|Test12378|