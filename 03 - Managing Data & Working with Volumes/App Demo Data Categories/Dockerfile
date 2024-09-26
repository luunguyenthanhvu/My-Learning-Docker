# Bước 1: Sử dụng image gradle chính thức để build ứng dụng
FROM gradle:7.6-jdk17 AS build
WORKDIR /app

# Copy toàn bộ project vào container
COPY . .

# Build project và tạo file jar
RUN gradle bootJar

# Bước 2: Sử dụng image java chính thức để chạy ứng dụng
FROM openjdk:17-jdk-slim

# Tạo thư mục cho ứng dụng
WORKDIR /app

# Copy file jar từ build stage sang image này
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port (ví dụ ứng dụng Spring Boot chạy trên port 8080)
EXPOSE 8080

# Command để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
