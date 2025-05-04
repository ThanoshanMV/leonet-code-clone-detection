package org.java.feature.extractor.visitor.eclipse.jdt;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;

public class ClassInstanceCreationVisitor extends ASTVisitor {
    
    private int classInstanceCreationCount;
    
    @Override
    public boolean visit(ClassInstanceCreation classInstanceCreation) {
        classInstanceCreationCount++;
        return super.visit(classInstanceCreation);
    }
    
    public int getClassInstanceCreationCount() {
        return this.classInstanceCreationCount;
    }
}
