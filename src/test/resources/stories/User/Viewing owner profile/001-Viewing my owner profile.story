Meta:
@Android

Scenario: Viewing my owner profile

Given the user opens the app
When wants to log in with email
And logins using valid username: <username> and valid password: <password>
And I want to see my owner profile
Then I can know if anything needs to be updated

Examples:
|Meta:|username|password|
|@Android|qaa1@gmail.com|P@ssw0rd|