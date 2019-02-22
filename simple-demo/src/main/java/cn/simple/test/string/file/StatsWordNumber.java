package cn.simple.test.string.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 统计英文单词数
 * <p>
 * Created by zengxf on 2019-02-22
 */
// M:\project\zxf_super_demo\simple-demo\bin
// java -Ddebug=true cn.simple.test.string.file.StatsWordNumber
public class StatsWordNumber {

    public static void main( String[] args ) throws IOException {
        String path = System.getProperty( "path", "C:\\Users\\Administrator\\Desktop\\en.txt" );
        boolean debug = Boolean.getBoolean( "debug" );

        File file = new File( path );
        if ( !file.exists() ) {
            System.out.println( "文件不存在！path: " + path );
            return;
        }
        BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( path ) ) );

        int sum = 0;
        Set<String> set = new HashSet<>();

        String line;
        while ( ( line = br.readLine() ) != null ) {
            line = line.trim();
            if ( line.isEmpty() )
                continue;
            String[] arr = line.split( "[^a-zA-Z\\-]+" );
            sum += arr.length;
            Stream.of( arr )
                    .forEach( set::add );
        }

        br.close();

        System.out.println( "\n总数：" + sum );
        System.out.println( "去重后总数：" + set.size() );
        if ( debug ) {
            String[] arr = set.toArray( new String[] {} );
            for ( int i = 0; i < arr.length; i++ ) {
                if ( i % 10 == 0 )
                    System.out.println();
                System.out.print( arr[i] + ", " );
            }
        }
        System.out.println( "\r\n" );
    }

}
