FROM openjdk:17
WORKDIR /app
ENV HOST=localhost
ENV USERNAME=root
ENV PASS=root@123
COPY build/libs/*.jar app.jar
COPY build/resources/main/application.yml application.yml
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.config.location=classpath:file:/app/application.yml","-jar","app.jar"]