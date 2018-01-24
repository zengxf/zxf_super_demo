package cn.zxf.mock.module.objective.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = false )
public class ObjectiveInfoDto extends ProjectDto {
    private String              id;
    private String              desc;
    private Date                createDate;
    private ObjectiveOfferDto   offerDto;
    private ObjectiveCompanyDto companyDto;

    @Data
    public static class ObjectiveOfferDto {
        private Integer    offerNumber;
        private BigDecimal offerMoney;
    }

    @Data
    public static class ObjectiveCompanyDto {
        private String                     companyId;
        private String                     companyName;
        private List<ObjectivePositionDto> positionList;
    }

    @Data
    public static class ObjectivePositionDto {
        private String  positionId;
        private Integer recommendNumber;
    }
}
