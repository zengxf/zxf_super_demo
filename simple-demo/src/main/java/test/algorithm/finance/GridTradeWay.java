package test.algorithm.finance;

/**
 * 网格交易法
 * <p>
 * Created by zengxf on 2020-04-03
 */
public class GridTradeWay {

    public static void main( String[] args ) {
        double start = 200;
        double price = 3;
        double grid = 0.05;
        int period = 20;
        double sum1 = period * start, sum2 = 0;
        for ( int i = 0; i < period; i++ ) {
            double p2 = price * ( 1 - grid * i );
            double p3 = p2 * ( 1 + grid );
            double num = start / p2;
            double beta = num * p3;
            System.out.println( p2 + "\t" + p3 + "\t" + num + "\t" + beta );
            sum2 += beta;
        }
        System.out.println( sum1 );
        System.out.println( sum2 );
        System.out.println( sum2 / sum1 );
    }

}
