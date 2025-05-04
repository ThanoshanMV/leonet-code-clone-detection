package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.NumberLiteral;

@Getter
public class NumberLiteralVisitor extends ASTVisitor {
    
    private int numberLiteralCount;
    
    @Override
    public boolean visit(NumberLiteral numberLiteral) {
        numberLiteralCount++;
        return super.visit(numberLiteral);
    }
}
