package org.javaparser.examples.visitor;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import lombok.Getter;
import lombok.Setter;
import org.javaparser.examples.model.MethodReportEntry;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MethodDeclarationVisitor extends VoidVisitorAdapter<List<MethodDeclaration>> {
    
    // visiting method that returns a list of MethodDeclaration to the caller in the main method
    @Override
    public void visit(MethodDeclaration md, List<MethodDeclaration> args) {
        super.visit(md, args);
        args.add(md);
    }
    
    public void createMethodReportEntries (List<MethodDeclaration> methodDeclarations) {
        if (0 == methodDeclarations.size()) {
            System.out.println("Error: There are no MethodDeclarartions found!");
        } else {
            List<MethodReportEntry> entries = new ArrayList<>();
            for (MethodDeclaration each : methodDeclarations) {
                String type = each.getTypeAsString();
                int bodyStatementsCount = -1;
                int bodyBeginLineNumber = -1;
                int bodyEndLineNumber = -1;
                int bodyLinesCount = -1;
                int methodBeginLineNumber = -1;
                int methodEndLineNumber = -1;
                int methodLinesCount = -1;
        
                if (each.getBody().isPresent()) {
                    bodyStatementsCount = each.getBody().get().getStatements().size();
                    if (each.getBody().get().getBegin().isPresent()) {
                        bodyBeginLineNumber = each.getBody().get().getBegin().get().line;
                    }
                    if (each.getBody().get().getEnd().isPresent()) {
                        bodyEndLineNumber = each.getBody().get().getEnd().get().line;
                    }
                    bodyLinesCount = bodyEndLineNumber - bodyBeginLineNumber;
                }
                int methodModifiersCount = each.getModifiers().size();
                String methodName = each.getNameAsString();
                if (each.getBegin().isPresent()) {
                    if (each.getBegin().isPresent()) {
                        methodBeginLineNumber = each.getBegin().get().line;
                    }
                    if (each.getEnd().isPresent()) {
                        methodEndLineNumber = each.getEnd().get().line;
                    }
                    methodLinesCount = methodEndLineNumber - methodBeginLineNumber;
                }
                MethodReportEntry entry = new MethodReportEntry(type, bodyStatementsCount, bodyBeginLineNumber, bodyEndLineNumber, methodModifiersCount,
                        methodName, methodBeginLineNumber, methodEndLineNumber);
        
                entries.add(entry);
            }
            for (MethodReportEntry each : entries) {
                System.out.println(each.toString());
            }
        }
    }
}
