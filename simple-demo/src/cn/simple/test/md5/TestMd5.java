package cn.simple.test.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

public class TestMd5 {

    public static void main(String[] args) throws IOException {
	long start = System.currentTimeMillis();
	for (int i = 0; i < 2; i++) {
	    System.out.println(DigestUtils.md5Hex(new FileInputStream(new File("SimpleDemo.zip"))));
	    System.out.println(MyFileMd5.fileMd5("SimpleDemo.zip"));
	}
	System.out.println(System.currentTimeMillis() - start);

    }

}
