package cn.zxf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Deprecated // 找不到 Application 类
public class ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("hello world");
	}

}
