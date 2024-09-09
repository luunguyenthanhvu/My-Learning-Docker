# Build Maven project 
  * -mvn clean package -> target/<project_name>.jar
    
# Run Maven project
   RUN mvn package -DskipTests

# Build Gradle project  
  * ./gradle build -> build/<project_name>.jar
    
# Run Gradle project
  *    RUN ./gradlew build --no-daemon
  
# Run Spring boot project
  * ENTRYPOINT ["java", "-jar", "app.jar"]

 # Tạo 1 Image với Gradle không cần sẵn file JAR
   * EX: ![Example Image](./img%20for%20notes/create-image-gradle.png)
   * Lưu ý: Trong build gradle cần có bootJar ![Example Image](./img%20for%20notes/note_for_create_gradle_img.png)

# Khi làm việc cần Quản lý các Volume và NetWork không còn sử dụng
  * Các bước xóa volume và network
    -	docker volume ls
    -	docker volume prune 
    -	docker network ls
    -	docker network prune
