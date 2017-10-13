package cn.simple.test.new_features.jdk18.interface_def;

public interface IUser {

    default void print() {
	System.out.println( "fuck" );
    }

    void setName( String name );

    default void say() {
	System.out.println( "say 23" );
    }

}
