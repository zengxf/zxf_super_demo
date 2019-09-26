package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        StringBuilder sql = new StringBuilder();
        sql.append( "ab" )
                .append( "\n" );
        sql.append( "ab" )
                .append( "\n" );
        System.out.println( sql.length()- "\n".length() );
        System.out.println( sql.lastIndexOf( "\n" ) );
    }

}