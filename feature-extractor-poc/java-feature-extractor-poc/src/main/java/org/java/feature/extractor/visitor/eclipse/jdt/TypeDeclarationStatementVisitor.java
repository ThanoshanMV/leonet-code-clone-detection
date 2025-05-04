package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;

@Getter
public class TypeDeclarationStatementVisitor extends ASTVisitor {
    
    private int typeDeclarationStatementCount;
    
    @Override
    public boolean visit(TypeDeclarationStatement typeDeclarationStatement) {
        typeDeclarationStatementCount++;
        return super.visit(typeDeclarationStatement);
    }
}
