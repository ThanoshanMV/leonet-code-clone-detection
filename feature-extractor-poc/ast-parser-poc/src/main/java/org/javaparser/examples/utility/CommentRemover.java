package org.javaparser.examples.utility;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;

import java.util.List;

public final class CommentRemover {
    
    public static void removeComments (CompilationUnit compilationUnit) {
        List<Comment> comments = compilationUnit.getAllComments();
        if (0 < comments.size()) {
            comments.forEach(Node::remove);
        }
    }
}
