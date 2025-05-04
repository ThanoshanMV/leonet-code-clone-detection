package org.java.feature.extractor.visitor.eclipse.jdt;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayCreation;

public class ArrayCreationVisitor extends ASTVisitor {
    
    private int arrayCreationCount;
    
    @Override
    public boolean visit(ArrayCreation arrayCreation) {
        arrayCreationCount++;
        return super.visit(arrayCreation);
    }
    
    public int getArrayCreationCount() {
        return this.arrayCreationCount;
    }
}
