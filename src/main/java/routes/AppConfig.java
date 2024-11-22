package routes;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "routes")
public class AppConfig {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
    @Bean
    public CamelContext camelContext() {
        return new SpringCamelContext(new ClassPathXmlApplicationContext());
    }

    public static class HelloService {
        public void sayHello() {
            System.out.println("Hello from Spring without Spring Boot!");
        }
    }
}
