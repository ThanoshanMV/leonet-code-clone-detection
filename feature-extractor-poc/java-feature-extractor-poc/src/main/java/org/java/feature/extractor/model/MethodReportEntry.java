package org.java.feature.extractor.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodReportEntry {
    
    // can be collected from visiting MethodDeclaration
    private int lineCount;
    private int modifiersCount;
    private int typeParametersCount;
    private int parametersCount;
    private int thrownExceptionsCount;
    private int receiverParameterCount;
    private int annotationsCount;
    private int bodyStatementsCount;
    // now onwards, if we need data in DTO manner, we need to visit that statement or if we need count of that statement only we can use findAll simply. 
    private int assertStatementsCount;
    private int blockStatementsCount;
    private int breakStatementsCount;
    private int continueStatementsCount;
    private int doStatementsCount;
    private int forEachStatementsCount;
    private int forStatementsCount;
    private int whileStatementsCount;
    private int loopStatementsCount; // doStatementsCount + forEachStatementsCount + forStatementsCount + whileStatementsCount
    private int emptyStatementsCount;
    private int explicitConstructorInvocationStatementsCount;
    private int expressionStatementsCount;
    // for each expression statement
    private int annotationExpressionsCount;
    private int arrayAccessExpressionsCount;
    private int arrayCreationExpressionsCount;
    private int assignExpressionsCount;
    private int binaryExpressionsCount;
    private int castExpressionsCount;
    private int classExpressionsCount;
    private int conditionalExpressionsCount; // conditional expression means ternary operator expression
    private int enclosedExpressionsCount; // expression wrapped with ()
    private int fieldAccessExpressionsCount;
    private int instanceOfExpressionsCount;
    private int lambdaExpressionsCount;
    private int literalExpressionsCount;
    private int methodCallExpressionsCount;
    private int methodReferenceExpressionsCount;
    private int nameExpressionsCount; // identifiers
    private int objectCreationExpressionsCount;
    private int patternExpressionsCount;
    private int superExpressionsCount;
    private int switchExpressionsCount;
    private int thisExpressionsCount;
    private int typeExpressionsCount;
    private int unaryExpressionsCount;
    private int variableDeclarationExpressionsCount;
    // back to counting statements
    private int ifStatementsCount;
    private int labeledStatementsCount;
    private int localClassDeclarationStatementsCount;
    private int localRecordDeclarationStatementsCount;
    private int returnStatementsCount;
    private int switchStatementsCount;
    private int switchEntriesCount;
    private int yieldStatementsCount;
    private int synchronizedStatementsCount;
    private int throwStatementsCount;
    private int tryStatementsCount;
    private int tryResourcesCount;
    private int catchClausesCount;
    private int finallyBlocksCount;
    private int unparsableStatementsCount;
    
    @Override
    public String toString() {
        return "MethodReportEntry{" + "lineCount=" + lineCount + ", modifiersCount=" + modifiersCount + ", typeParametersCount=" + typeParametersCount + ", parametersCount=" + parametersCount + ", thrownExceptionsCount=" + thrownExceptionsCount + ", receiverParameterCount=" + receiverParameterCount + ", annotationsCount=" + annotationsCount + ", bodyStatementsCount=" + bodyStatementsCount + ", assertStatementsCount=" + assertStatementsCount + ", blockStatementsCount=" + blockStatementsCount + ", breakStatementsCount=" + breakStatementsCount + ", continueStatementsCount=" + continueStatementsCount + ", doStatementsCount=" + doStatementsCount + ", forEachStatementsCount=" + forEachStatementsCount + ", forStatementsCount=" + forStatementsCount + ", whileStatementsCount=" + whileStatementsCount + ", loopStatementsCount=" + loopStatementsCount + ", emptyStatementsCount=" + emptyStatementsCount + ", explicitConstructorInvocationStatementsCount=" + explicitConstructorInvocationStatementsCount + ", expressionStatementsCount=" + expressionStatementsCount + ", annotationExpressionsCount=" + annotationExpressionsCount + ", arrayAccessExpressionsCount=" + arrayAccessExpressionsCount + ", arrayCreationExpressionsCount=" + arrayCreationExpressionsCount + ", assignExpressionsCount=" + assignExpressionsCount + ", binaryExpressionsCount=" + binaryExpressionsCount + ", castExpressionsCount=" + castExpressionsCount + ", classExpressionsCount=" + classExpressionsCount + ", conditionalExpressionsCount=" + conditionalExpressionsCount + ", enclosedExpressionsCount=" + enclosedExpressionsCount + ", fieldAccessExpressionsCount=" + fieldAccessExpressionsCount + ", instanceOfExpressionsCount=" + instanceOfExpressionsCount + ", lambdaExpressionsCount=" + lambdaExpressionsCount + ", literalExpressionsCount=" + literalExpressionsCount + ", methodCallExpressionsCount=" + methodCallExpressionsCount + ", methodReferenceExpressionsCount=" + methodReferenceExpressionsCount + ", nameExpressionsCount=" + nameExpressionsCount + ", objectCreationExpressionsCount=" + objectCreationExpressionsCount + ", patternExpressionsCount=" + patternExpressionsCount + ", superExpressionsCount=" + superExpressionsCount + ", switchExpressionsCount=" + switchExpressionsCount + ", thisExpressionsCount=" + thisExpressionsCount + ", typeExpressionsCount=" + typeExpressionsCount + ", unaryExpressionsCount=" + unaryExpressionsCount + ", variableDeclarationExpressionsCount=" + variableDeclarationExpressionsCount + ", ifStatementsCount=" + ifStatementsCount + ", labelledStatementsCount=" + labeledStatementsCount + ", localClassDeclarationStatementsCount=" + localClassDeclarationStatementsCount + ", localRecordDeclarationStatementsCount=" + localRecordDeclarationStatementsCount + ", returnStatementsCount=" + returnStatementsCount + ", switchStatementsCount=" + switchStatementsCount + ", switchEntriesCount=" + switchEntriesCount + ", yieldStatementsCount=" + yieldStatementsCount + ", synchronizedStatementsCount=" + synchronizedStatementsCount + ", throwStatementsCount=" + throwStatementsCount + ", tryStatementsCount=" + tryStatementsCount + ", tryResourcesCount=" + tryResourcesCount + ", catchClausesCount=" + catchClausesCount + ", finallyBlocksCount=" + finallyBlocksCount + ", unparsableStatementsCount=" + unparsableStatementsCount + '}';
    }
}
