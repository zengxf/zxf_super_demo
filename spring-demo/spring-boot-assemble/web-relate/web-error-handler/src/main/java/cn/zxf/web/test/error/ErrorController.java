package cn.zxf.web.test.error;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/error-test" )
public class ErrorController {

    @Autowired
    private ErrorService service;

    @GetMapping( "find-one" )
    public String testFindOne() {
        service.testFindOne();
        return "test";
    }

    @GetMapping( "test-auth-error" )
    public String testAuthError( //
            @RequestParam String userId //
    ) {
        service.testAuthError( userId );
        return "userId: " + userId;
    }

    @PostMapping( "test-create" )
    public String testCreate( //
            @Valid @RequestBody FormDto dto //
    ) {
        System.out.println( "ErrorController-testCreate-dto: " + dto );
        service.testCreate( dto );
        return "OK";
    }

}
