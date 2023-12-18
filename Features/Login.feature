Feature: Login with valid credentials 
#ctrl+shift+f pretty format

@Sanity 
Scenario: Successful login using valid credentials 
	Given User Launch browser 
	And opens URL "https://tutorialsninja.com/demo/index.php" 
	
	When user navigate to MyAccount menu 
	And Click on Login 
	And User Enter Email as "utkarsh.kumar97@gmail.com" and Password as "Test@123" 
	And User click on Login button 
	
	Then user navigate to the My Account Page 
	
	
