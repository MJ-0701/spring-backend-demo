package com.example.portfolio_demo.global.domain.request;

import com.example.portfolio_demo.global.annotation.YearMonth;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

//    private Long id;

    private String name;

    private String pwd;

    @Email
    private String email;

    @JsonProperty("phone_number")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.") // 핸드폰 정규식
    private String phoneNumber;

    @YearMonth
    private String reqYearMonth; // yyyyMM

    @Valid // 붙이지 않으면 CarDTO 의 @Notblank 검사 안됨.
    private List<CarDTO> carDTOList;

//    @AssertTrue(message = "yyyyMM 의 형식에 맞지 않습니다.")
//    public boolean isReqYearMonthValidation(){ // 이런식으로 만들면 코드 재사용이 불가능 하므로 어노테이션을 직접 만들어줘서 사용한다.
//        try{
//            LocalDate localDate = LocalDate.parse(getReqYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd")); // LocalDateTime 이라 dd까지
//
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//
//        }
//
//
//
//        return true;
//    }
}
