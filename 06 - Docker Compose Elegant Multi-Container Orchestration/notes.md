# Docker Compose Notes

## Docker Compose là gì?

Docker Compose là một công cụ giúp định nghĩa và quản lý các ứng dụng đa container. Với Docker Compose, bạn có thể định cấu hình các container trong một tệp duy nhất (`docker-compose.yml`) và quản lý chúng bằng các lệnh đơn giản.

### Lợi ích của Docker Compose:
- Đơn giản hóa việc quản lý nhiều container.
- Dễ dàng tái tạo môi trường phát triển hoặc sản xuất.
- Cho phép khởi động tất cả các dịch vụ với một lệnh duy nhất.
- Quản lý mạng, volumes, và các biến môi trường dễ dàng.

---

## Cấu trúc tệp `docker-compose.yml`

Tệp `docker-compose.yml` chứa cấu hình cho các dịch vụ (container) mà bạn muốn khởi chạy. Ví dụ:

```yaml
version: '3'
services:
  web:
    image: nginx
    ports:
      - "80:80"
  database:
    image: postgres
    environment:
      POSTGRES_PASSWORD: examplepassword

Các lệnh Docker Compose cơ bản
1. Khởi động các dịch vụ (container)
Khởi động tất cả các dịch vụ được định nghĩa trong docker-compose.yml:

bash
Sao chép mã
docker-compose up
Chạy ở chế độ nền (background):

bash
Sao chép mã
docker-compose up -d
2. Dừng tất cả các dịch vụ
Dừng và xóa các container, mạng, và volumes được tạo ra bởi Docker Compose:

bash
Sao chép mã
docker-compose down
3. Xem logs của container
Xem log của tất cả các container:

bash
Sao chép mã
docker-compose logs
Xem log của một dịch vụ cụ thể:

bash
Sao chép mã
docker-compose logs <service-name>
4. Liệt kê các container đang chạy
Để xem danh sách các container được khởi động từ Docker Compose:

bash
Sao chép mã
docker-compose ps
5. Xây dựng lại hình ảnh Docker
Nếu bạn thay đổi tệp Dockerfile hoặc muốn rebuild các container:

bash
Sao chép mã
docker-compose build
Hoặc vừa build vừa khởi động lại dịch vụ:

bash
Sao chép mã
docker-compose up --build
6. Tạm dừng và tiếp tục container
Dừng tạm thời các dịch vụ:

bash
Sao chép mã
docker-compose stop
Khởi động lại các dịch vụ đã tạm dừng:

bash
Sao chép mã
docker-compose start
7. Chạy một lệnh trong container
Chạy một lệnh cụ thể trong một container:

bash
Sao chép mã
docker-compose run <service-name> <command>
Ví dụ: Chạy lệnh sh trong dịch vụ web:

bash
Sao chép mã
docker-compose run web sh

