package cn.zxf.webflux.demo.restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Restaurant {

    @Id
    public String  id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String telephone;
    
}
