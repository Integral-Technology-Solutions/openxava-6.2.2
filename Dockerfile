FROM tomcat
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
# RUN chmod 777 /usr/local/tomcat/webapps
ADD config/docker/cdr.war /usr/local/tomcat/webapps/

# RUN chmod 777 /usr/local/tomcat/lib
# ADD config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/

CMD ["catalina.sh", "run"]
