package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;

@Getter
public class AnonymousClassDeclarationVisitor extends ASTVisitor {
    
    private int anonymousClassDeclarationCount;
    
    @Override
    public boolean visit(AnonymousClassDeclaration anonymousClassDeclaration) {
        anonymousClassDeclarationCount++;
        return super.visit(anonymousClassDeclaration);
    }
}
