package com.endlessquest.endlessquest.entity.enemy;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends Entity {
    protected Weapon equippedWeapon;

    public Enemy(){
    };

    public Enemy(String name, int hp, int mp, int armor, int agility, int attack) {
        super(name, hp, mp, armor, agility, attack);
        equippedWeapon = null;
//        System.out.println("Hello new "+ getClass().getSimpleName() + " " + getName());

    }
    public Enemy(String name, int hp, int mp, int armor, int agility, int attack,Weapon weapon) {
        super(name, hp, mp, armor, agility, attack);
        equippedWeapon = weapon;
        System.out.println("Hello new "+ getClass().getSimpleName() + " " + getName());

    }

    public void isDead(){
        if (this.getHp()<=0){
            this.death();
        }
    }

    public abstract void hurt();
    public abstract void death();


}