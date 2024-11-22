import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import routes.AppConfig;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring application context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Camel context from Spring
        CamelContext camelContext = applicationContext.getBean(CamelContext.class);

        try {
            // Start the Camel context
            camelContext.start();

            // Send a message to the first route
            camelContext.createProducerTemplate().sendBody("direct:first", "Hello, Apache Camel with Spring!");

            // Keep the application running for a few seconds to process routes
            Thread.sleep(3000);

            // Stop the Camel context
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}