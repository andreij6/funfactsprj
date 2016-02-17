package com.creativejones.andre.funfacts.Model;

import com.creativejones.andre.funfacts.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactBook {

    private List<Fact> mFactList;
    private Random mRandom;


    public FactBook(){
        mFactList = initFacts();
        mRandom = new Random();
    }

    private List<Fact> initFacts() {
        List<Fact> result = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            result.add(new Fact("Fact : " + (i + 1)));
        }

        return  result;
    }

    public Fact getRandom(Fact currentFact) {
        if(currentFact == null){
            return mFactList.get(0);
        }

        Fact result;

        do{
            mRandom = new Random();

            int randomNum = mRandom.nextInt((mFactList.size() - 1));

            result = mFactList.get(randomNum);

        }while (result.equals(currentFact));

        return result;
    }




}
