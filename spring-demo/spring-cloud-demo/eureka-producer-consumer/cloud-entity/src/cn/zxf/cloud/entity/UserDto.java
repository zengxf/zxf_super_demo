package cn.zxf.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String  userName;
    private Integer age;
    private HomeDto home;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HomeDto {

	private String address;

    }

}
