# we are extending everything from tomcat:8.0 image ...
FROM tomcat:8.0
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY workspace.dist/CDR-JPA.dist/CDR-JPA.war /usr/local/tomcat/webapps/
COPY tomcat-users.xml /usr/local/tomcat/conf/