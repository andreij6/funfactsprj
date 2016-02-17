package com.creativejones.andre.funfacts.Model;

import com.creativejones.andre.funfacts.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorWheel {

    private List<Integer> mColors;
    private Random mRandom;


    public ColorWheel(){
        mColors = initColors();
        mRandom = new Random();
    }

    private List<Integer> initColors() {
        List<Integer> result = new ArrayList<>();

        result.add(R.color.aqua);
        result.add(R.color.orange);
        result.add(R.color.lightblue);
        result.add(R.color.lightgray);
        result.add(R.color.green);
        result.add(R.color.lavender);
        result.add(R.color.mauve);
        result.add(R.color.mustard);
        result.add(R.color.darkblue);
        result.add(R.color.darkgray);

        return result;
    }

    public int getRandomColor() {
        int randomNum = mRandom.nextInt((mColors.size() - 1));

        return mColors.get(randomNum);
    }
}
