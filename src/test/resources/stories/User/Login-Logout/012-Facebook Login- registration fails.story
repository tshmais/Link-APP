Meta:
@Android
Scenario: Facebook Login- registration fails

Given the user opens the app
When he is not logged in
And wants to log in with Facebook account
And registration with Facebook fails
Then App remains on the Registration View
And a descriptive error message should appear on the Welcome View
And App process can be killed
And App restarted
And the Welcome View will be presented to the user
And the user will still be able to successfully log in using Facebook account