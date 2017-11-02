package cn.simple.util.compare_field;

/**
 * 比较的具体结果片段
 * 
 * @author zengxf
 */
public class CompareDifferentPiece {

    private String field;     // 字段名
    private Object newValue;  // 新值
    /**
     * 操作类型
     * 
     * @see ActionDetailType
     */
    private String actionType;

    public CompareDifferentPiece() {
	super();
    }

    public CompareDifferentPiece( String field, Object newValue, String actionType ) {
	super();
	this.field = field;
	this.newValue = newValue;
	this.actionType = actionType;
    }

    @Override
    public String toString() {
	return "CompareDifferentPiece [field=" + field + ", newValue=" + newValue + ", actionType=" + actionType + "]";
    }

    public String getField() {
	return field;
    }

    public void setField( String field ) {
	this.field = field;
    }

    public Object getNewValue() {
	return newValue;
    }

    public void setNewValue( Object newValue ) {
	this.newValue = newValue;
    }

    public String getActionType() {
	return actionType;
    }

    public void setActionType( String actionType ) {
	this.actionType = actionType;
    }

}
