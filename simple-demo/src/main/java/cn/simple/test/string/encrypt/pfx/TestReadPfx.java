package cn.simple.test.string.encrypt.pfx;

public class TestReadPfx {
    public static void main( String[] args ) {
	String pwd = "123456";
//	String path = TestReadPfx.class.getResource( "" ).getPath() + "admin-ad889cc33.pfx";
	String path = TestReadPfx.class.getResource( "" ).getPath() + "sss.p7b";
	new ReadPFX().GetPvkformPfx( path, pwd );
    }
}
