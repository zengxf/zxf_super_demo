package cn.zxf.security_token.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecretUtils {

    private static Key          secretKey;
    private static final String SECRET_KEY_STR = "中-zxf-@-key-19-!",   //
            KIND = "AES/ECB/PKCS5Padding";

    static {
        setKey( SECRET_KEY_STR );
    }

    private static void setKey( String myKey ) {
        try {
            byte[] key = myKey.getBytes( "UTF-8" );
            MessageDigest sha = MessageDigest.getInstance( "SHA-1" );
            key = sha.digest( key );
            key = Arrays.copyOf( key, 32 ); // 16, 24, 32
            secretKey = new SecretKeySpec( key, "AES" );
        } catch ( NoSuchAlgorithmException e ) {
            log.error( "", e );
        } catch ( UnsupportedEncodingException e ) {
            log.error( "", e );
        }
    }

    public static String encrypt( String strToEncrypt ) {
        if ( strToEncrypt == null )
            return "";
        try {
            Cipher cipher = Cipher.getInstance( KIND );
            cipher.init( Cipher.ENCRYPT_MODE, secretKey );
            return Base64.getEncoder()
                    .encodeToString( cipher.doFinal( strToEncrypt.getBytes( "UTF-8" ) ) );
        } catch ( Exception e ) {
            log.error( "Error while encrypting: {}", strToEncrypt, e );
        }
        return "";
    }

    public static String decrypt( String strToDecrypt ) {
        if ( strToDecrypt == null )
            return "";
        try {
            Cipher cipher = Cipher.getInstance( KIND );
            cipher.init( Cipher.DECRYPT_MODE, secretKey );
            byte[] base64 = Base64.getDecoder()
                    .decode( strToDecrypt );
            return new String( cipher.doFinal( base64 ) );
        } catch ( Exception e ) {
            log.error( "Error while decrypting: {}", strToDecrypt, e );
        }
        return "";
    }

}