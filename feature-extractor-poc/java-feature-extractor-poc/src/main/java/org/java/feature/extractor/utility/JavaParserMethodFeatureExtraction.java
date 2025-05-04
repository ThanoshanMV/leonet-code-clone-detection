package org.java.feature.extractor.utility;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.InstanceOfExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.LiteralExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.ast.expr.SuperExpr;
import com.github.javaparser.ast.expr.SwitchExpr;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.AssertStmt;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.BreakStmt;
import com.github.javaparser.ast.stmt.ContinueStmt;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.EmptyStmt;
import com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.LabeledStmt;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;
import com.github.javaparser.ast.stmt.LocalRecordDeclarationStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.SynchronizedStmt;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.stmt.UnparsableStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.stmt.YieldStmt;
import org.java.feature.extractor.model.MethodReportEntry;

import java.util.List;

public final class JavaParserMethodFeatureExtraction {
    
    public MethodReportEntry extractMethodFeature (MethodDeclaration methodDeclaration) {
        // create a MethodReportEntry object here to store all the extracted features. It will be our model which is used to convert to csv
        MethodReportEntry methodReportEntry = new MethodReportEntry();
        if (methodDeclaration.getRange().isPresent()) {
            methodReportEntry.setLineCount(methodDeclaration.getRange().get().getLineCount());
        }
        if (0 != methodDeclaration.getModifiers().size()) {
            methodReportEntry.setModifiersCount(methodDeclaration.getModifiers().size());
        }
        if (0 != methodDeclaration.getTypeParameters().size()) {
            methodReportEntry.setTypeParametersCount(methodDeclaration.getTypeParameters().size());
        }
        if (0 != methodDeclaration.getParameters().size()) {
            methodReportEntry.setParametersCount(methodDeclaration.getParameters().size());
        }
        if (0 != methodDeclaration.getThrownExceptions().size()) {
            methodReportEntry.setThrownExceptionsCount(methodDeclaration.getThrownExceptions().size());
        }
        if (methodDeclaration.getReceiverParameter().isPresent()) {
            methodReportEntry.setReceiverParameterCount(1);
        }
        if (0 != methodDeclaration.getAnnotations().size()) {
            methodReportEntry.setAnnotationsCount(methodDeclaration.getAnnotations().size());
        }
        if (!methodDeclaration.getBody().isPresent()) {
            return methodReportEntry;
        }
        if (0 != methodDeclaration.getBody().get().getStatements().size()) {
            methodReportEntry.setBodyStatementsCount(methodDeclaration.getBody().get().getStatements().size());
        }
        methodReportEntry.setAssertStatementsCount(methodDeclaration.findAll(AssertStmt.class).size());
        methodReportEntry.setBlockStatementsCount(methodDeclaration.findAll(BlockStmt.class).size());
        methodReportEntry.setBreakStatementsCount(methodDeclaration.findAll(BreakStmt.class).size());
        methodReportEntry.setContinueStatementsCount(methodDeclaration.findAll(ContinueStmt.class).size());
        methodReportEntry.setDoStatementsCount(methodDeclaration.findAll(DoStmt.class).size());
        methodReportEntry.setForEachStatementsCount(methodDeclaration.findAll(ForEachStmt.class).size());
        methodReportEntry.setForStatementsCount(methodDeclaration.findAll(ForStmt.class).size());
        methodReportEntry.setWhileStatementsCount(methodDeclaration.findAll(WhileStmt.class).size());
        methodReportEntry.setLoopStatementsCount(methodReportEntry.getDoStatementsCount() + methodReportEntry.getForStatementsCount() + methodReportEntry.getForEachStatementsCount() + methodReportEntry.getWhileStatementsCount());
        methodReportEntry.setEmptyStatementsCount(methodDeclaration.findAll(EmptyStmt.class).size());
        methodReportEntry.setExplicitConstructorInvocationStatementsCount(methodDeclaration.findAll(ExplicitConstructorInvocationStmt.class).size());
        methodReportEntry.setExpressionStatementsCount(methodDeclaration.findAll(ExpressionStmt.class).size());
        methodReportEntry.setAnnotationExpressionsCount(methodDeclaration.findAll(AnnotationExpr.class).size());
        methodReportEntry.setArrayAccessExpressionsCount(methodDeclaration.findAll(ArrayAccessExpr.class).size());
        methodReportEntry.setArrayCreationExpressionsCount(methodDeclaration.findAll(ArrayCreationExpr.class).size());
        methodReportEntry.setAssignExpressionsCount(methodDeclaration.findAll(AssignExpr.class).size());
        methodReportEntry.setBinaryExpressionsCount(methodDeclaration.findAll(BinaryExpr.class).size());
        methodReportEntry.setCastExpressionsCount(methodDeclaration.findAll(CastExpr.class).size());
        methodReportEntry.setClassExpressionsCount(methodDeclaration.findAll(ClassExpr.class).size());
        methodReportEntry.setConditionalExpressionsCount(methodDeclaration.findAll(ConditionalExpr.class).size());
        methodReportEntry.setEnclosedExpressionsCount(methodDeclaration.findAll(EnclosedExpr.class).size());
        methodReportEntry.setFieldAccessExpressionsCount(methodDeclaration.findAll(FieldAccessExpr.class).size());
        methodReportEntry.setInstanceOfExpressionsCount(methodDeclaration.findAll(InstanceOfExpr.class).size());
        methodReportEntry.setLambdaExpressionsCount(methodDeclaration.findAll(LambdaExpr.class).size());
        methodReportEntry.setLiteralExpressionsCount(methodDeclaration.findAll(LiteralExpr.class).size());
        methodReportEntry.setMethodCallExpressionsCount(methodDeclaration.findAll(MethodCallExpr.class).size());
        methodReportEntry.setMethodReferenceExpressionsCount(methodDeclaration.findAll(MethodReferenceExpr.class).size());
        methodReportEntry.setNameExpressionsCount(methodDeclaration.findAll(NameExpr.class).size());
        methodReportEntry.setObjectCreationExpressionsCount(methodDeclaration.findAll(ObjectCreationExpr.class).size());
        methodReportEntry.setPatternExpressionsCount(methodDeclaration.findAll(PatternExpr.class).size());
        methodReportEntry.setSuperExpressionsCount(methodDeclaration.findAll(SuperExpr.class).size());
        methodReportEntry.setSwitchExpressionsCount(methodDeclaration.findAll(SwitchExpr.class).size());
        methodReportEntry.setThisExpressionsCount(methodDeclaration.findAll(ThisExpr.class).size());
        methodReportEntry.setTypeExpressionsCount(methodDeclaration.findAll(TypeExpr.class).size());
        methodReportEntry.setUnaryExpressionsCount(methodDeclaration.findAll(UnaryExpr.class).size());
        methodReportEntry.setVariableDeclarationExpressionsCount(methodDeclaration.findAll(VariableDeclarationExpr.class).size());
        methodReportEntry.setIfStatementsCount(methodDeclaration.findAll(IfStmt.class).size());
        methodReportEntry.setLabeledStatementsCount(methodDeclaration.findAll(LabeledStmt.class).size());
        methodReportEntry.setLocalClassDeclarationStatementsCount(methodDeclaration.findAll(LocalClassDeclarationStmt.class).size());
        methodReportEntry.setLocalRecordDeclarationStatementsCount(methodDeclaration.findAll(LocalRecordDeclarationStmt.class).size());
        methodReportEntry.setReturnStatementsCount(methodDeclaration.findAll(ReturnStmt.class).size());
        methodReportEntry.setSwitchStatementsCount(methodDeclaration.findAll(SwitchStmt.class).size());
        methodReportEntry.setSwitchEntriesCount(methodDeclaration.findAll(SwitchEntry.class).size());
        methodReportEntry.setYieldStatementsCount(methodDeclaration.findAll(YieldStmt.class).size());
        methodReportEntry.setSynchronizedStatementsCount(methodDeclaration.findAll(SynchronizedStmt.class).size());
        methodReportEntry.setThrowStatementsCount(methodDeclaration.findAll(ThrowStmt.class).size());
        
        List<TryStmt> tryStmts = methodDeclaration.findAll(TryStmt.class);
        methodReportEntry.setTryStatementsCount(tryStmts.size());
        if (0 != tryStmts.size()) {
            for (TryStmt each : tryStmts) {
                methodReportEntry.setTryResourcesCount(each.getResources().size());
                if (each.getFinallyBlock().isPresent()) {
                    methodReportEntry.setFinallyBlocksCount(methodReportEntry.getFinallyBlocksCount() + 1);
                }
            }
        }
        methodReportEntry.setUnparsableStatementsCount(methodDeclaration.findAll(UnparsableStmt.class).size());
        return methodReportEntry;
    }
}
