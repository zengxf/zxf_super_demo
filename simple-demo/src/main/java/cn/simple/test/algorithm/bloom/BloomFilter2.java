package cn.simple.test.algorithm.bloom;

import java.util.BitSet;

public class BloomFilter2 {

    private static final int    DEFAULT_SIZE = 2 << 24;                // 甯冮殕杩囨护鍣ㄧ殑姣旂壒闀垮害
    private static final int[]  seeds        = { 3, 5, 7, 11, 13, 31, 37, 61 };// 杩欓噷瑕侀�夊彇璐ㄦ暟锛岃兘寰堝ソ鐨勯檷浣庨敊璇巼
    private static BitSet   bits         = new BitSet( DEFAULT_SIZE );
    private static SimpleHash[] func         = new SimpleHash[seeds.length];

    public static void addValue( String value ) {
    for ( SimpleHash f : func ) { // 灏嗗瓧绗︿覆value鍝堝笇涓�8涓垨澶氫釜鏁存暟锛岀劧鍚庡湪杩欎簺鏁存暟鐨刡it涓婂彉涓�1
        int hash = f.hash( value );
        System.out.println( hash );
        bits.set( hash, true );
    }
    }

    public static void add( String value ) {
    if ( value != null )
        addValue( value );
    }

    public static boolean contains( String value ) {
    if ( value == null )
        return false;
    boolean ret = true;
    for ( SimpleHash f : func )// 杩欓噷鍏跺疄娌″繀瑕佸叏閮ㄨ窇瀹岋紝鍙涓�娆et==false閭ｄ箞灏变笉鍖呭惈杩欎釜瀛楃涓�
        ret = ret && bits.get( f.hash( value ) );
    return ret;
    }

    public static void main( String[] args ) {
    String value = "xkeyideal@gmail.com";
    for ( int i = 0; i < seeds.length; i++ ) {
        func[i] = new SimpleHash( DEFAULT_SIZE, seeds[i] );
    }
    add( value );
    System.out.println( contains( value ) );
    }
}

class SimpleHash {// 杩欑帺鎰忕浉褰撲簬C++涓殑缁撴瀯浣�

    private int cap;
    private int seed;

    public SimpleHash( int cap, int seed ) {
    this.cap = cap;
    this.seed = seed;
    }

    public int hash( String value ) {// 瀛楃涓插搱甯岋紝閫夊彇濂界殑鍝堝笇鍑芥暟寰堥噸瑕�
    int result = 0;
    int len = value.length();
    for ( int i = 0; i < len; i++ ) {
        result = seed * result + value.charAt( i );
    }
    return ( cap - 1 ) & result;
    }
}