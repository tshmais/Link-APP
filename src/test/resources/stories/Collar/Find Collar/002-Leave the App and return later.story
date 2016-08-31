Meta:
@Android
Scenario: Leave the App and return later

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
And I am setting up my collar I want to be presented with all the collars my phone can detect
And I close the App
Then If I relaunch the Link app when it was in the background and not terminated I expect to be brought back to the Nearby Collars view

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|