package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.dto.req.UserRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api") // URI 를 지정해주는 Annotation
@RestController // 해당 Class 는 REST API 를 처리하는 Controller
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "test"; // 성공
    }

    // GET API
    @GetMapping("/get/path-variable/{name}") // http://localhost:8080/api/get/path-variable/{name}
    public String pathVariable(@PathVariable(name = "name") String pathName){ // 기본적으로 파라미터와 경로변수의 이름은 같아야 함. 하지만 어쩔수 없는 경우 따로 (name = "name") 으로 맞춰 줄 수 있음
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    @GetMapping("/get/query-param") // http://localhost:8080/api/get/query-param?user=jack&email=jack2718@naver.com&age=32
    public String queryParameter(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + "=" + entry.getValue()+ "\n");
        });
        return sb.toString();
    }

    @GetMapping("/get/query-param02")
    public String queryParam(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam int age){

        return name+ " " + email + " " +age;
    }


    @GetMapping("/get/query-param03")
    public String queryParam03(UserRequestDTO userRequestDTO){ // 실제 현업에서 사용하는 방법.
        System.out.println(userRequestDTO.getName());
        System.out.println(userRequestDTO.getEmail());
        System.out.println(userRequestDTO.getAge());

        return userRequestDTO.toString(); // UserRequestDTO(name=채명정, email=jack2718@naver.com, age=32)
    }

    // POST API
/*
웹에서 데이터를 주고 받을때 xml 방식과 JSON 방식이 있는데 현재는 JSON 방식만 사용한다고 보면 된다.

JSON 형태는
string : value
number : value
boolean : value
object : value {}
array : value []

JSON을 사용하는 규칙은 snake_case 와 kamelCase 가 있는데 둘다 파싱이 가능 하여야 하며 통상적으로 snake_case 를 사용한다.

{
    "phone_number" : "010-1111-2222", -> String
    "phoneNumber" : "010-1111-2222",
    "age" : 10, -> number
    "isAgree" : false, -> boolean
    "account" : { -> object
            "email" : "jack2718@naver.com",
            "password" : "1234",
            "address" : "서울 특별시"
    },
    "user_list" : [ -> array
            {
                "account" : "abcd",
                "password" : "1234"
            },
            {
                "account" : "efgh",
                "password" : "1234"
            },
            {
                "account" : "ijkln",
                "password" : "1234"
            },

    ]
}
*/

/*
{
    "account" : "",
    "email" : "",
    "password" : "",
    "address" : ""
}
*/
    @PostMapping("/post")
    public void post(@RequestBody Map<String,Object> requestData){
        requestData.forEach((key, value) -> {
            System.out.println("key :" + key);
            System.out.println("value :" + value);
        });
    }

    @PostMapping("/post01")
    public void post(@RequestBody UserRequestDTO userRequestDTO){ // 실제 사용 방법. POST 일때 @RequestBody 어노 테이션을 사용해야 데이터를 파싱할 수 있다.
        System.out.println(userRequestDTO);
    }

    // PUT API
    @PutMapping("/put/{userId}")
    public UserRequestDTO put(@RequestBody UserRequestDTO userRequestDTO, @PathVariable Long userId){
        System.out.println(userId);
        return userRequestDTO;

    }

    // DELETE API
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);
    }

    // Response

    @GetMapping("/text") // text 형태
    public String text(@RequestParam String account){

        return account;
    }

    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json") // json 형태
    public UserRequestDTO json(@RequestBody UserRequestDTO userRequestDTO){
        // name, age, phoneNumber, address

        return userRequestDTO; // 200 ok
    }


    // ResponseEntity
    @PutMapping("/put-mapping")
    public ResponseEntity<UserRequestDTO> putMapping(@RequestBody UserRequestDTO userRequestDTO){

        //응답에 대한 커스터 마이징이 필요할떄 사용되는데 현업에서 사용하는 방식.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequestDTO); // 201 OK

    }





}
