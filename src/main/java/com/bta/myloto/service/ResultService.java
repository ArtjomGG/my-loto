package com.bta.myloto.service;

import com.sun.source.doctree.SeeTree;

import java.util.List;
import java.util.Set;

public interface ResultService {
    Set<Integer> getResults();
    Integer evaluateWin(Set<Integer> results, Set<Integer> bets);


}
