
xcopy M:\Docker\Dockerfiles\jdk\server-jre-8u131-linux-x64.tar.gz

docker build -t jdk:131 -f jdk.Dockerfile ./

docker run --rm -it jdk /bin/bash
