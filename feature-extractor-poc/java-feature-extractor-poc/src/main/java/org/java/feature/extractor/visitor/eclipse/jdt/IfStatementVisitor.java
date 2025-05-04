package org.java.feature.extractor.visitor.eclipse.jdt;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;

public class IfStatementVisitor extends ASTVisitor {
    
    private int ifStatementCount;
    
    @Override
    public boolean visit(IfStatement ifStatement) {
        ifStatementCount++;
        return super.visit(ifStatement);
    }
    
    public int getIfStatementCountCount() {
        return this.ifStatementCount;
    }
}
