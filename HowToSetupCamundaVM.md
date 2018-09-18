# Steps to setup an Ubuntu 18.04 VM with Camunda
## Prerequisites
* Base image: ubuntu 18.04 (64 bit)
* Disk space: About 15 GB, but definitely more than 10 GB to not run into space problems
* Memory: 6 GB

## Softwares to install and configure:
* Install Oracle JDK (One can also use OpenJDK, in that case, skip this step)
  * sudo apt-add-repository ppa:webupd8team/java
  * sudo apt-get update
  * sudo apt-get install oracle-java8-installer
* Maven: Use the sudo apt install maven command
* Git: Use the sudo apt install git command
* Clone the camunda github repository in a folder of your choice
  * git clone https://github.com/abhi42/camundacon2018
* Postgres DB installation - See https://help.ubuntu.com/community/PostgreSQL
  * sudo apt install postgresql postgresql-contrib 
  * sudo -u postgres psql postgres
    * on the postgres command prompt, specify the password for the postgress user: \password postgres
	* Create database
	  * sudo -u postgres createdb camunda
	* Check if the database is ready to receive connections
	  * pg_isready
* Camunda Modeller (to view th BPMN diagram in the async project downloaded from the github repository) - Download the Linux 64 bit version from https://camunda.com/download/modeler/
  * Install gconf2 (required to start the camunda modeller)
    * sudo apt install gconf2
*  Intellij - Download the Linux version from https://www.jetbrains.com/idea/download (or use any IDE of your choice)
  