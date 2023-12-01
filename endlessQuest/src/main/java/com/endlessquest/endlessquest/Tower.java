package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.enemy.*;
import com.endlessquest.endlessquest.entity.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private static List<Hero> heros = new ArrayList<>();
    private static List<Enemy> enemies = new ArrayList<>();

    private static int floor = 1;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        Tower.floor = floor;
    }

    //    heros
    public static List<Hero> getHeros() {
        return heros;
    }

    public static void addHero(Hero element) {
        heros.add(element);
    }

    public static void removeHero(Hero element) {
        heros.remove(element);
    }

    public static void setHeros(List<Hero> heros) {
        Tower.heros = heros;
    }

    //    enemies
    public static List<Enemy> getEnemies() {
        return enemies;
    }

    public static void addEnemy(Enemy element) {
        enemies.add(element);
    }

    public static void removeEnemy(Enemy element) {
        enemies.remove(element);
    }

    public static void setEnemies(List<Enemy> enemies) {
        Tower.enemies = enemies;
    }

    public static List<Enemy> generateEnemies(int floor) {
        List<Enemy> enemyList = new ArrayList<>();

        // Table of possible enemies with spawn chances
        Object[][] possibleEnemies = {
                {BlueSlime.class, 4 + (floor * 0.001)},
                {GreenSlime.class, 4 + (floor * 0.001)},
                {RedSlime.class, 4 + (floor * 0.001)}
        };

        // Generate enemies only if the enemies list is empty
        int numberOfEnemies = Utils.getRandomIntBetween(1, 3);

        for (int i = 0; i < numberOfEnemies; i++) {
            Enemy enemy = chooseEnemyWithChance(possibleEnemies, floor);
            enemyList.add(enemy);
        }

        return enemyList;
    }

    private static Enemy chooseEnemyWithChance(Object[][] possibleEnemies, int floor) {
        double totalChances = 0;

        // Calculate the sum of spawn chances based on the floor
        for (Object[] enemyInfo : possibleEnemies) {
            totalChances += (double) enemyInfo[1];
        }

        double randomChoice = Utils.getRandomDoubleBetween(0, totalChances);
        for (Object[] enemyInfo : possibleEnemies) {
            randomChoice -= (double) enemyInfo[1];
            if (randomChoice <= 0) {
                try {
                    // Instantiate the enemy class using reflection
                    return ((Class<? extends Enemy>) enemyInfo[0]).newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // As a precaution, return null if no enemy is chosen
        return null;
    }

}

