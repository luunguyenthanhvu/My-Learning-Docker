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
   *
