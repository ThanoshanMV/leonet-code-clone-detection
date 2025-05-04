package org.java.feature.extractor.visitor.javaparser;

import com.github.javaparser.ast.stmt.AssertStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class AssertStatementVisitor extends VoidVisitorAdapter<Integer> {
    
    // since we aren't interested in inner properties of AssertStmt and only its count in the MethodDeclaration, we don't need List<AssertStmt> assertStmts state.
    @Override
    public void visit (AssertStmt assertStmt, Integer assertStatementsCount) {
        super.visit(assertStmt, assertStatementsCount);
        assertStatementsCount++;
    }
}
