package org.javaparser.examples.visitor;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.ModifierVisitor;

public final class CommentModifierVisitor extends ModifierVisitor<Void> {
    
    @Override
    public JavadocComment visit (JavadocComment jc, Void args) {
        super.visit(jc, args);
        jc.getAllContainedComments().forEach(Node::remove);
        return jc;
    }
}
