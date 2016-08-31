Meta:
@Android
Scenario: Connecting to new collar

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
And I want the collar and my phone to be paired together
Then I can personalize the collar for my dog

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|