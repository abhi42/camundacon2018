# Camunda Web App

This is the Camunda web application comprising of the tasklist, cockpit and Admin functionalities.

It talks to the central postgreSQL Camunda DB.

## Points to Note
* The camunda web application is configured so that any job execution is deployment aware. This means that the job execution thread only executes jobs that are marked as belonging to its own application. This is to prevent the camunda web application from picking up jobs belonging to the deployment camunda application.
* Reverse proxy configuration to forward requests meant for the deployment camunda application. This is because we only have a entral camunda task list for all applications.
* The spin plugin needs to be present in the camunda web application since the POST response from the webform goes back to the webapp and in this case there is serialization in json. The rest web service in the camunda web app handles this POST and writes the serialized data to the database for this task. It does not handle this data (other than writing it to the db).
