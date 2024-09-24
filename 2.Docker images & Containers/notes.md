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

   

