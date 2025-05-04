package org.java.feature.extractor.utility;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.utils.SourceRoot;
import org.java.feature.extractor.constants.Constants;

import java.nio.file.Paths;
import java.util.List;

public final class CommentRemover {
    
    private final SourceRoot sourceRoot;
    
    public CommentRemover(final SourceRoot sourceRoot) {
        this.sourceRoot = sourceRoot;
    }
    
    /**
     * Remove all the comments and pretty print, each CompilationUnit and save them to disk as usual Java files
     */
    public void processSourceRoot () {
        System.out.println("Starting to process SourceRoot....");
        List<ParseResult<CompilationUnit>> parseResults = sourceRoot.tryToParseParallelized();
        System.out.println("Number of ParseResult found : " + parseResults.size());
        int count = 0;
        for (ParseResult<CompilationUnit> each : parseResults) {
            if (each.isSuccessful() && each.getResult().isPresent()) {
                count++;
                System.out.println(each);
                CompilationUnit compilationUnit = each.getResult().get();
                this.removeComments(compilationUnit);
            }
        }
        System.out.println("Total processed ParseResult : " + count);
        sourceRoot.saveAll(Paths.get(Constants.NEW_PATH));
        System.out.println("\n\n\nSuccessfully removed comments, pretty printed and saved them to disk!");
    }
    
    private void removeComments (CompilationUnit compilationUnit) {
        List<Comment> comments = compilationUnit.getAllComments();
        if (0 < comments.size()) {
            comments.forEach(Node::remove);
        }
    }
    
    public SourceRoot getSourceRoot() {
        return sourceRoot;
    }
}
