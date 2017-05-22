# gitStatisticsBarChart1
I have used JGit plugin to evaluate git statistics, Java 8, maven, Restful Webservice to send the JSON data to front end, JSChart for representing the data graphically, JQuery, HTML5(css,java script) to create the solution for the requirement given. Please share this with the client. Below is the output for number of commits done in 2017 for repository https://github.com/angular/angular.git 

To run the report(deploy the application) in your local 'git clone https://github.com/angular/angular.git' in your local and
provide the path to your local .git of the cloned project in GitStatisticsDAO which currently do not have a property so is hard coded.
//path for git clone https://github.com/angular/angular.git
Repository repository = builder.setGitDir(new File("C:/Shiva/JS2017/git/angular/.git"))
