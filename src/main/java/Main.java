import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import routes.AppConfig;
import routes.FirstRoute;


public class Main {
    public static void main(String[] args) throws Exception {
        // Initialize Spring application context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Camel context from Spring
        CamelContext camelContext = applicationContext.getBean(CamelContext.class);
        camelContext.addRoutes(new FirstRoute());


        try {
            // Start the Camel context
            camelContext.start();

            // Send a message to the first route
//            camelContext.createProducerTemplate().sendBody("file:input1", "Hello, Apache Camel with Spring!");

            // Keep the application running for a few seconds to process routes
            Thread.sleep(300000);

            // Stop the Camel context
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}