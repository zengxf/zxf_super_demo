
package cn.simple.test.temp;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TempTest {

    public static void main( String[] args ) throws IOException {
        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,false);
        map.put( "apple", "苹果" );
        map.put( "watermelon", "西瓜" );
        map.put( "banana", "香蕉" );
        map.put( "peach", "桃子" );

        map.get("banana");
        map.get("apple");
        
        Iterator iter = map.entrySet().iterator();
        while ( iter.hasNext() ) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println( entry.getKey() + "=" + entry.getValue() );
        }
    }

}