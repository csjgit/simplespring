package routes;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FirstRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:first")
                .log("First Route received: ${body}")
                .to("direct:second");
    }
}
