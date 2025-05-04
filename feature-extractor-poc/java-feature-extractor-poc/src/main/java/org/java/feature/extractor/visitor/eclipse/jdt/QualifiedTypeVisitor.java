package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.QualifiedType;

@Getter
public class QualifiedTypeVisitor extends ASTVisitor {
    
    private int qualifiedTypeCount;
    
    @Override
    public boolean visit(QualifiedType qualifiedType) {
        qualifiedTypeCount++;
        return super.visit(qualifiedType);
    }
}
