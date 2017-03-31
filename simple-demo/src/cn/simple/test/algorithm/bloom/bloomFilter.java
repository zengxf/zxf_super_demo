package cn.simple.test.algorithm.bloom;

import java.util.BitSet;
/**
 * ����������������в��롢��ѯ�ȹ��ܣ���������λ���Ĵ�С����Ȼ��ɾ�����ܣ�������ò�Ҫ��
 * @author chouyou
 *
 */
public class bloomFilter {
    private int defaultSize = 5000 << 10000;// <<����λ����
    /**
     * ��basic��ʹ��������hashCode���Ľ�������һ��int���͵����������int���͵����ķ�Χ����0��baisc
     * ����basic�ĵ�ֵΪdefaultsize��һ
     */
    private int basic = defaultSize -1;

    private BitSet bits = new BitSet(defaultSize);//��ʼ��һ��һ����С��λ��
    
    public bloomFilter(){
    }
    /**
     * ���һ��key����8����ͬ��hash����������8����ͬ���������ķ�Χ0��defaultSize-1
     * �����8����Ϊ�±꣬��λ���е���Ӧλ�����ó�1
     * @return
     */
    private int[] indexInSet(element ele){
        int[] indexes = new int[8];
        for (int i = 0;i<8;i++){
        	indexes[i] = hashCode(ele.getKey(),i);
        }
        return indexes;
    }
    /**
     * ���һ��Ԫ�ص�λ����
     */
    private void add(element ele){
        if(exist(ele)){
            System.out.println("�Ѿ�����("+ele.getKey()+")");
            return;
        }
        int keyCode[] = indexInSet(ele);
        for (int i = 0;i<8;i++){
        	bits.set(keyCode[i]);
        }
    }
    /**
     * �ж��Ƿ����
     * @return
     */
    private boolean exist(element ele){
        int keyCode[] = indexInSet(ele);
        if(bits.get(keyCode[0])
        		&&bits.get(keyCode[1])
                &&bits.get(keyCode[2])
                &&bits.get(keyCode[3])
                &&bits.get(keyCode[4])
                &&bits.get(keyCode[5])
                &&bits.get(keyCode[6])
                &&bits.get(keyCode[7])){
            return true; 
        }
        return false;
    }
    /**
     * Ҫ���м���ɾ��ĳ��Ԫ��
     * ��ô��λ���н���Ӧ���±�����Ϊ0����
     * �������������п��ܻ���Ӱ�쵽���Ԫ�أ���Ϊ���Ԫ�ع���һ���±�ѽ
     * ���������ñ��Ԫ��Ҳ��������ô
     * ����֤�������bloom Filter��ȱ�㣬����ɾ��Ԫ�ء�
     * @return
     */
    private boolean deleteElement(element ele){
        if(exist(ele)){
            int keyCode[] = indexInSet(ele);
            for (int i = 0;i<8;i++){
            	bits.clear(keyCode[i]);
            }
            return true;
        }
        return false;
    }
    /**
     * Q���벻ͬ��Q�Ϳ��Եõ��򵥵Ĳ�ͬ��hash����
     */
    private int hashCode(String key,int Q){
        int h = 0;
        int off = 0;
        char val[] = key.toCharArray();
        int len = key.length();
        for (int i = 0; i < len; i++) {
            h = (30 + Q) * h + val[off++];
        }
        return changeInteger(h);
    }
    
    private int changeInteger(int h) {
        return basic & h;//&��λ�������
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	bloomFilter f=new bloomFilter();
        element ele = new element("blog.csdn.net/zy825316");
        System.out.println("λ����С��"+f.defaultSize);
        f.add(ele);
        System.out.println(f.exist(ele));
        f.deleteElement(ele);
        System.out.println(f.exist(ele));
    }
}