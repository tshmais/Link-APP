Meta:
@Android

Scenario: Information Display

Given the user opens the app
When wants to log in with email
And logins using valid username: <username> and valid password: <password>
And I want to see my owner profile
Then I am presented with my profile information Name, Photo, Member since, Email, My owned dogs, Connected Social Accounts

Examples:
|Meta:|username|password|
|@Android|qaa1@gmail.com|P@ssw0rd|