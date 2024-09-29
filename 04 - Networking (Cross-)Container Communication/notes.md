# Docker Notes

## Kết nối với database trên host machine
- **Sử dụng `host.docker.internal`:**
  - Khi cần kết nối từ container đến database đang chạy trên máy host (máy cục bộ), bạn có thể sử dụng địa chỉ `host.docker.internal`.
  - **Lưu ý:** Cú pháp này dùng cho Docker trên Mac và Windows. Trên Linux, cần phải thiết lập mạng riêng để thực hiện tương tự.

## Tạo container network
- **Để các container có thể giao tiếp trong cùng một network, thực hiện các bước sau:**
  1. **Tạo network:**
     - Sử dụng lệnh sau để tạo một Docker network:
     ```bash
     docker network create <name>
     ```
  2. **Chạy các container trong network:**
     - Khi khởi động container, bạn có thể chỉ định container nằm trong network đã tạo bằng cờ `--network`:
     ```bash
     docker run --network <name> ...
     ```

## Build Arguments (ARG)
- **Đặt bên trong Dockerfile:**
  ```Dockerfile
  ARG DEFAULT_PORT=80
