package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

public abstract class Hero extends Entity {
    protected Weapon equippedWeapon;

    public static Class<? extends Hero> chosenClass;

    public Hero(String name, int hp, int mp, int armor, int agility,int attack,Weapon weapon) {
        super(name, hp, mp, armor, agility,attack);
        equippedWeapon = weapon;
        System.out.println("Hello new "+ getClass().getSimpleName() + " " + getName());

    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
}