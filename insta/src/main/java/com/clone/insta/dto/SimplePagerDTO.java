package com.clone.insta.dto;

import org.apache.commons.lang3.tuple.Pair;

import lombok.Getter;

@Getter
public class SimplePagerDTO<T> {
    private List<Pair<Integer, String>> pageLinker;
}
