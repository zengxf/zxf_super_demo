package cn.simple.test.temp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException {
        String str = "﻿# s 2019-06 月记";
        Pattern pattern = Pattern.compile( ".*?(\\d{4}\\-\\d{2})" );
        Matcher matcher = pattern.matcher( str );
        if ( matcher.find() ) {
            String month = matcher.group( 1 );
            log.info( "month: {}", month );
        } else {
        }
        System.out.println( "dddd" );
    }

}