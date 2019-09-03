package io.tulliocba.springbootresthibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootRestHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestHibernateApplication.class, args);
    }

}
