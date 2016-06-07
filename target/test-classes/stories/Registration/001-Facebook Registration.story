Meta:
@Android
Scenario: Facebook Registration

Given the user opens the app
When the user is creating an account
And wants to log in with Facebook account
And not authorized already
And the user will be asked for permission to share public profile and email
And the user brought to the Registration View with the name and email fields
And taps on Create account
Then App displays the Collar Setup view
And App can be terminated and restarted, and still be on the Collar Setup view