FROM tomcat

RUN chmod 777 /usr/local/tomcat/webapps
RUN chmod 777 /usr/local/tomcat/conf
ADD config/docker/cdr.war /usr/local/tomcat/webapps/ROOT.war

# RUN chmod 777 /usr/local/tomcat/lib
ADD config/docker/postgresql-42.2.9.jar /usr/local/tomcat/lib/

# CMD ["catalina.sh", "run"]
