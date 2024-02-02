package org.personal.shopping.domain.consumer.domel.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckEmailDuplication {

    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "이메일을 올바르게 입력해주세요.")
    private String email;
}
