# Selenium
This contains the source code for the restfull service driven selenium framework which was created using MVC framework.

Langauages used
HMTL, CSS, Ajax, Java


View
An HMTL page with the list of test cases and their run status. Each test case can be run using any one of the browsers
Google Chrome, Mozilla firefox or Internent explorer.
A dropdown option enables the user to select the browser.
The user can execute all test cases at once or execute selected test cases. 
There is a checkbox associated with each test case which helps the user in 
selecting the test cases to be executed.


Model
The model contains Java classes to handle Browser Open, Browser close, Open URL, Capture screenshot 
and a validation class to select the class for test case execution based on the test case name passed as part of the Ajax call(Explained below)



Controllers
Two restful services- One to display the HMTL page with the test cases. The second controller is an asynchronous ajax call with the 
test case case to be executed and the browser selected for the particular test case. The response of this call will be the status of the
test case execution
