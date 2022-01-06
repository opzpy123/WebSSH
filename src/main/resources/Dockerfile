FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD webssh.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]