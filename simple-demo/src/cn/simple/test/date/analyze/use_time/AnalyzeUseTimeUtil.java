package cn.simple.test.date.analyze.use_time;

/**
 * 分析用时帮助类，精确度--毫秒
 * 
 * @author zengxf
 */
public class AnalyzeUseTimeUtil {

    static ThreadLocal<UseTimeBO> local = new ThreadLocal<UseTimeBO>() {
	public UseTimeBO initialValue() {
	    return new UseTimeBO();
	}
    };

    /**
     * 重置
     */
    public static void reset( String newOp ) {
	local.get().op = newOp;
	local.get().millis = System.currentTimeMillis();
	local.get().sum = 0L;
    }

    /**
     * 计时
     */
    public static void timing( String childOp ) {
	long cur = System.currentTimeMillis();
	long useTime = cur - local.get().millis;

	System.out.println( String.format( "[%s]-[%s]用时：[%d]ms", local.get().op, childOp, useTime ) );

	local.get().millis = System.currentTimeMillis();
	local.get().sum += useTime;
    }

    /**
     * 总计时
     */
    public static void summary() {
	System.out.println( String.format( "[%s]总用时：[%d]ms", local.get().op, local.get().sum ) );
    }

    private static class UseTimeBO {
	private String op;     // 当前操作
	private long   millis; // 当前时间戳
	private long   sum;    // 总用时
    }

}
