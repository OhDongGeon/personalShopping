package org.personal.shopping.domain.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.personal.shopping.domain.consumer.domain.Consumer;
import org.personal.shopping.domain.consumer.domel.form.SignIn;
import org.personal.shopping.domain.consumer.domel.form.SignUp;
import org.personal.shopping.domain.mapper.ConsumerMapper;
import org.personal.shopping.global.config.SecurityConfig;
import org.personal.shopping.global.exception.ErrorCode;
import org.personal.shopping.global.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private SecurityConfig securityConfig;


    // 구매자 로그인
    public Consumer signInFunction(SignIn signIn) {

        try {
            Consumer consumer = consumerMapper.findByConsumerEmail(signIn.getEmail())
                .orElseThrow(() -> new FindException(ErrorCode.NOT_EMAIL_PASSWORD));

            if (!securityConfig.passwordEncoder().matches(signIn.getPassword(), consumer.getPassword())) {
                throw new FindException(ErrorCode.NOT_EMAIL_PASSWORD);
            }

            return consumer;
        } catch (FindException ex) {
            throw ex;
        }
    }

    // 이메일 중복확인
    public boolean signUpCheckDuplication(String email) {

        return consumerMapper.existsByConsumerEmail(email);
    }

    // 구매자 회원가입
    public boolean signUpFunction(SignUp signUp) {

        String passwordEncode = securityConfig.passwordEncoder().encode(signUp.getPassword());
        signUp.setPassword(passwordEncode);

        return  consumerMapper.consumerSave(signUp);
    }
}
