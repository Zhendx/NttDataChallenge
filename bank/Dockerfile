FROM openjdk:17-jdk-slim
COPY "./build/libs/bank-0.0.1-SNAPSHOT.jar" "app2.jar"
EXPOSE 8083
ENTRYPOINT ["java","-jar","app2.jar"]