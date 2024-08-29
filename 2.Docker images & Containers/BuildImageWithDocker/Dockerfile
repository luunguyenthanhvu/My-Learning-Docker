# Sử dụng hình ảnh gốc từ Docker Hub với Java 17
FROM openjdk:17

# Đặt biến môi trường cho thư mục làm việc bên trong container
ENV APP_HOME=/app

# Tạo thư mục làm việc bên trong container
WORKDIR $APP_HOME

# Sao chép file JAR đã được build vào thư mục làm việc của container
COPY build/libs/BuildImageWithDocker-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

# Mở cổng 8080 trên container
EXPOSE 8080

# Lệnh để chạy ứng dụng Spring boot
ENTRYPOINT ["java", "-jar", "app.jar"]
