package org.java.feature.extractor.visitor.javaparser;

import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class IfStatementVisitor extends VoidVisitorAdapter<Integer> {
    
    @Override
    public void visit(IfStmt ifStmt, Integer count) {
        count = Math.toIntExact(count + ifStmt.stream().count());
        super.visit(ifStmt, count);
    }
}
