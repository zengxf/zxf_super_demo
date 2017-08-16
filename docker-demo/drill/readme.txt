// 同目录下放：apache-drill-1.8.0.tar.gz

docker build -t drill:alone -f my.Dockerfile ./

docker run --rm -it drill:alone 	# /bin/bash

docker run --name drill1 -p 8047:8047 -p 31010:31010 -p 31011:31011 -p 31012:31012 -it drill:alone 	# /bin/bash
