
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        String fileName = String.format("用户列表 %tF", System.currentTimeMillis());
        System.out.println( fileName );
    }

    static String key( Object... arr ) {
        return Stream.of( arr ).map( Object::toString ).collect( Collectors.joining( ":", "funnel:", "" ) );
    }

}