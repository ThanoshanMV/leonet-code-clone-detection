package org.java.feature.extractor.visitor.javaparser;

import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class TryStatementVisitor extends VoidVisitorAdapter<List<TryStmt>> {
    
    @Override
    public void visit (TryStmt tryStmt, List<TryStmt> tryStmts) {
        super.visit(tryStmt, tryStmts);
        tryStmts.add(tryStmt);
    }
}
