Meta:
@Android
Scenario: Setting your photo after registration

Given the user opens the app
When the user tap on signup with email
And enter valid Name: <username> and valid email and valid password: <password>
And tap create account
Then I am taken through the profile photo flow

Examples:
|Meta:|username|password|
|@Android|Test011|Test1234&|