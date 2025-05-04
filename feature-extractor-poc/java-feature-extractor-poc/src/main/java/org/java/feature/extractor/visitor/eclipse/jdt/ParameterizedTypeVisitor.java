package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ParameterizedType;

@Getter
public class ParameterizedTypeVisitor extends ASTVisitor {
    
    private int parameterizedTypeCount;
    
    @Override
    public boolean visit(ParameterizedType parameterizedType) {
        parameterizedTypeCount++;
        return super.visit(parameterizedType);
    }
}
