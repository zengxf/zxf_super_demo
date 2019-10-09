package cn.simple.test.jdkapi.net;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TestHttpClient {

    public static void main( String[] args ) throws IOException, InterruptedException {
        SslSetup.notVerfiy();

        // String url = "http://openjdk.java.net/"; // 合法证书测试
        String url = "https://591234x.com/788789/31139.html"; // 未知证书测试

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout( Duration.ofMillis( 3000 ) )
                .followRedirects( HttpClient.Redirect.ALWAYS )
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri( URI.create( url ) )
                .timeout( Duration.ofMillis( 5000 ) )
                .build();
        HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString() );
        
        System.out.println( response.body() );
    }

}
