
package cn.simple.test.temp;

public class TempTest {

    public static void main( String[] args ) {
	String s = " ##item3 <p style=\"text-indent: 2em;\"> 全款支付：候选人入职后于约定的工作日内，甲方在收到乙方增值税专用发票后需向乙方支付全额服务费。 </p> ##"
		+ "\r\n"
		+ "##item4 <p style=\"text-indent: 2em;\"> 分次支付：候选人入职后于约定的工作日内，甲方在收到乙方增值税专用发票后向乙方支付服务费。候选人通过保用期后于约定的工作日内，甲方收到发票后需向乙方支付再支付剩余的服务费。 </p> ##";
	System.out.println( s );
	s = s.replaceAll("##item4 .+##", "")
                .replace("#支付方式#", "分次");
	System.out.println( "-----------------" );
	System.out.println( s );
	
    }

}