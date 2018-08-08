package cn.zxf.web.test.position;

import org.springframework.stereotype.Component;

@Component
public class PositionService {

    public Position getPosition() {
        System.out.println( "-- PositionService: " + this );
        return Position.builder()
                .id( 11L )
                .name( "zxf" )
                .build();
    }

}
