# jdk:8-131

FROM centos:7.2-tools

MAINTAINER zengxf fl_zxf@sina.cn

WORKDIR /base-data

ADD server-jre-8u131-linux-x64.tar.gz ./

ENV JAVA_HOME /base-data/jdk1.8.0_131
ENV PATH /base-data/jdk1.8.0_131/bin:$PATH

CMD /bin/bash