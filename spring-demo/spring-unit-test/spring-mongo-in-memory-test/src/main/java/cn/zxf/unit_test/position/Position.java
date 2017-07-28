package cn.zxf.unit_test.position;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

    @Id
    private String  id;
    @CreatedDate
    private Date    createDate;

    private String  name;
    private Integer status;

    public Position( String id, String name, Integer status ) {
	super();
	this.id = id;
	this.name = name;
	this.status = status;
    }

}
