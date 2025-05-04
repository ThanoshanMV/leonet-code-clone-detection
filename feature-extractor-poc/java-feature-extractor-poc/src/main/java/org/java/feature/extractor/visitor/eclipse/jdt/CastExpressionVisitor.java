package org.java.feature.extractor.visitor.eclipse.jdt;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CastExpression;

public class CastExpressionVisitor extends ASTVisitor {
    
    private int classCastCount;
    
    @Override
    public boolean visit(CastExpression castExpression) {
        classCastCount++;
        return super.visit(castExpression);
    }
    
    public int getClassExpressionCount() {
        return this.classCastCount;
    }
}
