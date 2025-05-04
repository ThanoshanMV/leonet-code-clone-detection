package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ConstructorInvocation;

@Getter
public class ConstructorInvocationVisitor extends ASTVisitor {
    
    private int constructorInvocationCount;
    
    @Override
    public boolean visit(ConstructorInvocation constructorInvocation) {
        constructorInvocationCount++;
        return super.visit(constructorInvocation);
    }
}
