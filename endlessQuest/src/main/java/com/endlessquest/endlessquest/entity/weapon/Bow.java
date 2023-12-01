package com.endlessquest.endlessquest.entity.weapon;

import com.endlessquest.endlessquest.entity.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bow extends Weapon{
    public Bow(String name, int damage) {
        super(name, damage);
    }

    public List<String> getAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("multiShot");
        abilities.add("powerShot");
        return abilities;
    }



/*    public void mutliShot(List<Enemy> getEnemies){
        int manacost = 15;
        for (Enemy target : getEnemies) {
            target.setHp(target.getHp() - (damage - target.getArmor()));
        }
    }*/

    public void multiShot(List<Enemy> enemies) {
        int manacost = 15;
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            if (enemies.isEmpty()) {
                break;
            }

            int randomIndex = random.nextInt(enemies.size());
            Enemy target = enemies.get(randomIndex);
            int damage = getDamage() - target.getArmor();
            target.setHp(target.getHp() - damage);
            System.out.println(hero.getName() + " dealt " + damage + " damage to " + target.getName()); // Affichage des dégâts infligés par le chevalier
            if (target.getHp() <= 0){
                target.death();
            }
        }

    }

    public void powerShot(Enemy target){
        int manacost = 12;
        int damage = (int) ((this.damage * 1.75) + hero.getAttack() - target.getArmor());
        target.setHp(target.getHp() - damage);
        System.out.println(hero.getName() + " dealt " + damage + " damage to " + target.getName()); // Affichage des dégâts infligés par le chevalier
        if (target.getHp() <= 0){
            target.death();
        }
    }

}
