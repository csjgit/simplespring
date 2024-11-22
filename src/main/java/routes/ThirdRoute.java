package routes;



import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ThirdRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:third")
                .log("Third Route received: ${body}")
                .to("stream:out");
    }
}
