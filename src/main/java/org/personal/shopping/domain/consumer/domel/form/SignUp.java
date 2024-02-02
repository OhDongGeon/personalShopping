package org.personal.shopping.domain.consumer.domel.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUp {

    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "이메일을 올바르게 입력해주세요.")
    private String email;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{10,}",
             message = "비밀번호는 10자 이상, 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    @Pattern(regexp = "^[0-9]{11,12}$", message = "핸드폰번호를 확인하세요.")
    @NotBlank(message = "핸드폰번호를 입력하세요.")
    private String phoneNumber;
}