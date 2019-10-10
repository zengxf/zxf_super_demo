package cn.simple.test.jdkapi.net;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestHttpClient {

    public static void main( String[] args ) throws Exception {
        // String url = "http://openjdk.java.net/"; // 合法证书测试
        String url = "https://591234x.com/788789/31139.html"; // 未知证书测试

        HttpClient http = SslSetup.httpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri( URI.create( url ) )
                .GET()
                .build();
        HttpResponse<String> response = http.send( request, HttpResponse.BodyHandlers.ofString() );

        log.info( "status: [{}]", response.statusCode() );
        log.info( "body: [{}]", response.body() );
    }

}
