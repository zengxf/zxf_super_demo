package cn.simple.test.algorithm.similar;

public class DijstraSF {

    public static void main( String[] args ) {
	int m[] = { 25, 10, 5, 1 };
	int n = 99;
	int[] num = new int[m.length];
	num = zhaoqian( m, n );
	System.out.println( n + "����Ǯ������" );
	for ( int i = 0; i < m.length; i++ )
	    System.out.println( num[i] + "ö" + m[i] + "��ֵ" );
    }

    public static int[] zhaoqian( int m[], int n ) {
	int k = m.length;
	int[] num = new int[k];
	for ( int i = 0; i < k; i++ ) {
	    num[i] = n / m[i];
	    n = n % m[i];
	}
	return num;
    }
}