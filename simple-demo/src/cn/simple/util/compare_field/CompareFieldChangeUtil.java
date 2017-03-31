package cn.simple.util.compare_field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * �Ƚ϶�����ֶθ������
 * 
 * @author zengxf
 */
public class CompareFieldChangeUtil {

    private static final String ORIGIN_TYPES = ",byte,short,int,long,float,double,boolean,char,";

    /**
     * �Ƚ���������ֶθ������ <br>
     * ע����ûʵ���ݹ鸸���ֶεıȽ�
     * 
     * @param oldObj
     * @param newObj
     * @return
     */
    public static List<CompareDifferentPiece> compare( Object oldObj, Object newObj ) {
	if ( oldObj == null || newObj == null )
	    return Collections.emptyList();

	if ( oldObj.getClass() != newObj.getClass() )
	    throw new RuntimeException( "����������ͱ���һ��" );

	return new Compare( oldObj, newObj ).compare();
    }

    @Data
    @AllArgsConstructor
    private static class Compare {

	private final List<CompareDifferentPiece> list = new ArrayList<>();

	private Object				  oldObj;
	private Object				  newObj;

	private List<CompareDifferentPiece> compare() {
	    Field[] fields = oldObj.getClass().getDeclaredFields();
	    Arrays.stream( fields ) //
	            .forEach( field -> {
		        compareField( oldObj, newObj, field );
	            } );
	    return this.list;
	}

	private void compareField( Object oldObj, Object newObj, Field field ) {
	    compareField( oldObj, newObj, field, "" );
	}

	private void compareField( Object oldObj, Object newObj, Field field, String superFieldName ) {
	    boolean sign = field.isAccessible();
	    field.setAccessible( true );

	    Class<?> fieldType = field.getType();
	    String fieldName = field.getName();
	    boolean simple = isSimpleType( fieldType );

	    try {
		Object oldV = field.get( oldObj );
		Object newV = field.get( newObj );
		if ( ( oldV == null && newV != null ) || ( oldV != null && !oldV.equals( newV ) ) ) {
		    ActionDetailType type = ActionDetailType.ACTION_UP;
		    if ( oldV == null )
			type = ActionDetailType.ACTION_SET;
		    if ( newV == null )
			type = ActionDetailType.ACTION_CLEAR;
		    if ( oldV == null || newV == null || simple ) {
			String recordField = "".equals( superFieldName ) ? fieldName : superFieldName + "." + fieldName;
			CompareDifferentPiece piece = new CompareDifferentPiece( recordField, newV, type.code );
			this.list.add( piece );
		    } else {
			Field[] fields = fieldType.getDeclaredFields();
			Arrays.stream( fields ) //
			        .forEach( childField -> {
			            compareField( oldV, newV, childField, fieldName );
			        } );
		    }
		}
	    } catch ( Exception e ) {
		e.printStackTrace(); // TODO log error
	    }

	    field.setAccessible( sign );
	}

	private static boolean isSimpleType( Class<?> fieldType ) {
	    String typeName = fieldType.getName();
	    if ( typeName.startsWith( "java." ) // JDK ����� java ��
	            || typeName.startsWith( "[" ) // ����������
	    ) {
		return true;
	    }
	    return ORIGIN_TYPES.contains( typeName );
	}

    }

}