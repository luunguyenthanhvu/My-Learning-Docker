# Images
  * docker images : xem các image
  * docker rmi image_id : xóa các image
      - Nếu container đang  sử dụng image đó -> xóa container trước
      - EX: ![Example Image](./image%20for%20note/img-confict-with-container.png)
  * docker prune : xóa toàn bộ image

# Xóa 1 Container
  * Không thể xóa 1 container đang chạy -> docker stop container_id/container_name
  * Xóa 1-n: docker rm contgainer_id/container_name contgainer_id/container_name .....
