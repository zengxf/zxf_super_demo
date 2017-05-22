# centos:7.2-tools


-- 下载
docker pull hub.c.163.com/public/centos:7.2-tools
-- 重命名
docker tag hub.c.163.com/public/centos:7.2-tools centos:7.2-tools
-- 删除原来的
docker rmi hub.c.163.com/public/centos:7.2-tools


-- 启动
docker run -it --rm centos:7.2-tools /bin/bash


-- 改密码
passwd
-- 安装 ssh 客户端
yum -y install openssh-clients
-- 查看版本
cat /etc/redhat-release