package cn.simple.util.compare_field;

/**
 * ������������
 * 
 * @author zengxf
 */
public enum ActionDetailType {

    ACTION_UP( "up"), // 'a' -> 'b'
    ACTION_SET( "set"), // null -> 'a'
    ACTION_CLEAR( "clear"), // 'a' -> null
    ;

    public final String code;

    private ActionDetailType( String code ) {
	this.code = code;
    }

}
