package org.java.feature.extractor.visitor.javaparser;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ModifierVisitor extends VoidVisitorAdapter<Void> {
    
    int i = 0;
    @Override
    public void visit(Modifier modifier, Void args) {
        System.out.println(modifier);
        super.visit(modifier, args);
        i++;
    }
}
