package cn.simple.util.codec;

import java.security.MessageDigest;

/**
 * MD5 ���ܰ�����
 * 
 * @author zxf
 */
public class Md5Util {

    // ���� MD5 ���ܵ��ַ�
    private static final char MD5_DIGITS_LOWER[] = //
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * ���� 32 λ����Сд�ַ�
     * 
     * @param v
     * @return
     */
    public static String crypt( String v ) {
	try {
	    // ʹ��ƽ̨��Ĭ���ַ������� String ����Ϊ byte���У���������洢��һ���µ� byte������
	    byte[] btInput = v.getBytes();

	    // ��ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�������̶����ȵĹ�ϣֵ��
	    MessageDigest mdInst = MessageDigest.getInstance( "MD5" );

	    // MessageDigest����ͨ��ʹ�� update�����������ݣ� ʹ��ָ����byte�������ժҪ
	    mdInst.update( btInput );

	    // ժҪ����֮��ͨ������digest����ִ�й�ϣ���㣬�������
	    byte[] md = mdInst.digest();

	    // ������ת����ʮ�����Ƶ��ַ�����ʽ
	    int j = md.length;
	    char str[] = new char[j * 2];
	    int k = 0;
	    for ( int i = 0; i < j; i++ ) { // i = 0
		byte byte0 = md[i]; // 95
		str[k++] = MD5_DIGITS_LOWER[byte0 >>> 4 & 0xf]; // 5
		str[k++] = MD5_DIGITS_LOWER[byte0 & 0xf]; // F
	    }

	    // ���ؾ������ܺ���ַ���
	    return new String( str );
	} catch ( Exception e ) {
	    return null;
	}
    }

    /**
     * ���� 16 λ����Сд�ַ�
     * 
     * @param v
     * @return
     */
    public static String crypt16( String v ) {
	String encode = crypt( v );
	return encode == null ? null : encode.substring( 8, 24 );
    }

}
