package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;

@Getter
public class EnumConstantDeclarationVisitor extends ASTVisitor {
    
    private int enumConstantDeclarationCount;
    
    @Override
    public boolean visit(EnumConstantDeclaration enumConstantDeclaration) {
        enumConstantDeclarationCount++;
        return super.visit(enumConstantDeclaration);
    }
}
