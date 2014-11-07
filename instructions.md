Get started with projectportal2
-----------------------------------
This is a template for Bluemix Java Web database application development.

The sample is a simple todo list where users can add, modify, and delete individual todo items, while those items persist to the backend database. In the sample is a clear demonstration of how to use JPA or JDBC to access the database service that binds to the application.

1. [Install the cf command-line tool](https://www.ng.bluemix.net/docs/#starters/BuildingWeb.html#install_cf).
2. [Download the starter package](https://ace.ng.bluemix.net:443/rest/../rest/apps/6c03f2f6-4685-43c7-93a1-78cd9c914cc7/starter-download).
3. Extract the package and `cd` to it.
4. Connect to Bluemix:

		cf api https://api.ng.bluemix.net

5. Log into Bluemix:

		cf login -u qiant@us.ibm.com
		cf target -o qiant@us.ibm.com -s dev
		
6. Compile the Java code and generate the war package using ant.
7. Deploy your app:

		cf push projectportal2 -p libertyDBApp.war

8. Access your app: [http://projectportal2.mybluemix.net](http://projectportal2.mybluemix.net)
