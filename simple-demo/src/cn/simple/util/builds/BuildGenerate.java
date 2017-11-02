package cn.simple.util.builds;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildGenerate {
    private static final String OBJ_SIGN = "value";

    public static void printBuildByClass( Class<?> clazz ) {
	List<Method> methods = getSetMethods( clazz );

	printPackage( clazz );
	printImport( methods );
	printClassStart( clazz );
	printHead( clazz );
	printSetMethod( clazz, methods );
	printClassEnd();
    }

    private static void printClassEnd() {
	System.out.println();
	System.out.println( "}" );
    }

    private static void printSetMethod( Class<?> clazz, List<Method> methods ) {
	String fmt = "\n" + //
	        "    public #NAME#Builder #METHOD#(#pType# #pName#) {\n" + //
	        "        this.#obj#.#METHOD#(#pName#);\n" + //
	        "        return this;\n" + //
	        "    }";
	methods.forEach( m -> {
	    String mName = m.getName();
	    Class<?> type = m.getParameters()[0].getType();
	    String pType = getSimpleName( type );

	    // 泛型处理
	    Type genericType = m.getGenericParameterTypes()[0];
	    if ( ParameterizedType.class.isAssignableFrom( genericType.getClass() ) ) {
		Type[] genericTypes = ( (ParameterizedType) genericType ).getActualTypeArguments();
		String typeName = Arrays.stream( genericTypes ) //
	                .map( BuildGenerate::getSimpleName ) //
	                .collect( Collectors.joining( ", " ) );
		pType = String.format( "%s<%s>", pType, typeName );
	    }

	    char top1 = Character.toLowerCase( mName.charAt( 3 ) );
	    String pName = top1 + mName.substring( 4 );
	    String method = fmt.replace( "#NAME#", clazz.getSimpleName() ) //
	            .replace( "#METHOD#", mName ) //
	            .replace( "#pType#", pType ) //
	            .replace( "#pName#", pName ) //
	            .replace( "#obj#", OBJ_SIGN ) //
	            ;
	    System.out.println( method );
	} );
    }

    private static String getSimpleName( Type type ) {
	String name = type.getTypeName();
	int dotIndex = name.lastIndexOf( "." );
	if ( dotIndex > -1 ) {
	    name = name.substring( dotIndex + 1 );
	}
	return name;
    }

    private static void printHead( Class<?> clazz ) {
	String fmt = "" + //
	        "    private #NAME# #obj#;\n" + //
	        "\n" + //
	        "    public static #NAME#Builder get() {\n" + //
	        "        #NAME#Builder build = new #NAME#Builder();\n" + //
	        "        build.#obj# = new #NAME#();\n" + //
	        "        return build;\n" + //
	        "    }\n" + //
	        "\n" + //
	        "    public static #NAME#Builder get(#NAME# #obj#) {\n" + //
	        "        #NAME#Builder build = new #NAME#Builder();\n" + //
	        "        build.#obj# = #obj#;\n" + //
	        "        return build;\n" + //
	        "    }\n" + //
	        "\n" + //
	        "    public #NAME# build() {\n" + //
	        "        return this.#obj#;\n" + //
	        "    }";
	String head = fmt.replace( "#NAME#", clazz.getSimpleName() ) //
	        .replace( "#obj#", OBJ_SIGN );
	System.out.println( head );
    }

    private static void printClassStart( Class<?> clazz ) {
	String name = String.format( "public class %sBuilder {%n", clazz.getSimpleName() );
	System.out.println( name );
    }

    private static void printImport( List<Method> methods ) {
	List<String> names = new ArrayList<>();

	methods.stream() //
	        .forEach( m -> {
	            names.add( m.getParameters()[0].getType().getName() );
	            Type genericType = m.getGenericParameterTypes()[0];
	            if ( ParameterizedType.class.isAssignableFrom( genericType.getClass() ) ) {
		        Type[] genericTypes = ( (ParameterizedType) genericType ).getActualTypeArguments();
		        Arrays.asList( genericTypes ).stream() //
	                        .forEach( t -> {
		            names.add( t.getTypeName() );
		        } );
	            }
	        } );

	names.stream() //
	        .distinct() //
	        .filter( name -> name.contains( "." ) && !name.startsWith( "java.lang" ) ) //
	        .sorted() //
	        .forEach( name -> {
	            String im = String.format( "import %s;", name );
	            System.out.println( im );
	        } );

	System.out.println();
    }

    private static void printPackage( Class<?> clazz ) {
	String pck = String.format( "package %s;%n", clazz.getPackage().getName() );
	System.out.println( pck );
    }

    public static List<Method> getSetMethods( Class<?> clazz ) {
	List<Method> list = new ArrayList<>();
	while ( clazz != Object.class ) {
	    Method[] ms = clazz.getDeclaredMethods();
	    List<Method> temp = Arrays.stream( ms ) //
	            .filter( method -> method.getName().startsWith( "set" ) ) //
	            .collect( Collectors.toList() );
	    list.addAll( temp );
	    clazz = clazz.getSuperclass();
	}
	return list;
    }

}
