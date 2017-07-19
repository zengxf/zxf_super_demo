# 纯 spring boot 基本测试

retry view => http://127.0.0.1:8088/my/retry/test1

经验：
	随机端口：server.port=0
	随机端口范围：server.port=${random.int[10000,19999]}