

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import routes.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Bean and Use
        AppConfig.HelloService helloService = context.getBean(AppConfig.HelloService.class);
        helloService.sayHello();
    }
}
