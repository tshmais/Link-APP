Meta:
@Android
Scenario: Finding nearby collars

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
Then I can choose and connect to my new collar

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|