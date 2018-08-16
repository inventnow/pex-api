FROM anapsix/alpine-java:8u172b11_jdk
VOLUME /tmp
COPY target/pex-api-*.jar pex-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xms768m","/pex-api.jar"]