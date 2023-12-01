package com.endlessquest.endlessquest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    static double getRandomDoubleBetween(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    static int getRandomIntBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
