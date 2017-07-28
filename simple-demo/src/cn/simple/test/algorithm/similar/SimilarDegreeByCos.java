package cn.simple.test.algorithm.similar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimilarDegreeByCos {

    /**
     * ���������ַ��������ƶȣ��򵥵����Ҽ��㣬δ��Ȩ��
     * 
     * @param str1
     * @param str2
     * @return ���ؼ������ʶ��
     */
    @SuppressWarnings( "rawtypes" )
    public static double getSimilarDegree( String str1, String str2 ) {
	// ���������ռ�ģ�ͣ�ʹ��mapʵ�֣�����Ϊ���ֵΪ����Ϊ2�����飬����Ŷ�Ӧ�������ַ����еĳ��ִ���
	Map<String, int[]> vectorSpace = new HashMap<String, int[]>();
	int[] itemCountArray = null;// Ϊ�˱���Ƶ�������ֲ����������Խ�itemCountArray�����ڴ�

	// �Կո�Ϊ�ָ������ֽ��ַ���
	String strArray[] = str1.split( " " );
	for ( int i = 0; i < strArray.length; ++i ) {
	    if ( vectorSpace.containsKey( strArray[i] ) )
		++( vectorSpace.get( strArray[i] )[0] );
	    else {
		itemCountArray = new int[2];
		itemCountArray[0] = 1;
		itemCountArray[1] = 0;
		vectorSpace.put( strArray[i], itemCountArray );
	    }
	}

	strArray = str2.split( " " );
	for ( int i = 0; i < strArray.length; ++i ) {
	    if ( vectorSpace.containsKey( strArray[i] ) )
		++( vectorSpace.get( strArray[i] )[1] );
	    else {
		itemCountArray = new int[2];
		itemCountArray[0] = 0;
		itemCountArray[1] = 1;
		vectorSpace.put( strArray[i], itemCountArray );
	    }
	}
	// �������ƶ�
	double vector1Modulo = 0.00;// ����1��ģ
	double vector2Modulo = 0.00;// ����2��ģ
	double vectorProduct = 0.00; // ������
	Iterator iter = vectorSpace.entrySet().iterator();
	while ( iter.hasNext() ) {
	    Map.Entry entry = (Map.Entry) iter.next();
	    itemCountArray = (int[]) entry.getValue();

	    vector1Modulo += itemCountArray[0] * itemCountArray[0];
	    vector2Modulo += itemCountArray[1] * itemCountArray[1];

	    vectorProduct += itemCountArray[0] * itemCountArray[1];
	}
	vector1Modulo = Math.sqrt( vector1Modulo );
	vector2Modulo = Math.sqrt( vector2Modulo );

	// �������ƶ�
	return ( vectorProduct / ( vector1Modulo * vector2Modulo ) );
    }

    /**
     * ������
     */
    public static void main( String args[] ) {
	String str1 = "������� ��ë�� �ܲ�";
	String str2 = "����ʳ �ܲ� ���� ���� ������ ���� ��Ӿ";
	String str3 = "90�� ���� ���� ����Ů";
	String str4 = "������� ����Ϸ ������ ��ũ";
	String str5 = "��ë�� �ܲ� �˶�";
	String str6 = "������� �ܲ� ��ë��";

	System.out.println( "str1��str2��ʶ�ȣ�" + SimilarDegreeByCos.getSimilarDegree( str1, str2 ) );
	System.out.println( "str1��str3��ʶ�ȣ�" + SimilarDegreeByCos.getSimilarDegree( str1, str3 ) );
	System.out.println( "str1��str4��ʶ�ȣ�" + SimilarDegreeByCos.getSimilarDegree( str1, str4 ) );
	System.out.println( "str1��str5��ʶ�ȣ�" + SimilarDegreeByCos.getSimilarDegree( str1, str5 ) );
	System.out.println( "str1��str6��ʶ�ȣ�" + SimilarDegreeByCos.getSimilarDegree( str1, str6 ) );
    }

}
