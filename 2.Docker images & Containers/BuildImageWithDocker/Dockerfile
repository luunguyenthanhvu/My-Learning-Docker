# Sử dụng image Ubuntu cơ bản
FROM ubuntu:latest

# Cài đặt OpenJDK 17 và Gradle
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk wget unzip && \
    wget https://services.gradle.org/distributions/gradle-7.6-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-7.6-bin.zip && \
    ln -s /opt/gradle/gradle-7.6/bin/gradle /usr/bin/gradle && \
    apt-get clean;

# Đặt biến môi trường cho thư mục làm việc bên trong container
ENV APP_HOME=/app

# Tạo thư mục làm việc bên trong container
WORKDIR $APP_HOME

# Sao chép toàn bộ mã nguồn vào thư mục làm việc
COPY . .

# Cài đặt các dependencies và build ứng dụng
RUN gradle build --no-daemon

# Mở cổng 8080 trên container
EXPOSE 8080

# Lệnh để chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "build/libs/BuildImageWithDocker-0.0.1-SNAPSHOT.jar"]
