Meta:
@Android
Scenario: Add another collar

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
And I want the collar and my phone to be paired together
And I enter in valid data for my dog's name: <name>, age: <age>, weight: <weight> and gender: <gender>
And I tap Next
And I select a breed
And I tap the button to add another collar
Then I start the new collar flow again

Examples:
|Meta:|username|password|name|age|weight|gender|
|@Android|Test011|Test1234&|Lucy|7|34|Female|