package org.javaparser.examples.visitor;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MethodPropertyVisitor extends GenericVisitorAdapter<MethodDeclaration, Void> {
    
//     visiting method that returns MethodDeclaration to the caller in the main method
    @Override
    public MethodDeclaration visit(MethodDeclaration md, Void args) {
        super.visit(md, args);
//        System.out.println(md.getBody().get().getStatements());
        return md;
    }
}
