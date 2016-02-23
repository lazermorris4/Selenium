# Selenium
Summary : Selenium Framework developed using spring MVC.

Langauages used
UI - HTML/CSS
Client side scripting - jQuery
Other features used- Ajax
Source code management - git

Pre Requisites:
Server - Apache Tomcat 8.0
IDE - Eclipse IDE for Java EE developers
Maven - Maven 3.2 or higher

Other Details:
Selenium Verison used : Selenium 2.45



View
This will be an HTML page with the list of test cases to be executed. For every new test case, the list has to be udpated.
Browsers : Google chrome(All latest versions), Mozilla firefox(All latest versions), internet Explorer(10 or higher)


Model

Driver Controller - Assigns a driver based on the value passed from TripController. Also, controls the different stages of test execution such as Opening the browser, validation, capturing screenshot and closing browser.
Validation - Passes execution to the corresponding class based on id(Used to idetify test case) being passed from Driver Controller.
BrowserOpen - Opens Browser and maximizes it
BrowserClose - Closes all instances of browser.
Capture Screenshot - To capture screenshot of the final page.


Controller
1.Trip Controller
a. displayHtmlPage  - Once the project is deployed on Tomcat server, it displays the HMTL page
b. validation - passes the list of test cases(along with the browser selected) to Driver controller class

