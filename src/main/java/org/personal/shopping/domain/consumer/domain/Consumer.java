package org.personal.shopping.domain.consumer.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consumer {

    private Long consumerId;
    private String email;
    private String password;
    private String name;
    private String birth;
    private String phoneNumber;
    private String address;
    private String cardName;
    private String cardNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String deleteFlag;
    private LocalDateTime deletedAt;
}
