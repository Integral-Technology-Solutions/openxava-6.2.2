To build and deploy the application on Openshift

    oc new-project cdr-product-ui
    oc new-build --image-stream=jboss-webserver30-tomcat8-openshift:1.3 --binary=true --name=cdr-product-ui
    oc start-build cdr-product-ui --from-dir=config/docker/deploy
    oc new-app cdr-product-ui --allow-missing-imagestream-tags
    oc expose svc/cdr-product-ui

