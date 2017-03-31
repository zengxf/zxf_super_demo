package cn.simple.test.md5.des;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class DESEncrypt {

    /** ���ܹ��� */
    private Cipher encryptCipher = null;

    /** ���ܹ��� */
    private Cipher decryptCipher = null;

    public void initialize_encryptKey( String keyValue ) throws Exception {
	Key key = getKey( keyValue.getBytes() );
	encryptCipher = Cipher.getInstance( "DES" );
	encryptCipher.init( Cipher.ENCRYPT_MODE, key );
    }

    public void initalize_dencryptkey( String keyValue ) throws Exception {
	Key key = getKey( keyValue.getBytes() );
	decryptCipher = Cipher.getInstance( "DES" );
	decryptCipher.init( Cipher.DECRYPT_MODE, key );
    }

    /**
     * ��ָ���ַ���������Կ����Կ������ֽ����鳤��Ϊ8λ ����8λʱ���油0������8λֻȡǰ8λ
     * 
     * @param arrBTmp
     *            ���ɸ��ַ������ֽ�����
     * @return ���ɵ���Կ
     * @throws java.lang.Exception
     */
    private Key getKey( byte[] arrBTmp ) throws Exception {
	// ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
	byte[] arrB = new byte[8];

	// ��ԭʼ�ֽ�����ת��Ϊ8λ
	for ( int i = 0; i < arrBTmp.length && i < arrB.length; i++ ) {
	    arrB[i] = arrBTmp[i];
	}
	// ������Կ
	Key key = new javax.crypto.spec.SecretKeySpec( arrB, "DES" );
	return key;
    }

    /**
     * �����ֽ�����
     * 
     * @param arrB
     *            ����ܵ��ֽ�����
     * @return ���ܺ���ֽ�����
     * @throws Exception
     */
    public byte[] encrypt( byte[] arrB ) throws Exception {
	return encryptCipher.doFinal( arrB );
    }

    /**
     * �����ֽ�����
     * 
     * @param arrB
     *            ����ܵ��ֽ�����
     * @return ���ܺ���ֽ�����
     * @throws Exception
     */
    public byte[] decrypt( byte[] arrB ) throws Exception {
	return decryptCipher.doFinal( arrB );
    }

    /**
     * �ļ�file���м��ܲ�����Ŀ���ļ�destFile��
     * 
     * @param file
     *            Ҫ���ܵ��ļ� ��c:/test/srcFile.txt
     * @param destFile
     *            ���ܺ��ŵ��ļ��� ��c:/���ܺ��ļ�.txt
     */
    public void encrypt( String sourceFileName, String diminationFileName ) throws Exception {
	InputStream is = new FileInputStream( sourceFileName );
	OutputStream out = new FileOutputStream( diminationFileName );
	CipherInputStream cis = new CipherInputStream( is, encryptCipher );
	byte[] buffer = new byte[1024];
	int r;
	while ( ( r = cis.read( buffer ) ) > 0 ) {
	    out.write( buffer, 0, r );
	}
	cis.close();
	is.close();
	out.close();
    }

    /**
     * �ļ�����DES�㷨�����ļ�
     * 
     * @param file
     *            �Ѽ��ܵ��ļ� ��c:/���ܺ��ļ�.txt *
     * @param destFile
     *            ���ܺ��ŵ��ļ��� ��c:/ test/���ܺ��ļ�.txt
     */
    public void decrypt( String sourceFileName, String diminationFileName ) throws Exception {
	InputStream is = new FileInputStream( sourceFileName );
	OutputStream out = new FileOutputStream( diminationFileName );
	CipherOutputStream cos = new CipherOutputStream( out, decryptCipher );
	byte[] buffer = new byte[1024];
	int r;
	while ( ( r = is.read( buffer ) ) >= 0 ) {
	    cos.write( buffer, 0, r );
	}
	cos.close();
	out.close();
	is.close();
    }

}
