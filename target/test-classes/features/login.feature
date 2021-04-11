Feature: Login into Application 

Scenario Outline: Positive test validation login 
	Given Initiatialize driver with ChromeDriver 
	And Navigate to "http://www.qaclickacademy.com/" Site 
	And Click on Login link in home page to land on Secure Sign in Page 
	When User enters <username> and <password> and logged in 
	Then Verify if User is successfully logged in 
	
	Examples: 
		|username	|password 	|
		|test99@gmail.com	|pass@123	|
		|test98@gmail.com	|pass@123	|
