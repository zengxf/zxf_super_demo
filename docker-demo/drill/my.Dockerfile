# hadoop

FROM jdk

MAINTAINER zengxf fl_zxf@sina.cn

WORKDIR /base-data

ADD apache-drill-1.8.0.tar.gz ./

ENV DRILL_HOME /base-data/apache-drill-1.8.0
ENV PATH /base-data/apache-drill-1.8.0/bin:$PATH

CMD /bin/bash