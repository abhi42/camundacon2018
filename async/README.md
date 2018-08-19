# Camunda Deployment App
This application has a simple BPMN process to deploy an artifact on a particular IT environment. It uses the same central postgreSQL DB that is used by the Camunda web application. 

The UI tasks for this application are displayed in the task list of the Camunda web application. Thus all user interaction with instances of this process occur through the Camunads web application (that runs in a separate VM) 

In conjunction with the Camunda web application, this application is meant to show how to setup Camunda applications that run in separate JVMs, but use the same Camunda central task list. 

# Points to note
* The deployment application is configured so that any job execution is deployment aware. This means that the job execution thread only executes jobs that are marked as belonging to its own application. This is to prevent any other application from picking up jobs belonging to this application (which would result in ClassNotFoundExceptions).

## Asynchronous execution of service tasks 
* A service task of this application needs to be executed in the JVM of this application, not in that of the Camunda web application. Since the UI of a UI task executes in the JVM of the Camunda web application, measures must be taken to ensure that the service task immediately after the UI task runs in the JVM of this application. Otherwise a ClassNotFoundException (for the JavaDelegate) will occur, since the implementing class is not present in the JVM of the Camunda web application.
  * This is achieved by either 
    * configuring the execution of a new job **BEFORE** the service task is executed
    * configuring the execution of a new job **AFTER** the UI task has completed execution
* In some cases, execution of a new job is configured only for the sake of not executing all tasks with an execution from the beginning in case one of the jobs down the line in the same execution results in an incident. This is the case where the tasks are not idempotent. 
* In case a service task is idempotent and follows another service task, it need not be configured to execute in a new job.
* UI task: One can specify a task or execution listener on task creation or execution start. Provided the UI task is configured so that a new job executes before the UI task, the task or execution listener (on start or create) will execute asynchronously and hence in this application (not the Camunda web application).  
* UI task: Task and job execution listeners specifed after the UI task (i.e. completion or end) cannot be defined since they will be run in the UI thread that runs on the camunda web app. This is the case even if the UI task has been configured to execute a new job AFTER the UI interaction. 
* Configuration of the time period when the job executes to pick up tasks for exectuion for its application from the database 

