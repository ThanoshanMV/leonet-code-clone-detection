package org.javaparser.examples.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MethodReportEntry {
    // type section
    private String type;
    // body section
    private int bodyStatementsCount; // 3 (body -> statements)
    private int bodyBeginLineNumber; // 35 (body -> range -> begin -> line)
    private int bodyEndLineNumber; // 39
    private int bodyLinesCount; // (bodyEndLineNumber - bodyBeginLineNumber)
    // modifiers section
    private int methodModifiersCount; // public, static
    // name section
    private String methodName;
    // range section
    private int methodBeginLineNumber;
    private int methodEndLineNumber;
    private int methodLinesCount; // (methodEndLineNumber - methodBeginLineNumber)
    
    public MethodReportEntry(String type, int bodyStatementsCount, int bodyBeginLineNumber, int bodyEndLineNumber, int methodModifiersCount, String methodName, int methodBeginLineNumber, int methodEndLineNumber) {
        this.type = type;
        this.bodyStatementsCount = bodyStatementsCount;
        this.bodyBeginLineNumber = bodyBeginLineNumber;
        this.bodyEndLineNumber = bodyEndLineNumber;
        this.bodyLinesCount = this.bodyEndLineNumber - this.bodyBeginLineNumber;
        this.methodModifiersCount = methodModifiersCount;
        this.methodName = methodName;
        this.methodBeginLineNumber = methodBeginLineNumber;
        this.methodEndLineNumber = methodEndLineNumber;
        this.methodLinesCount = this.methodEndLineNumber - this.methodBeginLineNumber;
    }
    
    @Override
    public String toString() {
        return type + "|" + bodyStatementsCount + "|" + bodyLinesCount + "|" +
                methodModifiersCount + "|" + methodName + "|" + methodLinesCount;
    }
}
