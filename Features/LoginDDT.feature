Feature: Login Data Driven 

Scenario Outline: Login Data Driven 
	Given User Launch browser 
	And opens URL "https://tutorialsninja.com/demo/index.php" 
	
	When user navigate to MyAccount menu 
	And Click on Login 
	And User Enter Email as "<email>" and Password as "<password>" 
	And User click on Login button 
	
	Then user navigate to the My Account Page 
	
	Examples: 
		| 	email			                |password |
		|	utkarsh.kumar97@gmail.com		|Test@123 | 
		|	utkarsh8w7@gmail.com			|Test@123 |
		
