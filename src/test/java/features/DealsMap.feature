Feature: Deal data creation 

Scenario Outline: Cogmento CRM Create a new deal scenario 

Given user is already on Login page 
When Title of login page is Cogmento CRM 
Then User enters "<username>" and "<password>"
Then User clicks on Login button 
Then User is on HomePage 
Then user moves to new deal page 
Then user enters deal details "<title>" and "<amount>" and "<probability>" and "<commission>"
Then Close the browser 

#comment
	// Test Comment
Examples:
	
	|username | password | title | amount | probability | commission |
	| surabhi.gutch@gmail.com | May@2020 | test deal1 | 1000 | 50 | 20 |
	| surabhi.gutch@gmail.com | May@2020 | test deal2 | 2000 | 60 | 30 |
	| surabhi.gutch@gmail.com | May@2020 | test deal3 | 3000 | 70 | 40 |
	#| surabhi.gutch@gmail.com | May@2020 | test deal4 | 4000 | 80 | 50 |
		
	
