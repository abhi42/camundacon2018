package ch.generali.camundacon18;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableProcessApplication
@EnableZuulProxy
public class CamundaWebApplication {
    public static void main(String... args) {
        SpringApplication.run(CamundaWebApplication.class, args);
    }

}
