import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.tree.J;

import java.util.Collections;

public class AddMethodCallInMain extends Recipe {

    @Override
    public String getDisplayName() {
        return "Add a method call to the main method";
    }

    @Override
    public String getDescription() {
        return "Adds a specified method call to the main method of a Java class.";
    }

    @Override
    protected JavaIsoVisitor<ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {

            @Override
            public J.MethodDeclaration visitMethodDeclaration(J.MethodDeclaration method, ExecutionContext ctx) {
                // Check if this is the main method
                if (method.getSimpleName().equals("main") && method.hasModifier(J.Modifier.Type.Static)) {
                    // Create a new method call
                    String methodCall = "System.out.println(\"Hello from OpenRewrite\");";

                    // Parse the method call as a statement
                    J.Block body = method.getBody();
                    if (body != null) {
                        // Append the statement
                        J.Block updatedBody = body.withStatements(
                                body.getStatements().withTemplate(
                                        template(methodCall).build(),
                                        body.getCoordinates().lastStatement()
                                )
                        );

                        // Update the method body
                        return method.withBody(updatedBody);
                    }
                }
                return super.visitMethodDeclaration(method, ctx);
            }
        };
    }
}
