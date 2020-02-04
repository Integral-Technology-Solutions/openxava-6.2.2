### To build the application
    cd workspace/CDR-JPA/
    ant createWar
    cp workspace.dist/CDR-JPA.dist/CDR-JPA.war config/docker/deploy

### To build and deploy the application on Openshift (First time only)

    oc new-project cdr-product-ui
    oc new-build --image-stream=jboss-webserver30-tomcat8-openshift:1.3 --binary=true --name=cdr-product-ui
    oc start-build cdr-product-ui --from-dir=config/docker/deploy
    oc new-app cdr-product-ui --allow-missing-imagestream-tags
    oc expose svc/cdr-product-ui

### To rebuild and redeploy the application on Openshift

    oc start-build cdr-product-ui --from-dir=config/docker/deploy