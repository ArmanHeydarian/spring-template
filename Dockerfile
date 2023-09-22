FROM openjdk:17
MAINTAINER embea.com
COPY target/policy-service-0.0.1-SNAPSHOT.jar policy-service.jar
ENTRYPOINT ["java","-jar","/policy-service.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]