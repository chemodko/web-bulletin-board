## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).
# lab15

## Install Tomcat

  1. download [Apache Tomcat 9](http://tomcat.apache.org/)
  2. unpack to /home/user/apache-tomcat-9.0.39
  3. cd /home/user/apache-tomcat-9.0.39/bin
  4. run Tomcat: bash catalina.sh start

## Configure Tomcat

  1. copy files from this repository to /home/user/apache-tomcat-9.0.39/webapps/
  2. copy /home/user/apache-tomcat-9.0.39/webapps/lab15/tomcat-users.xml to /home/user/apache-tomcat-9.0.39/conf (overwrite existing file)
  4. go to http://localhost:8080/manager/html/ (login:tomcat password:tomcat)
  5. manage your servlets (stop, start, reload etc)

## Compile

  1. cd /home/user/apache-tomcat-9.0.39/webapps/lab15
  2. comile: javac -cp ../../lib/servlet-api.jar:src/ src/*.java -d WEB-INF/classes
  3. reload your servlet using manager (see "Configure Tomcat")
  4. go to: http://localhost:8080/lab15/board
