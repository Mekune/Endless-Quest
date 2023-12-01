package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import com.endlessquest.endlessquest.entity.weapon.Staff;

public class Summoner extends Hero {
    public Summoner(String name, int hp, int mp, int armor, int agility,int attack, Weapon weapon) {
        super(name, hp, mp, armor, agility,attack,weapon);
    }

    @Override
    public void setEquippedWeapon(Weapon weapon) {
        if (weapon instanceof Staff) {
            this.equippedWeapon = weapon;
        } else {
            System.out.println("A Summoner can only equip staff!");
        }
    }

    public void fireball(Enemy target){

    }

    public void utiliserCompetence(Enemy cible, String competence) {
        switch (competence) {
            case "Fireball":
                // monocible fort
                break;
            case "Zap":
                // aoe
                break;
            case "SummonCreature":
                break;
            default:
                // Gérer d'autres compétences par défaut
                break;
        }
    }
}