package cn.zxf.cache_redis.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NavigationTabDto {

    private boolean showFinance;          // 是否显示“财务”
    private boolean showReceiveCandidate; // 是否显示“收到人选”

}
