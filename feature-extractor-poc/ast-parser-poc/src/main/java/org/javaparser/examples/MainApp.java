package org.javaparser.examples;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;
import org.javaparser.examples.utility.CommentRemover;
import org.javaparser.examples.visitor.MethodDeclarationVisitor;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static final String function = "public static void execute2() throws IOException, InterruptedException {\n" + "\t\tRuntime rt = Runtime.getRuntime();\n" + "\t\tProcess p = rt.exec(\"myCommand\");\n" + "\t\tBufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));\n" + "\t\tString line = null;\n" + "\t\twhile((line = in.readLine()) != null)\n" + "\t\t\tSystem.out.println(line);\n" + "\t\tp.waitFor();\n" + "\t\tp.destroy();\n" + "\t}";
    private static final String function1 = "public static void execute2() throws IOException, InterruptedException {\n" + "\t\t// Get Runtime\n" + "\t\tRuntime rt = Runtime.getRuntime();\n" + "\t\t\n" + "\t\t//Execute Process\n" + "\t\tProcess p = rt.exec(\"myCommand\");\n" + "\t\t\n" + "\t\t//Redirect external process stdout to this program's stdout\n" + "\t\tBufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));\n" + "\t\tString line = null;\n" + "\t\twhile((line = in.readLine()) != null)\n" + "\t\t\tSystem.out.println(line);\n" + "\t\t\n" + "\t\t//Wait for process to complete and cleanup\n" + "\t\tp.waitFor();\n" + "\t\tp.destroy();\n" + "\t}";
//    private static final String FILE_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-dataset-for-javaparser\\27.java";
//    private static final String FILE_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-dataset-for-javaparser\\28.java";
    private static final String FILE_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-dataset-for-javaparser\\645.java";
//    private static final String FILE_PATH = "C:\\Users\\mvtha\\IdeaProjects\\sample-sourceroot-test\\java\\04\\files\\PrisonRules.java";
//    private static final String SOURCE_ROOT_PATH = "C:\\bigclonebench-selected-files-dataset\\original-files\\java";
    private static final String NEW_PATH = "C:\\bigclonebench-selected-pairwise-dataset\\comments-removed-files-from-original-files";
    
    
    public static void main(String[] args) throws Exception {
//        Path sourceRootPath = Path.of(SOURCE_ROOT_PATH);
        // SymbolSolverCollectionStrategy for parsing and resolving purposes. We could also use ParserCollectionStrategy for only parsing, but it's brute force.
//        ProjectRoot projectRoot = new SymbolSolverCollectionStrategy().collect(sourceRootPath);
//        processProjectRoot(projectRoot);
//        SourceRoot sourceRoot = new SourceRoot(sourceRootPath);
//        processSourceRoot(sourceRoot);
        
//             using JavaParser
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> parseResult = javaParser.parse(new File(FILE_PATH));
        if (parseResult.isSuccessful() && parseResult.getResult().isPresent()) {
//            CommentRemover.removeComments(parseResult.getResult().get());
            CompilationUnit cu = parseResult.getResult().get();
//            CommentModifierVisitor commentModifierVisitor = new CommentModifierVisitor();
//            commentModifierVisitor.visit(cu, null);
//            System.out.println(cu);
            
//            Method Declaration Visitor
//            MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
//            List<MethodDeclaration> methodDeclarations = new ArrayList<>();
//            methodDeclarationVisitor.visit(cu, methodDeclarations);
//            methodDeclarationVisitor.createMethodReportEntries(methodDeclarations);
    
//            List<MethodDeclaration> methodDeclarationList = cu.findAll(MethodDeclaration.class);
//            System.out.println(methodDeclarationList.size());
        } else {
            System.out.println("Parsing failed OR No parse result available!");
        }
        
        ParseResult<MethodDeclaration> md = javaParser.parseMethodDeclaration(function);
        ParseResult<MethodDeclaration> md1 = javaParser.parseMethodDeclaration(function1);
        MethodDeclaration m = md.getResult().get();
        MethodDeclaration m1 = md1.getResult().get();
        System.out.println(m);
        System.out.println(m1);
        MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
        List<MethodDeclaration> methodDeclarations = new ArrayList<>();
        methodDeclarations.add(m);
        methodDeclarations.add(m1);
        methodDeclarationVisitor.createMethodReportEntries(methodDeclarations);
        
//        if (parseResult.getResult().isPresent()) {
//            CompilationUnit cu = parseResult.getResult().get();
//            System.out.println(cu);
    
//            Collect Method Names in a file
//            VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
//            List<String> methodNames = new ArrayList<>();
//            methodNameCollector.visit(cu, methodNames);
//            for (String name : methodNames) {
//                System.out.println(name);
//            }
//
//            Generic Method Property Collector
//            GenericVisitorAdapter<MethodDeclaration, Void> methods = new MethodPropertyCollector();
//            methods.visit(cu, null);
            
////            Method Declaration Visitor
//            MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
//            List<MethodDeclaration> methodDeclarations = new ArrayList<>();
//            methodDeclarationVisitor.visit(cu, methodDeclarations);
//            methodDeclarationVisitor.createMethodReportEntries(methodDeclarations);
            
//        } else {
//            System.out.println("Error: Compilation Unit is NULL!");
//        }
        
//        using StaticJavaParser
//        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
//        if (null != cu) {
//            System.out.println(cu);
//        } else {
//            System.out.println("Error: Compilation Unit is NULL!");
//        }
    }
    
    private static void processProjectRoot (ProjectRoot projectRoot) {
        // for project root, the source root path is SOURCE_ROOT_PATH = "C:\\bigclonebench-selected-files-dataset\\original-files";
        List<SourceRoot> sourceRoots = projectRoot.getSourceRoots();
        for (SourceRoot each : sourceRoots) {
            processSourceRoot(each);
        }
    }
    
    private static void processSourceRoot (SourceRoot sourceRoot) {
        List<ParseResult<CompilationUnit>> parseResults = sourceRoot.tryToParseParallelized();
        for (ParseResult<CompilationUnit> each : parseResults) {
            if (each.isSuccessful() && each.getResult().isPresent()) {
                CompilationUnit compilationUnit = each.getResult().get();
                CommentRemover.removeComments(compilationUnit);
            } else {
                System.out.println("Parse failed : " + each.getProblems());
            }
        }
        sourceRoot.saveAll(Paths.get(NEW_PATH));
    }
}
