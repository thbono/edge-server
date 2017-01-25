FROM java:8-jre-alpine
VOLUME /tmp
ADD edge-server-1.1.jar app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]