# we are extending everything from tomcat:8.0 image ...
FROM tomcat:latest
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
ADD config/docker/cdr.war /usr/local/tomcat/webapps/
COPY config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/

CMD ["catalina.sh", "run"]
