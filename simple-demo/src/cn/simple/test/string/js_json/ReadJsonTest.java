package cn.simple.test.string.js_json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ReadJsonTest {

    public static void main( String[] args ) throws IOException {

        // testToJson();

        testParseString();

    }

    public static void testParseString() throws IOException {
        // String path = ReadJsonTest.class.getResource( "" ).getPath() + "t1.json";
        String path = ReadJsonTest.class.getResource( "" ).getPath() + "big_obj.json";
        String text = ReadText.readTxt( path, "UTF8" );
        System.out.println( text );

        Object obj = JSON.parse( text );
        JSONObject map = (JSONObject) obj;
        for ( String key : map.keySet() ) {
            JSONArray arr = map.getJSONArray( key );
            System.out.println( key + "  " + arr.get( 0 ) );
        }
    }

    public static void testToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put( "ddd", 22 );
        map.put( "ccc", "aaddd" );
        String json = JSON.toJSONString( map );
        System.out.println( json );
    }

}
