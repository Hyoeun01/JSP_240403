package org.zerock.b01copy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class B01copyApplication {

    public static void main(String[] args) {
        SpringApplication.run(B01copyApplication.class, args);
    }

}
