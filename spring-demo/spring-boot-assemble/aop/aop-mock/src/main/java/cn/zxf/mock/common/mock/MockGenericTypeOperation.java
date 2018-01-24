package cn.zxf.mock.common.mock;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.assertj.core.util.Arrays;

import cn.zxf.mock.common.domain.PageAndSortDto;

/**
 * 生成泛型实例的操作类
 * 
 * <p>
 * Created by zengxf on 2018-01-24
 */
public class MockGenericTypeOperation {

    private Type genericType;
    private int  collectionSize = 1;

    /** 设置模拟的泛型类型 */
    public static MockGenericTypeOperation of( Type genericType ) {
        MockGenericTypeOperation gtio = new MockGenericTypeOperation();
        gtio.genericType = genericType;
        return gtio;
    }

    /** 设置集合类型模拟生成的元素个数 */
    public MockGenericTypeOperation collectionSize( int collectionSize ) {
        this.collectionSize = collectionSize;
        return this;
    }

    /** 创建实例 */
    public Object newInstance() {
        if ( genericType instanceof Class ) {
            Class<?> clazz = (Class<?>) genericType;
            return this.newInstance( clazz );
        } else { // 下面是比较暴力的方式
            ParameterizedType pType = (ParameterizedType) genericType;
            Type[] types = pType.getActualTypeArguments();
            Class<?> clazz = (Class<?>) pType.getRawType();
            if ( clazz == PageAndSortDto.class ) {
                return this.createPageAndSortDto( types );
            } else if ( clazz.isAssignableFrom( List.class ) ) {
                return this.createList( types );
            } else {
                throw new RuntimeException( "还不支持此泛型类！class = " + clazz.getName() );
            }
        }
    }

    private List<Object> createList( Type[] types ) {
        if ( !Arrays.isNullOrEmpty( types ) ) {
            Type type = types[0];
            if ( type instanceof Class ) {
                Class<?> eleClass = (Class<?>) type;
                List<Object> list = new ArrayList<>();
                IntStream.range( 0, collectionSize ).forEach( i -> {
                    list.add( this.newInstance( eleClass ) );
                } );
                return list;
            }
        }
        return null;
    }

    @SuppressWarnings( "unchecked" )
    private PageAndSortDto<?> createPageAndSortDto( Type[] types ) {
        PageAndSortDto<Object> dto = MockOperation.of( PageAndSortDto.class ) //
                .collectionSize( collectionSize ) //
                .newInstance();
        List<Object> list = this.createList( types );
        dto.setDataList( list );
        return dto;
    }

    private Object newInstance( Class<?> clazz ) {
        return MockOperation.of( clazz ) //
                .collectionSize( collectionSize ) //
                .newInstance();
    }

}
