package org.personal.shopping.domain.consumer.domel.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConsumerDto {

    private Long consumer_id;
    private String email;
    private String consumer_password;
    private String name;
    private String birth;
    private String phone_number;
    private String address;
    private String card_name;
    private String card_number;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String delete_flag;
    private LocalDateTime deleted_at;

}
