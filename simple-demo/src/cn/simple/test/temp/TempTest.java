package cn.simple.test.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        List<String> list = new ArrayList<>();
        Map<String, Long> map = list.stream()
                .collect( Collectors.groupingBy( a -> a, Collectors.counting() ) );
    }

}