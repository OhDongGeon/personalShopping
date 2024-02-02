package org.personal.shopping.domain.mapper;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.personal.shopping.domain.consumer.domain.Consumer;
import org.personal.shopping.domain.consumer.domel.form.SignUp;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ConsumerMapper {

    // 구매자 이메일 기준으로 조회
    Optional<Consumer> findByConsumerEmail(String email);

    // 구매자 이메일 확인
    boolean existsByConsumerEmail(String email);

    // 구매자 저장
    boolean consumerSave(SignUp signUp);
}
