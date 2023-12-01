package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.SpriteAnimation;
import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.weapon.Axe;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import com.endlessquest.endlessquest.entity.weapon.Sword;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Hero {
    private SpriteAnimation deathAnimation;
    private SpriteAnimation hurtAnimation;
    private SpriteAnimation idleAnimation;
    private SpriteAnimation attack1Animation;
    private SpriteAnimation attack2Animation;

    public static String classTitle = "Knight";
    public static String classLore = "In a world once torn apart by incessant warfare between rival kingdoms, a sacred order emerged to restore peace. The Knights, the elite among warriors, vowed to protect the kingdom from outside threats. Their quest to ascend the tower is motivated by a prophetic vision that foretold a growing darkness threatening to engulf the world. The Knights climb the tower to reach the heavens, where the Celestial Order revealed that an ancient power could be invoked to repel the shadow and restore balance.";

    public Knight(String name, int hp, int mp, int armor, int agility,int attack, Weapon weapon) {
        super(name, hp, mp, armor, agility,attack, weapon);
        deathAnimation = new SpriteAnimation("death", "/entity/hero/wizard/death.png", 400, Duration.millis(800), 7, 7, 0, 28, 231, 190, true, false);
        addSpriteAnimation(deathAnimation);
        hurtAnimation = new SpriteAnimation("hurt","/entity/hero/wizard/hurt.png", 400, Duration.millis(600), 4, 4, 0, 28, 231, 190, true, false);
        addSpriteAnimation(hurtAnimation);
        idleAnimation = new SpriteAnimation("idle","/entity/hero/wizard/idle.png", 400, Duration.millis(600), 6, 6, 0, 28, 231, 190, true, false);
        addSpriteAnimation(idleAnimation);
        attack1Animation = new SpriteAnimation("attack1","/entity/hero/wizard/attack1.png", 400, Duration.millis(600), 8, 8, 0, 28, 231, 190, true, false);
        addSpriteAnimation(attack1Animation);
        attack2Animation = new SpriteAnimation("attack2","/entity/hero/wizard/attack2.png", 400, Duration.millis(600), 8, 8, 0, 28, 231, 190, true, false);
        addSpriteAnimation(attack2Animation);
        updateAnimation("attack1");
    }
    public List<String> getKnightAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("heal");
        return abilities;
    }


    public void heal(Hero target){
        int manaCost = 10;
        int heal = (int) (target.getMaxhp() * 0.25);
        setMp(getMp() - manaCost);
        target.setHp(target.getHp() + heal);
        if (target.getHp() > target.getMaxhp()){
            target.setHp(getMaxhp());
        }
        System.out.println(getName() + " heal +" + heal + " pv to " + target.getName()); // Affichage des dégâts infligés par le chevalier
    }

    @Override
    public void setEquippedWeapon(Weapon weapon) {
        if (!(weapon instanceof Sword) && !(weapon instanceof Axe)) {
            System.out.println("A " + getName() +" can't equip " + weapon.getName() + "!");
        } else {
            if (equippedWeapon != null) {
                equippedWeapon.setHero(null);
            }if (weapon instanceof Sword) {
                ((Sword) weapon).setHero(this);
            }else {
                ((Axe) weapon).setHero(this);
            }
            equippedWeapon = weapon;
            equippedWeapon.setHero(this);
            System.out.println(getName() + " equip " + weapon.getName());
        }
    }
}

