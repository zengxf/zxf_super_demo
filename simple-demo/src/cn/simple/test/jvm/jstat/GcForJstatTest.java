package cn.simple.test.jvm.jstat;

import cn.simple.test.jvm.gc.cms.TestCmsSequent;

/**
 * ����
 * 
 * <pre>
 * �鿴 gc ԭ��
 * jstat -gccause pid 1s
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-10-16
 * 
 * @see TestCmsSequent
 */
public class GcForJstatTest {

    public static void main( String[] args ) throws Exception {
        TestCmsSequent.main( args );
    }

}
