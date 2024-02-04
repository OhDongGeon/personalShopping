package org.personal.shopping.domain.consumer.domel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.personal.shopping.domain.consumer.domain.Consumer;

@Getter
@Setter
@Builder
public class LoginDto {

    private String email;
    private String name;

    public static LoginDto from(Consumer consumer) {

        return LoginDto.builder()
            .email(consumer.getEmail())
            .name(consumer.getName())
            .build();
    }
}
