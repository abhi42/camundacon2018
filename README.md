This repository demonstartes to setup Camunda applications that run in separate JVMs, but use the same Camunda central task list. 
The repository consists of 2 projects, each being a spring boot application:
* The Camunda web application that consists of the Tasklist, Cockpit and Admin functionalities
* A simple BPMN process implemented with Camunda. Process instances are started through the Tasklist of the Camunda web application. UI elements (user tasks) of this process are displayed in the task list offered by the Camunda web application.

Each Camunda application uses the same Camunda postgreSQL DB since they both share the task list. 
