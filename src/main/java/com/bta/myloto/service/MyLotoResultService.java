package com.bta.myloto.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

//Sgenerit chisla ot 1 do 48 i sloshit v Set iz 6-ti chisel, i potom vernjot' etot Set

@Service
public class MyLotoResultService implements ResultService{
    @Override
    public Set<Integer> getResults() {
        //todo implemet as HomeWork
        return null;
    }

    @Override
    public Integer evaluateWin(Set<Integer> results, Set<Integer> bets) {
        int count = (int)bets.stream().filter(integer -> results.contains(integer)).count();
        switch (count) {
            case 0:
            case 1:
                return 0;
            case 2:
                return 10;
            case 3:
                return 50;
            case 4:
                return 100;
            case 5:
                return 5000;
            case 6:
                return 25000;
            default:
                return 0;
        }

    }

}
