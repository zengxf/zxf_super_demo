package cn.simple.test.string;

import java.util.Arrays;

public class StringSplitTest {
    public static void main( String[] args ) {
	String keyword = "��Ϊ  ���ۡ�  �ܼ�";
	String[] keywords = keyword.split( "\\s+|��+" );
	System.out.println( Arrays.toString( keywords ) );
    }
}
