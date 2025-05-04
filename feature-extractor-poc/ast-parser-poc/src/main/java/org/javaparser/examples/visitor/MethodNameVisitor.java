package org.javaparser.examples.visitor;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MethodNameVisitor extends VoidVisitorAdapter<List<String>> {
    
//     visiting method that returns list of Strings (method names) to the caller in the main method
    @Override
    public void visit(MethodDeclaration md, List<String> collector) {
        super.visit(md, collector);
        collector.add(md.getNameAsString());
    }
}
