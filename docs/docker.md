- 进入docker目录，执行`sh mk-docker-image.sh`，生成docker镜像
- 宿主机执行`docker run -d -p 5520:5520 --name be-inf-container be-inf:1.0.0`，用镜像创建容器