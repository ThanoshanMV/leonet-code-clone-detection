package org.java.feature.extractor.visitor.eclipse.jdt;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ForStatement;

public class ForStatementVisitor extends ASTVisitor {
    
    private int forStatementCount;
    
    @Override
    public boolean visit(ForStatement forStatement) {
        forStatementCount++;
        return super.visit(forStatement);
    }
    
    public int getForStatementCountCount() {
        return this.forStatementCount;
    }
}
