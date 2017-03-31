package cn.simple.test.util.builds;

import cn.simple.util.builds.BuildGenerate;

public class TestBuildGenerate extends BuildGenerate {

    public static void main( String[] args ) {
	printBuildByClass( TestUser.class );
	// printBuildByClass( TestPerson.class );
    }

}
