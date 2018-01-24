package cn.zxf.mock.common.mock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.assertj.core.util.Arrays;

/**
 * 模拟生成对象的操作类
 * 
 * <p>
 * Created by zengxf on 2018-01-24
 */
class MockOperation< T > {

    private Class<T> clazz;
    private int      collectionSize = 1;

    /** 设置模拟的对象类型 */
    public static < MT > MockOperation<MT> of( Class<MT> clazz ) {
        MockOperation<MT> mo = new MockOperation<>();
        mo.clazz = clazz;
        return mo;
    }

    /** 设置集合类型模拟生成的元素个数 */
    public MockOperation<T> collectionSize( int collectionSize ) {
        this.collectionSize = collectionSize;
        return this;
    }

    /** 创建模拟对象 */
    public T newInstance() {
        return this.newInstance( this.clazz );
    }

    // ---------- private ----------

    private < FT > FT newInstance( Class<FT> clazz ) {
        try {
            FT obj = clazz.newInstance();
            Field[] fields = FieldUtils.getAllFields( clazz );
            Stream.of( fields ).forEach( objField -> fillField( objField, obj ) );
            return obj;
        } catch ( InstantiationException | IllegalAccessException e ) {
            throw new RuntimeException( "mock 反射创建实例出错！", e );
        }
    }

    private static interface FillField {
        void fill( Field field, Object target );
    }

    private Random                         random   = new Random();
    private final Map<Class<?>, FillField> FILL_MAP = new HashMap<>();

    {
        FILL_MAP.put( byte.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10 ) ) );
        FILL_MAP.put( short.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 100 ) ) );
        FILL_MAP.put( int.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 1000 ) ) );
        FILL_MAP.put( long.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( float.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( double.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( boolean.class, ( f, t ) -> writeCommonField( f, t, random.nextBoolean() ) );

        FILL_MAP.put( Byte.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10 ) ) );
        FILL_MAP.put( Short.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 100 ) ) );
        FILL_MAP.put( Integer.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 1000 ) ) );
        FILL_MAP.put( Long.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( Float.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( Double.class, ( f, t ) -> writeCommonField( f, t, random.nextInt( 10000 ) ) );
        FILL_MAP.put( Boolean.class, ( f, t ) -> writeCommonField( f, t, random.nextBoolean() ) );

        FILL_MAP.put( Date.class, ( f, t ) -> writeCommonField( f, t, new Date() ) );
        FILL_MAP.put( BigInteger.class, ( f, t ) -> writeCommonField( f, t, BigInteger.valueOf( random.nextInt( 10000 ) ) ) );
        FILL_MAP.put( BigDecimal.class, ( f, t ) -> writeCommonField( f, t, BigDecimal.valueOf( random.nextInt( 10000 ) ) ) );

        FILL_MAP.put( String.class, ( f, t ) -> writeCommonField( f, t, f.getName() + "-" + ( random.nextInt( 10 ) ) ) );

        FILL_MAP.put( Set.class, ( f, t ) -> writeSetField( f, t ) );
        FILL_MAP.put( List.class, ( f, t ) -> writeListField( f, t ) );
        FILL_MAP.put( Map.class, ( f, t ) -> writeMapField( f, t ) );
    }

    private void writeCommonField( Field field, Object target, Object value ) {
        try {
            int modifiers = field.getModifiers();
            if ( Modifier.isStatic( modifiers ) || Modifier.isFinal( modifiers ) )
                return;
            FieldUtils.writeField( field, target, value, true );
        } catch ( IllegalAccessException e ) {
            throw new RuntimeException( "mock 填充字段出错！", e );
        }
    }

    private void writeSetField( Field field, Object target ) {
        try {
            Set<Object> set = new HashSet<>();
            ParameterizedType gType = (ParameterizedType) field.getGenericType();
            Type[] types = gType.getActualTypeArguments();
            if ( !Arrays.isNullOrEmpty( types ) ) {
                Class<?> eleClass = (Class<?>) types[0];
                IntStream.range( 0, this.collectionSize ).forEach( i -> {
                    set.add( newInstance( eleClass ) );
                } );
            }
            FieldUtils.writeField( field, target, set, true );
        } catch ( IllegalAccessException e ) {
            throw new RuntimeException( "mock 填充 set 字段出错！", e );
        }
    }

    private void writeListField( Field field, Object target ) {
        try {
            List<Object> list = new ArrayList<>();
            ParameterizedType gType = (ParameterizedType) field.getGenericType();
            Type[] types = gType.getActualTypeArguments();
            if ( !Arrays.isNullOrEmpty( types ) ) {
                Type type = types[0];
                if ( type instanceof Class ) {
                    Class<?> eleClass = (Class<?>) type;
                    IntStream.range( 0, this.collectionSize ).forEach( i -> {
                        list.add( newInstance( eleClass ) );
                    } );
                }
            }
            FieldUtils.writeField( field, target, list, true );
        } catch ( IllegalAccessException e ) {
            throw new RuntimeException( "mock 填充 list 字段出错！", e );
        }
    }

    private void writeMapField( Field field, Object target ) {
        try {
            Map<?, ?> map = new HashMap<>();
            FieldUtils.writeField( field, target, map, true );
        } catch ( IllegalAccessException e ) {
            throw new RuntimeException( "mock 填充 map 字段出错！", e );
        }
    }

    private FillField defFillField = ( field, target ) -> {
        Object obj = newInstance( field.getType() );
        writeCommonField( field, target, obj );
    };

    private void fillField( Field field, Object target ) {
        FILL_MAP.getOrDefault( field.getType(), defFillField ) //
                .fill( field, target );
    }

}
