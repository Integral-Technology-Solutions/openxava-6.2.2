FROM tomcat
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
ADD config/docker/cdr.war /usr/local/tomcat/webapps/
ADD config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/

CMD ["catalina.sh", "run"]
