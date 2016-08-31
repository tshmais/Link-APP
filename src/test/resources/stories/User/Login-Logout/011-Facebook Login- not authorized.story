Meta:
@Android
Scenario: Facebook Login- not authorized

Given the user opens the app
When he is not logged in
And wants to log in with Facebook account
And not authorized already
And the user will be asked for permission to share public profile and email
Then user is logged in
And App displays the Main View