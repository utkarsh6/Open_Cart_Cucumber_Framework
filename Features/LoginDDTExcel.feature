Feature: Login Data Driven 

Scenario Outline: Login Data Driven Excel
	Given User Launch browser 
	And opens URL "https://tutorialsninja.com/demo/index.php" 
	
	When user navigate to MyAccount menu 
	And Click on Login 
	Then Check user navigate to the My Account Page by passing Email and Password with excel row "<row_index>"
	
	Examples: 
		|row_index|
		|1|
		|2|
		|3|
		|4|
		|5|
		
