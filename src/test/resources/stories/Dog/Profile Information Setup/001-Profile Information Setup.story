Meta:
@Android
Scenario: Profile Information Setup

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
And I want the collar and my phone to be paired together
And I enter in valid data for my dog's name: <name>, age: <age>, weight: <weight> and gender: <gender>
And I tap Next
Then I'm taken to the Choose Breed screen

Examples:
|Meta:|username|password|name|age|weight|gender|
|@Android|Test011|Test1234&|Lucy|5|30|Female|