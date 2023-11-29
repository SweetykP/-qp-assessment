FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} grocerybookingapp.jar
ENTRYPOINT ["java","-jar","/grocerybookingapp.jar"]


#docker build -t /grocerybookingapp .jar

#docker run --rm -d -p 8080:8080 --env-file .env_local /grocerybookingapp.jar
#docker run --rm -d -p 8080:8080 --env-file .env_demo_server /grocerybookingapp.jar
#docker run --rm -d -p 8080:8080 --env-file .env_production_server /grocerybookingapp.jar
#
#docker pull 7hesaagar/grocerybookingapp:latest
#docker push 7hesaagar/grocerybookingapp:latest