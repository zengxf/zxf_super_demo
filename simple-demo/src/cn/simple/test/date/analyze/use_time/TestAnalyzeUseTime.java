package cn.simple.test.date.analyze.use_time;

public class TestAnalyzeUseTime {

    public static void main( String[] args ) throws InterruptedException {

	for ( int i = 0; i < 2; i++ ) {

	    final int j = i;

	    new Thread() {
		public void run() {
		    AnalyzeUseTimeUtil.reset( "test-" + j );
		    System.out.println( "process1 .. 500ms" );
		    try {
			Thread.sleep( 500L );

			AnalyzeUseTimeUtil.timing( "lv1" );
			System.out.println( "process2 .. 500ms" );
			Thread.sleep( 500L );
			AnalyzeUseTimeUtil.timing( "lv2" );
			System.out.println( "process3 .. 500ms" );
			Thread.sleep( 500L );
			AnalyzeUseTimeUtil.timing( "lv3" );

			AnalyzeUseTimeUtil.summary();
		    } catch ( InterruptedException e ) {
			e.printStackTrace();
		    }
		}
	    }.start();

	}

	AnalyzeUseTimeUtil.reset( "test-" );
	System.out.println( "process1 .. 500ms" );
	try {
	    Thread.sleep( 500L );

	    AnalyzeUseTimeUtil.timing( "lv1" );
	    System.out.println( "process2 .. 500ms" );
	    Thread.sleep( 500L );
	    AnalyzeUseTimeUtil.timing( "lv2" );
	    System.out.println( "process3 .. 500ms" );
	    Thread.sleep( 500L );
	    AnalyzeUseTimeUtil.timing( "lv3" );

	    AnalyzeUseTimeUtil.summary();
	} catch ( InterruptedException e ) {
	    e.printStackTrace();
	}
    }

}
