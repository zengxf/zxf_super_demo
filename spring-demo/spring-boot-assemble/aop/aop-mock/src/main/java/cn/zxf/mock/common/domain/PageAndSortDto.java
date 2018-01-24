package cn.zxf.mock.common.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PageAndSortDto< T > implements Serializable {

    private static final long   serialVersionUID = 1L;

    private List<T>             dataList;             // 数据列表
    private long                total;                // 总数
    private int                 pageIndex;            // 页码
    private int                 pageSize;             // 页大小
    private Map<String, Object> data;                 // 数据

    public static < R > PageAndSortDto<R> of( List<R> dataList, PageAndSortDto<?> source ) {
        return of( dataList, source.getTotal(), source.getPageIndex(), source.getPageSize() );
    }

    public static < R > PageAndSortDto<R> of( List<R> dataList, long total, int pageIndex, int pageSize ) {
        PageAndSortDto<R> dto = new PageAndSortDto<>();
        dto.setDataList( dataList );
        dto.setTotal( total );
        dto.setPageIndex( pageIndex );
        dto.setPageSize( pageSize );
        return dto;
    }

    public static < R > PageAndSortDto<R> of( List<R> dataList, Map<String, Object> data, long total, int pageIndex, int pageSize ) {
        PageAndSortDto<R> dto = new PageAndSortDto<>();
        dto.setDataList( dataList );
        dto.setData( data );
        dto.setTotal( total );
        dto.setPageIndex( pageIndex );
        dto.setPageSize( pageSize );
        return dto;
    }
}
