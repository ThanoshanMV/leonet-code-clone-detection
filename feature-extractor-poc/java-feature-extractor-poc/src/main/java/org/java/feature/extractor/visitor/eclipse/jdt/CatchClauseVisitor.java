package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CatchClause;

@Getter
public class CatchClauseVisitor extends ASTVisitor {
    
    private int catchClauseCount;
    
    @Override
    public boolean visit(CatchClause catchClause) {
        catchClauseCount++;
        return super.visit(catchClause);
    }
}
