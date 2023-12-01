package com.endlessquest.endlessquest.entity.weapon;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Sword extends Weapon {

    public Sword(String name, int damage) {
        super(name, damage);
    }

    public List<String> getAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("miraculousStroke");
        abilities.add("falconAttack");
        return abilities;
    }
    public void falconAttack(Enemy target){
        int manacost = 7;
        int damage = (int) (this.damage * 0.85) + hero.getAttack() - target.getArmor();
        target.setHp(target.getHp() - damage);
        target.setHp(target.getHp() - damage);
        System.out.println(hero.getName() + " dealt -" + damage + " damage to " + target.getName()); // Affichage des dégâts infligés par le chevalier
        target.isDead();
    }

    public void miraculousStroke(Enemy target){
        int manacost = 8;
        int damage = ((int) (this.damage * 1.25) + hero.getAttack() - target.getArmor());

        target.setHp(target.getHp() - damage);

        hero.setHp(hero.getHp() + (damage / 2)); // Modification des HP du héros associé à l'arme
        if (hero.getHp() > hero.getMaxhp()){
            hero.setHp(hero.getMaxhp());
        }
        System.out.println(hero.getName() + " dealt -" + damage + " damage to " + target.getName() + " and heal himself to +" + damage/2 + " pv!"); // Affichage des dégâts infligés par le chevalier
        target.isDead();
    }
}
