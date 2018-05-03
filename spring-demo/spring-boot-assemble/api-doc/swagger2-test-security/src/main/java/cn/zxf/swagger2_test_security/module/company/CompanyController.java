package cn.zxf.swagger2_test_security.module.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/company" )
public class CompanyController {

    static Map<Long, Company> users = Collections.synchronizedMap( new HashMap<Long, Company>() );

    @ApiOperation( "获取公司列表" )
    @GetMapping( "get-list" )
    public List<Company> getList() {
        List<Company> r = new ArrayList<Company>( users.values() );
        return r;
    }

}