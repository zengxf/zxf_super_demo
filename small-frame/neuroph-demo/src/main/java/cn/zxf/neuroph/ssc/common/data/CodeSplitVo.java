package cn.zxf.neuroph.ssc.common.data;

import java.util.stream.DoubleStream;

public class CodeSplitVo {

    public double[] data;

    public static CodeSplitVo of( double... arr ) {
        CodeSplitVo vo = new CodeSplitVo();
        vo.data = arr;
        return vo;
    }

    /**
     * 后两位
     */
    public double[] output() {
        return this.output( 3 );
    }

    public double[] output( int skip ) {
        return DoubleStream.of( data ).skip( skip ).toArray();
    }

}
