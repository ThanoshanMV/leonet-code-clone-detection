package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

@Getter
public class VariableDeclarationFragmentVisitor extends ASTVisitor {
    
    private int variableDeclarationFragmentCount;
    
    @Override
    public boolean visit(VariableDeclarationFragment variableDeclarationFragment) {
        variableDeclarationFragmentCount++;
        return super.visit(variableDeclarationFragment);
    }
}
