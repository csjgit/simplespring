package routes;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FirstRoute extends RouteBuilder {
    @Override
    public void configure() {

        // Flow 1: Read CSV file and unmarshal to Order objects
        from("file:input1/").log("Reading file: ${header.CamelFileName}")
                .to("direct:third");


        from("direct:third").bean(SampleObject.class,"test(2)");
    }
}
