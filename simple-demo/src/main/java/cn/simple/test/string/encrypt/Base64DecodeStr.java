package cn.simple.test.string.encrypt;

import java.io.IOException;
import java.util.Base64;

public class Base64DecodeStr {
    public static void main( String[] args ) throws IOException {
        String str = "1U5529EdanIXcx71UUUUU7vcSsGvfC2KfnxnUU==";
        byte[] arr = Base64.getDecoder()
                .decode( str );
        System.out.println( new String( arr, "UTF-8" ) );
    }
}
