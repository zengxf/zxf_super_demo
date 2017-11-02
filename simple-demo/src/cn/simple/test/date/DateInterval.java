package cn.simple.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * {@link Calendar}
 * 
 * @author zengxf
 */
public class DateInterval {

    public static void main(String[] args) {

	Calendar cal = Calendar.getInstance();

	Date now = cal.getTime();

	cal.set(Calendar.YEAR, 2015);
	cal.set(Calendar.MONTH, 11 - 1);
	cal.set(Calendar.DAY_OF_MONTH, 14);
	Date pre = cal.getTime();

	System.out.println(String.format("%tF", now));
	System.out.println(String.format("%tF", pre));

	long interval = now.getTime() - pre.getTime();
	long dayNum = interval / 1000 / 60 / 60 / 24;
	System.out.println("天数：" + dayNum);
	System.out.println("周数：" + dayNum / 7 + "." + dayNum % 7);

    }

}
