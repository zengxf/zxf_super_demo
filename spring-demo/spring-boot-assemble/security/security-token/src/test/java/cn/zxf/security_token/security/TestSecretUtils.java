package cn.zxf.security_token.security;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TestSecretUtils {

    @Test
    public void test() {
        String originalString = "aa";
        String encryptedString = SecretUtils.encrypt( originalString );
        String decryptedString = SecretUtils.decrypt( encryptedString );

        System.out.println( originalString );
        System.out.println( encryptedString );
        System.out.println( decryptedString );

        Assert.assertThat( "加密结果不相等", encryptedString, Matchers.is( "2Prkg9AxIvaa/8Ftc9igvg==" ) );
        Assert.assertThat( "解密结果不相等", decryptedString, Matchers.is( originalString ) );
    }

}
