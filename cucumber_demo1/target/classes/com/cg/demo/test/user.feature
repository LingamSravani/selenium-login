Feature: login 

Scenario: to get login page 
	Given login link and sign in 
	When username is "sravani" 
	And password "pass" 
	Then login successfully 
	
	
Scenario: to get login page 
	Given login link and sign in 
	When username is "sravani" 
	And password "sravani" 
	Then invalid password 
	
	
Scenario: to get login page 
	Given login link and sign in 
	When username is "sravslingam@gmail.com" 
	And password "sravani2526" 
	Then invalid login details 
