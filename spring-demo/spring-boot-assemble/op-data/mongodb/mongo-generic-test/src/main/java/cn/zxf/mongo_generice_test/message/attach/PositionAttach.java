package cn.zxf.mongo_generice_test.message.attach;

import cn.zxf.mongo_generice_test.message.IAttach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionAttach implements IAttach {

    private String positionId;
    private String positionName;
    private String positionCity;

}
