package com.study.kanapka.specification;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String key;
    private SearchOperations searchOperation;
    private boolean isOrOperation;
    private List<Object> arguments;
}