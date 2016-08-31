Meta:
@Android
Scenario: Select the wrong Unregistered Collar

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
And I want the collar and phone to be paired together
And I observe that the collar I wanted to connect to does not have its light blinking
Then I should be able to tap on No
And select a different collar to go back to the Nearby Collars results to select a different collar

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|