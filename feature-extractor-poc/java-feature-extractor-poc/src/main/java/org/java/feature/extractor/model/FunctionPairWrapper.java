package org.java.feature.extractor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FunctionPairWrapper {
    
    private int functionOneId;
    private int functionTwoId;
    private String functionOneText;
    private String functionTwoText;
}
