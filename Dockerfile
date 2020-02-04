# we are extending everything from tomcat:8.0 image ...
FROM tomcat:latest
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY config/docker/ROOT.war /usr/local/tomcat/webapps/
COPY config/docker/tomcat-users.xml /usr/local/tomcat/conf/
COPY config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/

USER root

EXPOSE 8080

