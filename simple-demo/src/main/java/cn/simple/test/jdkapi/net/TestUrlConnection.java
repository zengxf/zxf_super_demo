package cn.simple.test.jdkapi.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TestUrlConnection {

    public static void main( String[] args ) throws Exception {
        // System.setProperty( "javax.net.debug", "all" );
        SslSetup.notVerfiy();

        URL url = new URL( "https://591234x.com/788789/31139.html" );
        HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
        https.setHostnameVerifier( SslSetup.HV );

        BufferedReader br = new BufferedReader( new InputStreamReader( https.getInputStream() ) );
        String line;
        while ( ( line = br.readLine() ) != null ) {
            System.out.println( line );
        }

        // InputStream is = url.openStream();
        // System.out.println( is );
    }

}
