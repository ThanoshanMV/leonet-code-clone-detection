package org.javaparser.examples.visitor;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.utils.SourceRoot;

import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class ModifyingVisitorComplete {
    
    private static final String FILE_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-dataset-for-javaparser\\ReversePolishNotation.java";
    private static final String SOURCE_ROOT_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-sourceroot-test\\java\\files";
    private static final String NEW_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-sourceroot-update";
    
    private static final Pattern LOOK_AHEAD_THREE = Pattern.compile("(\\d)(?=(\\d{3})+$)");
    
    public static void main(String[] args) throws Exception {
        // sourceroot exploration
        // the source root is the top level directory.
        // In C:\Users\mvtha\IdeaProjects\sample-sourceroot-test\java, "java" is the source root directory
        // The src/main/java directory for a maven-style project as source root
        SourceRoot sourceRoot = new SourceRoot(Paths.get(SOURCE_ROOT_PATH));
        List<ParseResult<CompilationUnit>> parseResults = sourceRoot.tryToParseParallelized();
        for (ParseResult<CompilationUnit> each : parseResults) {
            if (each.isSuccessful() && each.getResult().isPresent()) {
                ModifierVisitor<?> numericLiteralVisitor = new IntegerLiteralModifier();
                numericLiteralVisitor.visit(each.getResult().get(), null);   
            } else {
                System.out.println("Parse failed : " + each.getProblems());
            }
        }
        sourceRoot.saveAll(Paths.get(NEW_PATH));
    }
    
    private static class IntegerLiteralModifier extends ModifierVisitor<Void> {
        
        @Override
        public FieldDeclaration visit(FieldDeclaration fd, Void arg) {
            super.visit(fd, arg);
            fd.getVariables().forEach(v ->
                    v.getInitializer().ifPresent(i ->
                            i.ifIntegerLiteralExpr(il ->
                                    v.setInitializer(formatWithUnderscores(il.getValue()))
                            )
                    )
            );
            return fd;
        }
    }
    
    static String formatWithUnderscores(String value) {
        String withoutUnderscores = value.replaceAll("_", "");
        return LOOK_AHEAD_THREE.matcher(withoutUnderscores).replaceAll("$1_");
    }
}