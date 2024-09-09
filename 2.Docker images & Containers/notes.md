# Container 
  * docker run -p localport:machineport image_id : build container
  * docker start contaienr_id/name : run container

# Images
  * docker images : xem các image
  * docker rmi image_id : xóa các image
      - Nếu container đang  sử dụng image đó -> xóa container trước
      - EX: ![Example Image](./image%20for%20note/img-confict-with-container.png)
  * docker prune : xóa toàn bộ image

# Attached & Detached mode
  * When using the “run” command -> attached mode is default
  *	When using the “start” command -> detached mode is default

  * Attached: listening to the out put of that container

  * We can config to start/ run in our mode
     - docker start –a/-d container-id/container-name
     - docker run –a/-d container-id/container-name

  * We can run it in attatch mode with: 
     -	docker attach container-id/container-name

  * Or we can read the log of detached mode with: 
     - 	docker logs container-id/container-name ( we can see what was print )
     -	docker logs –f container-id/container-name ( we can see and listening )


# Xóa 1 Container
  * Không thể xóa 1 container đang chạy -> docker stop container_id/container_name
  * Xóa 1-n: docker rm contgainer_id/container_name contgainer_id/container_name .....
