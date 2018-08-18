Points to talk about
* async before a service task and for service task after ui task (otherwise the service task will run in the same thread as the ui task i.e on teh camunda web app and the class will not be found)
* using async before in a service task only to ensure that if there is an incident, processing begins from that task and not the last task encountered in the chain backwards that was marked as async
* example where you do not need to use async before in a service task (e.g. idempotent operations)
* UI task: One can specify a task or execution listener on task creation or execution start. Provided the UI task has async before, the task or execution listener (on start or create) will execute asynchronously and hence in the correct process.  
* UI task: Task and job execution listeners post UI task (i.e. completion or end) cannot be defined since they will be run in the UI thread that runs onthe camunda web app. This is the case even if the UI task has async after. 
* reverse proxy for showing embedded forms
* camunda web app needs to be task aware
* spin plugin needs to be present in the camunda webapp since the POST response from the webform goes back to the webapp and in this case there is serialization in json. The rest web service in the camunda web app handles this POST and writes the serialized data to the database for this task. It does not handle this data (other than writing it to the db) since the camunda web app also needs to be task aware
* configure the time period when the thread runs to pick up tasks from the database
* Best practices as mentioned by camunda

TODO:
* D What is the limitation of task and execution listeners present as pre or post UI task?
* What is the meaning of "exclusive" when one chooses asyncBefore or asyncAfter?
* Job that is completely synchronous (normal job) to show that it will not run
* Deploy the plugin that shows listeners in the camunda modeller

POINTS TO WORK ON:
* Task and executions listeners cannot be present in UI task. Cmunda best practices for async execution
* Understand job execution timer configuration and what the max and other variables mean
* Presentation
  * Contents
    * Sequence diagram showing how a UI task is handled (including response back to the camunda web app, serialization)
  * Time the presentation
