package org.java.feature.extractor.utility;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;
import org.java.feature.extractor.constants.Constants;

import java.nio.file.Paths;
import java.util.List;

public class PrettyPrinter {
    
    /**
     * Pretty print all the CompilationUnit and save them into disk. (NOTE: this method won't remove comments!)
     * @param sourceRoot
     */
    public void processSourceRoot (SourceRoot sourceRoot) {
        List<ParseResult<CompilationUnit>> parseResults = sourceRoot.tryToParseParallelized();
        sourceRoot.saveAll(Paths.get(Constants.NEW_PATH));
    }
}
