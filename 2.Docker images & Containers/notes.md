# Container & Image trong docker
<details>
  <summary>
  <b>Container: </b>
  </summary>
  
  + <b> Các lệnh cơ bản: </b>
      - `docker run -p localport:machineport image_id` : build container
      - `docker start contaienr_id/name` : run container
  + <b> Xóa 1 Container: </b>
      - Không thể xóa 1 container đang chạy -> docker stop container_id/container_name
      - Xóa 1-n: docker rm contgainer_id/container_name contgainer_id/container_name .....
  + <b> Xóa 1 Container tự động: </b>
      - `docker run -p localport:machineport -d --rm image_id`: Sẽ tự động xóa container này sau khi chạy xong  
      => phù hợp cho việc test
  + <b> Copy 1 file vào container: </b>
      - `docker cp <đường_dẫn_nguồn> <tên_container>:<đường_dẫn_đích_trong_container>`: Sao chép một tệp hoặc thư mục từ máy chủ vào container Docker
      - EX: `docker cp /path/test/file.txt my_container:/path/test/`
    
  + <b> Copy từ Container Ra Máy Chủ: </b>
      - `docker cp <tên_container>:<đường_dẫn_trong_container> <đường_dẫn_đích_trên_máy_chủ>`: Sao chép một tệp hoặc thư mục từ container Docker ra máy chủ 
      - EX: `docker cp my_container:/path/test/file.txt /path/test/`
</details>

<details>
  <summary>
  <b>Images: </b>Các lệnh cơ bản 
  </summary>
  
  * `docker images` : xem các image
  * `docker rmi image_id` : xóa các image
      - Nếu container đang  sử dụng image đó -> xóa container trước
      - EX: ![Example Image](./image%20for%20note/img-confict-with-container.png)
  * `docker image prune` : xóa toàn bộ image
</details>


<details>
  <summary>
  <b>Attached & Detached mode </b>
  </summary>
  
  * When using the “run” command -> attached mode is default
  *	When using the “start” command -> detached mode is default

  * Attached: listening to the out put of that container

  * We can config to start/ run in our mode
     - `docker start –a/-d container-id/container-name`
     - `docker run –a/-d container-id/container-name`

  * We can run it in attatch mode with: 
     -	`docker attach container-id/container-name`

  * Or we can read the log of detached mode with: 
     - `docker logs container-id/container-name` ( we can see what was print )
     -	`docker logs –f container-id/container-name` ( we can see and listening )
</details>

<details>
  <summary>
  <b>Hiển thị thông tin chi tiết về một Docker image </b>
  </summary>
  
   * `docker image inspect <image_name_or_id>` : sử dụng để hiển thị thông tin chi tiết về một Docker image cụ thể.
   * Các thông tin bao gồm như :
      - ID của image
      - Tên và tag của image
      - Các lớp (layers) của image
      - Cấu hình của image (như môi trường, biến, lệnh khởi chạy mặc định, v.v.)
      - Dung lượng của image
      - Thông tin về các thông số build
</details>

<details>
  <summary>
  <b>Naming & Tagging Containers and Images </b>
  </summary>

  1. Naming trong Docker:
        * <b> Tên của Image: </b> Khi tạo một image từ Dockerfile hoặc tải xuống từ Docker Hub, bạn có thể chỉ định tên cho image. Điều này giúp bạn dễ dàng tìm kiếm và sử dụng lại image.
             - Cú pháp: `[repository]/[image_name]`
             - EX: `myrepo/myapp` , trong đó `myrepo` là tên repository (kho lưu trữ), còn `myapp` là tên image.
        * <b> Tên của Container: </b> Khi khởi tạo một container từ image, Docker tự động tạo ra một tên ngẫu nhiên cho container. Tuy nhiên, bạn có thể cung cấp tên cụ thể để dễ quản lý hơn.
             - Cú pháp: `docker run --name [container_name] [image_name]`
             - EX: `docker run --name my-container myrepo/myapp` : tạo một container có tên là my-container.
  2. Tagging trong Docker:
        
        * <b> Tag của Image: </b> Tag là một cách để gắn nhãn phiên bản hoặc biến thể của một image. Ví dụ, nếu bạn có một phiên bản mới của image, bạn có thể gắn tag để xác định đó là phiên bản nào. 
            - Cú pháp: `[image_name]:[tag]`
            - EX: `myrepo/myapp:1.0` hoặc `myrepo/myapp:latest`. `latest` thường được sử dụng cho phiên bản mới nhất của image.
        * <b> Sử dụng tag: </b>
            - Khi build image: `docker build -t [repository]/[image_name]:[tag] . `
            - Ví dụ: `docker build -t myrepo/myapp:1.0 `. để tạo image với tag 1.0.
            - Khi chạy container từ image có tag: `docker run [image_name]:[tag]`
            - Ví dụ: `docker run myrepo/myapp:1.0`.
        
</details>


<details>
  <summary>
  <b>Sharing images & Container</b>
  </summary>

  - `docker push [dockerhub_name]/[image_name]` : Push image -> docker hub     
</details>

<details>
  <summary>
  <b>Pulling & Using Shared Images</b>
  </summary>

  - `docker pull [dockerhub_name]/[image_name]` : Push image -> docker hub     
</details>


