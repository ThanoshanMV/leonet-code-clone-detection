package org.java.feature.extractor.visitor.eclipse.jdt;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.NameQualifiedType;

@Getter
public class NameQualifiedTypeVisitor extends ASTVisitor {
    
    private int nameQualifiedTypeCount;
    
    @Override
    public boolean visit(NameQualifiedType nameQualifiedType) {
        nameQualifiedTypeCount++;
        return super.visit(nameQualifiedType);
    }
}
