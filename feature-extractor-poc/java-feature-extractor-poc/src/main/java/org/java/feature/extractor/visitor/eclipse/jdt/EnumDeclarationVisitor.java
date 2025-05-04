package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnumDeclaration;

@Getter
public class EnumDeclarationVisitor extends ASTVisitor {
    
    private int enumDeclarationCount;
    
    @Override
    public boolean visit(EnumDeclaration enumDeclaration) {
        enumDeclarationCount++;
        return super.visit(enumDeclaration);
    }
}
