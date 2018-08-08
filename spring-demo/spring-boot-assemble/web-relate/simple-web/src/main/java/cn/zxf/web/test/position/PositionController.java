package cn.zxf.web.test.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/positions" )
public class PositionController {

    @Autowired
    private PositionService ser;

    @GetMapping( "/get-one" )
    public Position getPosition() {
        System.out.println( "-- PositionController: " + this );
        return ser.getPosition();
    }

}