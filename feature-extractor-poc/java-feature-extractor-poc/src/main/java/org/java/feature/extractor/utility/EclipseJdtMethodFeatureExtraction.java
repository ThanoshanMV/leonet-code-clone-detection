package org.java.feature.extractor.utility;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.java.feature.extractor.constants.Constants;
import org.java.feature.extractor.visitor.eclipse.jdt.AnonymousClassDeclarationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.ArrayCreationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.CastExpressionVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.CatchClauseVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.ClassInstanceCreationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.ConstructorInvocationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.EnumConstantDeclarationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.EnumDeclarationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.FieldDeclarationVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.ForStatementVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.IfStatementVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.NameQualifiedTypeVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.NumberLiteralVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.ParameterizedTypeVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.QualifiedTypeVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.SimpleTypeVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.TryStatementVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.TypeDeclarationStatementVisitor;
import org.java.feature.extractor.visitor.eclipse.jdt.VariableDeclarationFragmentVisitor;

import java.util.Map;

public final class EclipseJdtMethodFeatureExtraction {
    
    private void extractMethodFeature (CompilationUnit compilationUnit) {
        ClassInstanceCreationVisitor classInstanceCreationVisitor = new ClassInstanceCreationVisitor();
        compilationUnit.accept(classInstanceCreationVisitor);
        ArrayCreationVisitor arrayCreationVisitor = new ArrayCreationVisitor();
        compilationUnit.accept(arrayCreationVisitor);
        CastExpressionVisitor castExpressionVisitor = new CastExpressionVisitor();
        compilationUnit.accept(castExpressionVisitor);
        ForStatementVisitor forStatementVisitor = new ForStatementVisitor();
        compilationUnit.accept(forStatementVisitor);
        IfStatementVisitor ifStatementVisitor = new IfStatementVisitor();
        compilationUnit.accept(ifStatementVisitor);
        ConstructorInvocationVisitor constructorInvocationVisitor = new ConstructorInvocationVisitor();
        compilationUnit.accept(constructorInvocationVisitor);
        FieldDeclarationVisitor fieldDeclarationVisitor = new FieldDeclarationVisitor();
        compilationUnit.accept(fieldDeclarationVisitor);
        VariableDeclarationFragmentVisitor variableDeclarationFragmentVisitor = new VariableDeclarationFragmentVisitor();
        compilationUnit.accept(variableDeclarationFragmentVisitor);
        TryStatementVisitor tryStatementVisitor = new TryStatementVisitor();
        compilationUnit.accept(tryStatementVisitor);
        CatchClauseVisitor catchClauseVisitor = new CatchClauseVisitor();
        compilationUnit.accept(catchClauseVisitor);
        AnonymousClassDeclarationVisitor anonymousClassDeclarationVisitor = new AnonymousClassDeclarationVisitor();
        compilationUnit.accept(anonymousClassDeclarationVisitor);
        EnumDeclarationVisitor enumDeclarationVisitor = new EnumDeclarationVisitor();
        compilationUnit.accept(enumDeclarationVisitor);
        EnumConstantDeclarationVisitor enumConstantDeclarationVisitor = new EnumConstantDeclarationVisitor();
        compilationUnit.accept(enumDeclarationVisitor);
        NameQualifiedTypeVisitor nameQualifiedTypeVisitor = new NameQualifiedTypeVisitor();
        compilationUnit.accept(nameQualifiedTypeVisitor);
        QualifiedTypeVisitor qualifiedTypeVisitor = new QualifiedTypeVisitor();
        compilationUnit.accept(qualifiedTypeVisitor);
        SimpleTypeVisitor simpleTypeVisitor = new SimpleTypeVisitor();
        compilationUnit.accept(simpleTypeVisitor);
        NumberLiteralVisitor numberLiteralVisitor = new NumberLiteralVisitor();
        compilationUnit.accept(numberLiteralVisitor);
        ParameterizedTypeVisitor parameterizedTypeVisitor = new ParameterizedTypeVisitor();
        compilationUnit.accept(parameterizedTypeVisitor);
        TypeDeclarationStatementVisitor typeDeclarationStatementVisitor = new TypeDeclarationStatementVisitor();
        compilationUnit.accept(typeDeclarationStatementVisitor);
        
        System.out.println("ClassInstanceCreation: " + classInstanceCreationVisitor.getClassInstanceCreationCount());
        System.out.println("Array Creation Count: " + arrayCreationVisitor.getArrayCreationCount());
        System.out.println("Cast Expression Count: " + castExpressionVisitor.getClassExpressionCount());
        System.out.println("For Statement Count: " + forStatementVisitor.getForStatementCountCount());
        System.out.println("If Statement Count: " + ifStatementVisitor.getIfStatementCountCount());
        System.out.println("Constructor Invocation Count: " + constructorInvocationVisitor.getConstructorInvocationCount());
        System.out.println("Field Declaration Count: " + fieldDeclarationVisitor.getFieldDeclarationCount());
        System.out.println("Variable Declaration Fragment Count: " + variableDeclarationFragmentVisitor.getVariableDeclarationFragmentCount());
        System.out.println("Try Statement Count: " + tryStatementVisitor.getTryStatementCount());
        System.out.println("Catch Clause Count: " + catchClauseVisitor.getCatchClauseCount());
        System.out.println("Anonymous Class Declaration Count: " + anonymousClassDeclarationVisitor.getAnonymousClassDeclarationCount());
        System.out.println("Enum Declaration Count: " + enumDeclarationVisitor.getEnumDeclarationCount());
        System.out.println("Enum Constant Declaration Count: " + enumConstantDeclarationVisitor.getEnumConstantDeclarationCount());
        System.out.println("Name Qualified Type Count: " + nameQualifiedTypeVisitor.getNameQualifiedTypeCount());
        System.out.println("Qualified Type Count: " + qualifiedTypeVisitor.getQualifiedTypeCount());
        System.out.println("Simple Type Count: " + simpleTypeVisitor.getSimpleTypeCount());
        System.out.println("Number Literal Count: " + numberLiteralVisitor.getNumberLiteralCount());
        System.out.println("Parameterized Type Count: " + parameterizedTypeVisitor.getParameterizedTypeCount());
        System.out.println("Type Declaration Statement Count: " + typeDeclarationStatementVisitor.getTypeDeclarationStatementCount());
        System.out.println("\n\n");
    }
    
    public void generateAST (String function) {
        String source = Constants.classStart + function + Constants.classEnd; // add a fake class A as a shell, to meet the requirement of ASTParse
        ASTParser parser = ASTParser.newParser(AST.JLS17);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        Map<String, String> options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options); // In order to parse 1.5 code, some compiler options need to be set to 1.5
        parser.setCompilerOptions(options);
        parser.setSource(source.toCharArray());
        CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
        extractMethodFeature(compilationUnit);
    }
    
}
