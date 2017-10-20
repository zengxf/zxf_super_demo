
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        User user = new User();
        user.b = 0;
        System.out.println( Optional.ofNullable( user ).map( User::getB ).orElse( (byte) 0 ).equals( (byte) 0 ) );
    }

    @Getter
    static class User {
        Byte b;
    }

}