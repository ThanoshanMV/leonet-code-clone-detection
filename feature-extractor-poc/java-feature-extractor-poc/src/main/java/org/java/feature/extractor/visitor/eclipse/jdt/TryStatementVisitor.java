package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TryStatement;

@Getter
public class TryStatementVisitor extends ASTVisitor {
    
    private int tryStatementCount;
    
    @Override
    public boolean visit(TryStatement tryStatement) {
        tryStatementCount++;
        return super.visit(tryStatement);
    }
}
