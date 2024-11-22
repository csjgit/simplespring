package routes;



import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SecondRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:second")
                .log("Second Route received: ${body}")
                .to("direct:third");
    }
}
