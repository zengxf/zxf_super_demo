
// xcopy M:\Docker\Dockerfiles\jdk\server-jre-8u131-linux-x64.tar.gz
// 同目录放：server-jre-8u131-linux-x64.tar.gz

docker build -t jdk:8-131 -f jdk.Dockerfile ./

docker run --rm -it jdk:8-131 /bin/bash

docker run --rm -it  -p 2022:22 -p 9911:9911/udp jdk:8 /bin/bash
scp -P 2022 BioUdpServer.class root@10.1.1.2:/base-data/bin/cn/simple/test/socket/bio/udp