# Volumes trong Docker
<details>
  <summary>
  <b>Volumes: </b>
  </summary>
  
  + Volumes trong Docker là một tính năng cho phép bạn lưu trữ và chia sẻ dữ liệu giữa các container hoặc giữa container và máy chủ (host). Nó được sử dụng để duy trì dữ liệu của container ngay cả khi container bị dừng hoặc xóa.
  
  + <b>Các lệnh cơ bản: </b>
      1. Xem danh sách volumes: `docker volume ls`
      2. Xóa volume: `docker volume rm my-volume`
  
  + <b>Tại sao nên dùng volumes? </b>
      1. <b>Persist dữ liệu: </b> Dữ liệu trong container thường sẽ bị mất khi container bị xóa. Volumes giúp lưu trữ dữ liệu một cách lâu dài, ngay cả khi container không còn tồn tại.
      2. <b>Chia sẻ dữ liệu giữa các container: </b> Nhiều container có thể sử dụng chung một volume để chia sẻ dữ liệu. Điều này rất hữu ích khi bạn có các container cần truy cập vào cùng một bộ dữ liệu.
      3. <b>Tách biệt dữ liệu và ứng dụng: </b> Volumes giúp tách biệt dữ liệu khỏi container, giúp việc quản lý và sao lưu dữ liệu trở nên dễ dàng hơn.
      4. <b>Hiệu suất tốt hơn: </b> Volumes được tối ưu hóa cho hiệu suất và thường nhanh hơn so với việc lưu trữ dữ liệu trực tiếp trên hệ thống tập tin của container (bind mounts).

  + <b>Cách sử dụng volumes: </b>
      1. <b>Tạo volume khi chạy container: </b> `docker run -d -p 3000:80 --rm --name feedback-app -v feedback:/app/feedback feedback-node:volumes`
      2. <b>Hoặc: </b> 
            - Tạo volume: `docker volume create my-volume` 
            - Gắn volume vào container:
                - Khi chạy container, bạn có thể gắn volume vào một thư mục trong container bằng tùy chọn -v hoặc --mount.
                - `docker run -d -v my-volume:/path/in/container my-image`
                    + `my-volume`: Tên của volume mà bạn đã tạo.
                    + `/path/in/container`: Đường dẫn trong container nơi volume sẽ được gắn.
                - EX:
                    + Nếu bạn muốn lưu trữ dữ liệu trong thư mục /data của container:
                    + `docker run -d -v my-volume:/data my-image`
            3. Bind mounts:
                 - Ngoài ra, bạn cũng có thể gắn một thư mục từ máy chủ (host) vào container. Đây là dạng bind mounts:
                 - `docker run -d -v /path/on/host:/path/in/container my-image`
                    + `/path/on/host`: Thư mục trên máy chủ mà bạn muốn gắn.
                    + `/path/in/container`: Thư mục tương ứng trong container.
            4. So sánh giữa volumes và bind mounts:
                 ![Example Image](./image-for-notes/volume_&_bindmounts.png)
            5. Ví dụ cụ thể:
               - Giả sử bạn có một ứng dụng web lưu trữ dữ liệu vào thư mục /data bên trong container và bạn muốn dữ liệu được lưu trữ bền vững trên máy chủ của bạn. Bạn có thể sử dụng volume như sau:
                    + `docker run -d -v my-volume:/data my-web-app`
               - Nếu bạn muốn sử dụng một thư mục cụ thể trên máy chủ (ví dụ /home/user/data), bạn có thể sử dụng bind mount:
                    + `docker run -d -v /home/user/data:/data my-web-app`

## Lưu ý:
  - Anonymous Volume sẽ bị xóa khi container shutdown
  - Volume được đặt tên sẽ không tự động xóa khi container shutdown
        + EX: `docker run -d -p 3000:80 --rm --name feedback-app -v feedback:/app/feedback feedback-node:volumes`  
</details>

# Bind mounts
<details>
  <summary>
  <b>Cách để bind mounts 1 container và volumes: </b>
  </summary>

  * EX: `docker run -d -p 3000:80 --rm --name feedback-app -v feedback:/app/feedback -v "C:\Users\PC\Desktop\Learning Docker\My-Learning-Docker\03 - Managing Data & Working with Volumes\data-volumes-02-added-dockerfile:/app" -v /app/node_modules feedback-node:volumes`
  * Giải thích:
      - `-v feedback:/app/feedback`
          + Cờ -v được sử dụng để mount (gắn) một volume. Volume là một cách để lưu trữ dữ liệu ngoài container, giúp dữ liệu không bị mất khi container bị xóa. Ở đây:
            - `feedback`: là tên volume.
            - `/app/feedback`: là thư mục trong container nơi volume được gắn vào.
      - `-v "C:\Users\PC\Desktop\Learning Docker\My-Learning-Docker\03 - Managing Data & Working with Volumes\data-volumes-02-added-dockerfile:/app"`
          + Đây là một volume khác, nhưng thay vì sử dụng volume của Docker, nó gắn thư mục trên máy tính host vào container. Cụ thể:
            - `"C:\Users\PC\Desktop\Learning Docker\My-Learning-Docker\03 - Managing Data & Working with Volumes\data-volumes-02-added-dockerfile"`: là thư mục trên máy tính của bạn (Windows).
            - `/app`: là thư mục trong container.
          + Điều này có nghĩa là mọi thay đổi trong thư mục trên máy tính host sẽ tự động được phản ánh trong container tại thư mục `/app`, và ngược lại.
      - `-v /app/node_modules`
          + Tham số này mount một volume ẩn, điều này có nghĩa là Docker sẽ không ghi đè thư mục node_modules bên trong container bằng thư mục tương ứng từ máy host. Thư mục này sẽ được quản lý độc lập bên trong container, giúp tránh vấn đề về sự khác biệt môi trường giữa hệ thống host và container.
</details>

# Volume Comparison
   ![Example Image](./image-for-notes/Volumes_comparision.png)
  
