package cn.zxf.mongo_generice_test.message;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document( collection = "test_message" )
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String  id;
    @CreatedDate
    private Date    createDate;

    private String  title;

    private Integer type;
    private IAttach attach;

}
