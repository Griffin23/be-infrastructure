- 进入docker目录，执行`sh mk-docker-image.sh`，生成docker镜像
- 宿主机执行`docker run -d -p 5520:5520 --name be-inf-container be-inf:1.0.0`，用镜像创建容器
- 若需将日志文件映射到宿主机（本质是将宿主机的卷挂载到docker容器），在docker run时添加-v：`-v /var/logs/be-inf-log/:/var/logs/be-inf-log/`
- 若出现permission denied，需要在run时添加特权：`--privileged=true`

sudo docker run -d -p 5520:5520 -v /var/logs/be-inf-log/:/var/logs/be-inf-log/ --privileged=true --name be-inf-container be-inf:1.0.0
