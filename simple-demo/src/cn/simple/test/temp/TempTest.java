
package cn.simple.test.temp;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
        List<Point> list = new ArrayList<>();
        list.add( Point.of( "a", 10, 10, true ) );
        list.add( Point.of( "b", 20, 20, true ) );
        list.add( Point.of( "c", 20, 20, true ) );
        list.add( Point.of( "d", 30, 30, false ) );
        list.add( Point.of( "e", 50, 50, true ) );
        list.add( Point.of( "f", 50, 50, false ) );

    }

    @Data
    @Builder
    static class Point {
        String  name;
        int     x;
        int     y;
        boolean sign;

        static Point of( String name, int x, int y, boolean sign ) {
            return Point.builder()
                    .name( name )
                    .x( x )
                    .y( y )
                    .sign( sign )
                    .build();
        }
    }

}