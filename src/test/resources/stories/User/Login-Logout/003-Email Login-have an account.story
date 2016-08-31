Meta:
@Android
Scenario: Email Login-have an account

Given the user opens the app
When he taps on I already have an account on the Welcome view
And logins using valid username: <username> and valid password: <password>
Then he is taken to the default initial view of the Link app

Examples:
|Meta:|username|password|
|@Android|user28683@linkbyakc.com|P@ssw0rd|