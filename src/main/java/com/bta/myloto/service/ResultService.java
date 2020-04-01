package com.bta.myloto.service;

import com.bta.myloto.domain.MyLotoResult;

import java.util.List;
import java.util.Set;

public interface ResultService {
    MyLotoResult getResults();
    Integer evaluateWin(Set<Integer> results, Set<Integer> bets);
    List<MyLotoResult> getAllResults();


}
