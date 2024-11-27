package reciepe;


import org.openrewrite.InMemoryExecutionContext;
import org.openrewrite.*;
import  com.camel.poc.demo.x.y.z.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class RunOpenRewrite {
    public static void main(String[] args) throws Exception {
        Test t= new Test();
        InMemoryExecutionContext ctx = new InMemoryExecutionContext(Throwable::printStackTrace);
       List<Path>files= List.of(Paths.get("src/main/java/com/camel/poc/demo/x/y/Foo.java"),
                Paths.get("src/main/java/com/camel/poc/demo/x/y/Bar.java"));
        // Load Java files
List<String> f=files.stream().map(path-> {
    try {
        return new String(Files.readAllBytes(path));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}).collect(Collectors.toList());

generateSpringConfiguration(f);
    }

    private static String generateSpringConfiguration(List<String> classNames) {
        StringBuilder builder = new StringBuilder();
        builder.append("package com.x.config;\n\n")
                .append("import org.springframework.context.annotation.Bean;\n")
                .append("import org.springframework.context.annotation.Configuration;\n")
                .append("import com.x.y.*;\n\n")
                .append("@Configuration\n")
                .append("public class AppConfig {\n\n");

        for (String className : classNames) {
            builder.append("    @Bean\n")
                    .append("    public ").append(className).append(" ").append(decapitalize(className)).append("() {\n")
                    .append("        return new ").append(className).append("();\n")
                    .append("    }\n\n");
        }

        builder.append("}");
        return builder.toString();
    }
    private static String decapitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }
}
