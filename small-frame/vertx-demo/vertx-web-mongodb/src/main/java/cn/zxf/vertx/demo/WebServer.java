package cn.zxf.vertx.demo;

import java.text.MessageFormat;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;

public class WebServer extends AbstractVerticle {

    static int PORT = 9091;

    public static void main( String[] args ) {
        String verticleID = WebServer.class.getName();
        System.out.println( verticleID );

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle( verticleID );
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router( vertx );
        router.route( "/" ).handler( routingContext -> {
            routingContext.response() //
                    .putHeader( "content-type", "text/html" ) //
                    .end( "Hello World!" );
        } );
        router.route( HttpMethod.GET, "/user/:id/:name" ).handler( routingContext -> {
            String id = routingContext.request().getParam( "id" );
            String name = routingContext.pathParam( "name" );
            String age = routingContext.request().getParam( "age" );

            insertDb( id, name, age );

            routingContext.response() //
                    .putHeader( "content-type", "text/html" ) //
                    .end( MessageFormat.format( "user-id: {0}, name: {1}, age: {2}", id, name, age ) );
        } );
        vertx.createHttpServer().requestHandler( router::accept ).listen( PORT );
    }

    void insertDb( String id, String name, String age ) {
        JsonObject config = new JsonObject().put( "connection_string", "mongodb://localhost:27017/test-vertx" );
        JsonObject body = new JsonObject() //
                .put( "id", id ) //
                .put( "name", name ) //
                .put( "age", age );

        MongoClient client = MongoClient.createShared( vertx, config );
        client.insert( "user", body, res -> {
            System.out.println( "succeeded: " + res.succeeded() );
            System.out.println( "_id: " + res.result() );
            if ( res.failed() )
                res.cause().printStackTrace();
        } );
    }

}
