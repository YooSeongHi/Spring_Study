package com.example.restfulapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class makeAPI {
    //해당 요청이 들어올때 이 메소드를 실행시키겠다.
    @RequestMapping(value = "/api/post", method = RequestMethod.POST)
    //요청에 대한 반응 방법 (ok는 200)
    @ResponseStatus(value= HttpStatus.OK)
    public String postAPITest(){
        return "{\"result\" : \"PostResult\"}";
    }

    @RequestMapping(value = "/api/get", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getAPITest(){
        return "{\"result\" : \"GetResult\"}";
    }
}
