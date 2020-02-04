# we are extending everything from tomcat:8.0 image ...
FROM tomcat:latest
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY config/docker/ROOT.war /usr/local/tomcat/webapps/
COPY config/docker/tomcat-users.xml /usr/local/tomcat/conf/
COPY config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/


RUN chown -R tomcat:tomcat /tmp/
RUN groupadd -r tomcat && useradd -r -g tomcat tomcat
RUN chown -R tomcat:tomcat /usr/local/tomcat/webapps/
USER tomcat

EXPOSE 8080

