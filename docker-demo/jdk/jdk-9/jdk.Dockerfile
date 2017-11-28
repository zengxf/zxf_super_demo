# jdk:9

FROM centos:7.2-tools

MAINTAINER zengxf fl_zxf@sina.cn

WORKDIR /base-data

ADD jdk-9.0.1_linux-x64_bin.tar.gz ./

ENV JAVA_HOME /base-data/jdk-9.0.1
ENV PATH /base-data/jdk-9.0.1/bin:$PATH

CMD /bin/bash