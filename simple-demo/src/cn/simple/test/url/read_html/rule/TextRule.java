package cn.simple.test.url.read_html.rule;

public class TextRule {

    public final String cssQuery; // ����Ч�ʣ�������ȫд��Ψһ��
    public final int index;

    /**
     * <pre>
     * this.index = 0;
     * </pre>
     * 
     * @param cssQuery
     */
    public TextRule(String cssQuery) {
	super();
	this.index = 0;
	this.cssQuery = cssQuery;
    }

    public TextRule(String cssQuery, int index) {
	super();
	this.cssQuery = cssQuery;
	this.index = index;
    }

}
