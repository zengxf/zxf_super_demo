package cn.zxf.neuroph.ssc.common;

import java.sql.ResultSet;

@FunctionalInterface
public interface PoTransformer< T > {

    T transform( ResultSet res );

}
