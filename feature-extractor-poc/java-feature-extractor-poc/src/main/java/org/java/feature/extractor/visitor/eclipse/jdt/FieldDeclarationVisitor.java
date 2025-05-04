package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;

@Getter
public class FieldDeclarationVisitor extends ASTVisitor {
    
    private int fieldDeclarationCount;
    
    @Override
    public boolean visit(FieldDeclaration fieldDeclaration) {
        fieldDeclarationCount++;
        return super.visit(fieldDeclaration);
    }
}
