package cn.simple.test.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LongFormatTime {

    public static void main(String[] args) throws Exception {

	long time = 1470727494000L;
	System.out.printf("%tF %<tT %n", time);

	String str = String.format("%tF %<tT", time);
	System.out.println(str);
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	Date date = fmt.parse(str);
	String str1 = String.format("%tF %<tT", date);
	System.out.println(str1);
    }

}
