
// xcopy M:\Docker\Dockerfiles\jdk\jdk-9.0.1_linux-x64_bin.tar.gz
// 同目录放：jdk-9.0.1_linux-x64_bin.tar.gz

docker build -t jdk:9 -f jdk.Dockerfile ./

test:
docker run --rm -it jdk:9 /bin/bash	

open port:
docker run --name jdk-9 -p 2022:22 -it jdk:9 /bin/bash	