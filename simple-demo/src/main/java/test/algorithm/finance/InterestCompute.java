package test.algorithm.finance;

public class InterestCompute {

    public static void main( String[] args ) {
//         double rate = 1.035;
        double rate = 1.10;
        double sum = 0;
        int year = 500 * 12;
        // int year = 53 * 80;
        int yNum = 1;
        int ydNum = 20;

        System.out.printf( "每年定投：【%d】，预计利息：【%.2f%%】%n", year, ( rate - 1.0d ) * 100d );

        for ( int i = 1; i <= yNum; i++ ) {
            double li = sum * rate;
            sum = li + year;
            System.out.printf( "第 %02d 年：【本利：%.2f，总：%.2f】%n", i, li, sum );
        }
        System.out.printf( "%d 年后总：【%.2f】%n", yNum, sum );

        for ( int i = yNum + 1; i <= ydNum; i++ ) {
            sum = sum * rate;
            System.out.printf( "第 %02d 年：【本利：%.2f】%n", i, sum );
        }
        System.out.printf( "%d 年后总：【%.2f】%n", ydNum, sum );

        int cost = yNum * year;
        System.out.printf( "%d 年期内，成本总：【%d】收益总：【%.2f】%n", ydNum, cost, sum - cost );
    }

}
