package test.algorithm.bloom;

import java.util.BitSet;

/**
 * 灏辨槸杩欎釜杩囨护鍣紝鏈夋彃鍏ャ�佹煡璇㈢瓑鍔熻兘锛屽彲浠ヨ缃綅闆嗙殑澶у皬銆傝櫧鐒舵湁鍒犻櫎鍔熻兘锛屼絾鏄渶濂戒笉瑕佺敤
 * 
 * @author chouyou
 *
 */
public class bloomFilter {
    private int    defaultSize = 5000 << 10000;            // <<鏄Щ浣嶈繍绠�
    /**
     * 浠巄asic鐨勪娇鐢ㄦ潵鐪嬶紝hashCode鏈�鍚庣殑缁撴灉浼氫骇鐢熶竴涓猧nt绫诲瀷鐨勬暟锛岃�岃繖涓猧nt绫诲瀷鐨勬暟鐨勮寖鍥村氨鏄�0鍒癰aisc 鎵�浠asic鐨勭殑鍊间负defaultsize鍑忎竴
     */
    private int    basic       = defaultSize - 1;

    private BitSet bits        = new BitSet( defaultSize );// 鍒濆鍖栦竴涓竴瀹氬ぇ灏忕殑浣嶉泦

    public bloomFilter() {
    }

    /**
     * 閽堝涓�涓猭ey锛岀敤8涓笉鍚岀殑hash鍑芥暟锛屼骇鐢�8涓笉鍚岀殑鏁帮紝鏁扮殑鑼冨洿0鍒癲efaultSize-1 浠ヨ繖涓�8涓暟涓轰笅鏍囷紝灏嗕綅闆嗕腑鐨勭浉搴斾綅缃缃垚1
     * 
     * @return
     */
    private int[] indexInSet( element ele ) {
        int[] indexes = new int[8];
        for ( int i = 0; i < 8; i++ ) {
            indexes[i] = hashCode( ele.getKey(), i );
        }
        return indexes;
    }

    /**
     * 娣诲姞涓�涓厓绱犲埌浣嶉泦鍐�
     */
    private void add( element ele ) {
        if ( exist( ele ) ) {
            System.out.println( "宸茬粡鍖呭惈(" + ele.getKey() + ")" );
            return;
        }
        int keyCode[] = indexInSet( ele );
        for ( int i = 0; i < 8; i++ ) {
            bits.set( keyCode[i] );
        }
    }

    /**
     * 鍒ゆ柇鏄惁瀛樺湪
     * 
     * @return
     */
    private boolean exist( element ele ) {
        int keyCode[] = indexInSet( ele );
        if ( bits.get( keyCode[0] ) && bits.get( keyCode[1] ) && bits.get( keyCode[2] ) && bits.get( keyCode[3] ) && bits.get( keyCode[4] ) && bits.get( keyCode[5] ) && bits.get( keyCode[6] )
                && bits.get( keyCode[7] ) ) {
            return true;
        }
        return false;
    }

    /**
     * 瑕佽繘琛岄泦鍚堝垹闄ゆ煇涓厓绱� 閭ｄ箞鍦ㄤ綅闆嗕腑灏嗙浉搴旂殑涓嬫爣璁剧疆涓�0鍗冲彲 浣嗘槸杩欐牱宀備笉鏄湁鍙兘浼氳褰卞搷鍒板埆鐨勫厓绱狅紝鍥犱负澶氫釜鍏冪礌鍏敤涓�涓笅鏍囧憖 閭ｆ牱宀備笉鏄鍒殑鍏冪礌涔熶笉瀛樺湪浜嗕箞 缁忔煡璇侊紝杩欏氨鏄痓loom Filter鐨勭己鐐癸紝涓嶈兘鍒犻櫎鍏冪礌銆�
     * 
     * @return
     */
    private boolean deleteElement( element ele ) {
        if ( exist( ele ) ) {
            int keyCode[] = indexInSet( ele );
            for ( int i = 0; i < 8; i++ ) {
                bits.clear( keyCode[i] );
            }
            return true;
        }
        return false;
    }

    /**
     * Q浼犲叆涓嶅悓鐨凲灏卞彲浠ュ緱鍒扮畝鍗曠殑涓嶅悓鐨刪ash鍑芥暟
     */
    private int hashCode( String key, int Q ) {
        int h = 0;
        int off = 0;
        char val[] = key.toCharArray();
        int len = key.length();
        for ( int i = 0; i < len; i++ ) {
            h = ( 30 + Q ) * h + val[off++];
        }
        return changeInteger( h );
    }

    private int changeInteger( int h ) {
        return basic & h;// &鏄綅涓庤繍绠楃
    }

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        bloomFilter f = new bloomFilter();
        element ele = new element( "blog.csdn.net/zy825316" );
        System.out.println( "浣嶉泦澶у皬锛�" + f.defaultSize );
        f.add( ele );
        System.out.println( f.exist( ele ) );
        f.deleteElement( ele );
        System.out.println( f.exist( ele ) );
    }
}