package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.SimpleType;

@Getter
public class SimpleTypeVisitor extends ASTVisitor {
    
    private int simpleTypeCount;
    
    @Override
    public boolean visit(SimpleType simpleType) {
        simpleTypeCount++;
        return super.visit(simpleType);
    }
}
