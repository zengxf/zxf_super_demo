package cn.simple.test.algorithm.bloom;

import java.util.BitSet;
/**
 * 就是这个过滤器，有插入、查询等功能，可以设置位集的大小。虽然有删除功能，但是最好不要用
 * @author chouyou
 *
 */
public class bloomFilter {
    private int defaultSize = 5000 << 10000;// <<是移位运算
    /**
     * 从basic的使用来看，hashCode最后的结果会产生一个int类型的数，而这个int类型的数的范围就是0到baisc
     * 所以basic的的值为defaultsize减一
     */
    private int basic = defaultSize -1;

    private BitSet bits = new BitSet(defaultSize);//初始化一个一定大小的位集
    
    public bloomFilter(){
    }
    /**
     * 针对一个key，用8个不同的hash函数，产生8个不同的数，数的范围0到defaultSize-1
     * 以这个8个数为下标，将位集中的相应位置设置成1
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
     * 添加一个元素到位集内
     */
    private void add(element ele){
        if(exist(ele)){
            System.out.println("已经包含("+ele.getKey()+")");
            return;
        }
        int keyCode[] = indexInSet(ele);
        for (int i = 0;i<8;i++){
        	bits.set(keyCode[i]);
        }
    }
    /**
     * 判断是否存在
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
     * 要进行集合删除某个元素
     * 那么在位集中将相应的下标设置为0即可
     * 但是这样岂不是有可能会让影响到别的元素，因为多个元素公用一个下标呀
     * 那样岂不是让别的元素也不存在了么
     * 经查证，这就是bloom Filter的缺点，不能删除元素。
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
     * Q传入不同的Q就可以得到简单的不同的hash函数
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
        return basic & h;//&是位与运算符
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	bloomFilter f=new bloomFilter();
        element ele = new element("blog.csdn.net/zy825316");
        System.out.println("位集大小："+f.defaultSize);
        f.add(ele);
        System.out.println(f.exist(ele));
        f.deleteElement(ele);
        System.out.println(f.exist(ele));
    }
}