
package cn.simple.test.temp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException, ParseException {
        String input = "{%var1%, %var2%, %var3%} {%var4%, %var5%, %var6%}";
        final String re = "(^[^{]*\\{|\\G(?!^),\\h*)%([^%]+)%";
        // now use above regex in replaceAll method
        System.out.println( input );
        String repl = input.replaceAll( re, "$1#$2#" );
        System.out.println( repl );

        System.out.println( "abcabc".replaceAll( "(a)b(c)", "$1#$2" ) );
        System.out.println( "a\u3000b" );
    }

}