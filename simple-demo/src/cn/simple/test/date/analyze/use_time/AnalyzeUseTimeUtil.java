package cn.simple.test.date.analyze.use_time;

/**
 * ������ʱ�����࣬��ȷ��--����
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
     * ����
     */
    public static void reset( String newOp ) {
	local.get().op = newOp;
	local.get().millis = System.currentTimeMillis();
	local.get().sum = 0L;
    }

    /**
     * ��ʱ
     */
    public static void timing( String childOp ) {
	long cur = System.currentTimeMillis();
	long useTime = cur - local.get().millis;

	System.out.println( String.format( "[%s]-[%s]��ʱ��[%d]ms", local.get().op, childOp, useTime ) );

	local.get().millis = System.currentTimeMillis();
	local.get().sum += useTime;
    }

    /**
     * �ܼ�ʱ
     */
    public static void summary() {
	System.out.println( String.format( "[%s]����ʱ��[%d]ms", local.get().op, local.get().sum ) );
    }

    private static class UseTimeBO {
	private String op;     // ��ǰ����
	private long   millis; // ��ǰʱ���
	private long   sum;    // ����ʱ
    }

}
