package com.bta.myloto.service;

import com.bta.myloto.dao.MyLotoResultRepository;
import com.bta.myloto.domain.MyLotoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

//Sgenerit chisla ot 1 do 48 i sloshit v Set iz 6-ti chisel, i potom vernjot' etot Set

@Service
public class MyLotoResultService implements ResultService {

    @Autowired
    private MyLotoResultRepository myLotoResultRepository;

    @Override
    public MyLotoResult getResults() {

        Set<Integer> results = new HashSet<>();

        /*results.add((int)(Math.random()*49+1));
        results.add((int)(Math.random()*49+1));
        results.add((int)(Math.random()*49+1));
        results.add((int)(Math.random()*49+1));
        results.add((int)(Math.random()*49+1));
        results.add((int)(Math.random()*49+1));*/

        Random random = new Random();
        while (results.size() < 6) {
            results.add(random.nextInt(49) + 1);
        }
        Iterator<Integer> iterator = results.iterator();
        int num1 = iterator.next();
        int num2 = iterator.next();
        int num3 = iterator.next();
        int num4 = iterator.next();
        int num5 = iterator.next();
        int num6 = iterator.next();

        MyLotoResult myLotoResults = new MyLotoResult(0L, LocalDateTime.now(), num1, num2, num3, num4, num5, num6);
        myLotoResultRepository.saveOrUpdate(myLotoResults);

        return myLotoResults;
    }

    @Override
    public Integer evaluateWin(Set<Integer> results, Set<Integer> bets) {
        int count = (int) bets.stream().filter(integer -> results.contains(integer)).count();
        int prize = 0;
        switch (count) {
            case 2:
                prize = 10;
                break;
            case 3:
                prize = 50;
                break;
            case 4:
                prize = 100;
                break;
            case 5:
                prize = 5000;
                break;
            case 6:
                prize = 25000;
                break;
            default:
                System.out.println("Sorry! Try again");

        }
        System.out.println("Your ticket numbers " + bets);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Loto results " + results);
        System.out.println("You have " + count + " matches");
        System.out.println("Your prize " + prize + " Eoros");

        return prize;
    }

    @Override
    public List<MyLotoResult> getAllResults() {
        //TODO implenet at home
        // vsjat repositorij FindAll i vsjat vase dann6
        return null;
    }
}
