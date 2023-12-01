package com.endlessquest.endlessquest.entity.weapon;

import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon {

    // ajout du sprite
    protected String name;
    protected int damage;
    protected Hero hero; // Ajout de la référence au héros qui équipe l'arme

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        System.out.println("New weapon " + getName());

    }

    public void attack(Enemy target){
        int damage = getDamage() - target.getArmor();
        target.setHp(target.getHp() - damage);
        System.out.println(hero.getName() + " dealt " + damage + " damage!"); // Affichage des dégâts infligés par le chevalier

    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }



    public int getDamage(){
        return damage;
    }

    public String getName(){
        return name;
    }
}