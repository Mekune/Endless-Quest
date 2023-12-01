package com.endlessquest.endlessquest.entity.weapon;

import com.endlessquest.endlessquest.entity.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Axe extends Weapon {
    public Axe(String name, int damage) {
        super(name, damage);
    }
    public List<String> getAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("paralaxe");
        return abilities;
    }

    public void paralaxe(Enemy target){
        int damage = (int) (getDamage() * 1.50) - target.getArmor();
        target.setHp( (target.getHp() - damage));
        System.out.println(hero.getName() + " dealt " + damage + " damage!"); // Affichage des dégâts infligés par le chevalier

    }

}
