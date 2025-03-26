package com.zyf.sb_zyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class SbZyfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbZyfApplication.class, args);
    }

    // 配置日期时间提供器（可选）
    @Bean
    public AuditorAware<LocalDateTime> auditorProvider() {
        return () -> Optional.of(LocalDateTime.now());
    }
}
