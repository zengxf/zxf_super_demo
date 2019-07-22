FROM rabbitmq:3.7.16-management
MAINTAINER zengxf fl_zxf@sina.cn

ADD rabbitmq_delayed_message_exchange-20171201-3.7.x.ez /opt/rabbitmq/plugins

RUN rabbitmq-plugins enable rabbitmq_delayed_message_exchange


# 构建
docker build -t rabbitmq:3.7-my ./

# 运行
docker run -d -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=hunterplus123 \
 --name rabbit \
 --hostname rabbit-test \
 -v /data/software/rabbitmq/data:/var/lib/rabbitmq \
 -p 15600:15672 -p 5600:5672 \
 rabbitmq:3.7-my