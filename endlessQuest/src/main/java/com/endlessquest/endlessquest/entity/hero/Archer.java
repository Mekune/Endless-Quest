package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.SpriteAnimation;
import com.endlessquest.endlessquest.entity.weapon.Bow;
import com.endlessquest.endlessquest.entity.weapon.Sword;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Archer extends Hero {
    private SpriteAnimation deathAnimation;
    private SpriteAnimation hurtAnimation;
    private SpriteAnimation idleAnimation;
    private SpriteAnimation attack1Animation;
    private SpriteAnimation attack2Animation;

    public static String classTitle = "Archer";
    public static String classLore = "Once scouts and bounty hunters, the Archers, known as the Horizon Sentinels, are guided by ancestral tales of a mystical tower on the horizon. Convinced that at the top of this structure lies knowledge forgotten for centuries, these Archers undertake the climb to reach a celestial observatory. Inspired by the belief that the tower acts as a portal to unexplored heavens, they aim to study the constellations to unlock cosmic secrets and reveal hidden powers in unknown heights, using their exceptional bow skills to overcome challenges and discover what lies hidden at the top of the tower.";

    public Archer(String name, int hp, int mp, int armor, int agility, int attack, Weapon weapon) {
        super(name, hp, mp, armor, agility, attack,weapon);
/*        deathAnimation = new SpriteAnimation("death", "/entity/hero/archer/death.png", 400, Duration.millis(800), 7, 7, 0, 28, 231, 190, true, false);
        addSpriteAnimation(deathAnimation);
        hurtAnimation = new SpriteAnimation("hurt","/entity/hero/archer/hurt.png", 400, Duration.millis(600), 4, 4, 0, 28, 231, 190, true, false);
        addSpriteAnimation(hurtAnimation);
        idleAnimation = new SpriteAnimation("idle","/entity/hero/archer/idle.png", 400, Duration.millis(600), 2, 2, 0, 28, 231, 190, true, false);
        addSpriteAnimation(idleAnimation);
        attack1Animation = new SpriteAnimation("attack1","/entity/hero/archer/attack1.png", 400, Duration.millis(600), 8, 8, 0, 28, 231, 190, true, false);
        addSpriteAnimation(attack1Animation);
        attack2Animation = new SpriteAnimation("attack2","/entity/hero/archer/attack2.png", 400, Duration.millis(600), 8, 8, 0, 28, 231, 190, true, false);
        addSpriteAnimation(attack2Animation);
        updateAnimation("idle");*/
    }
    public List<String> getArcherAbilities() {
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
        if (weapon instanceof Bow) {
            this.equippedWeapon = weapon;
            System.out.println(getName() + " equip " + weapon.getName());
        } else {
            System.out.println("A " + getClass().getSimpleName() + " can't equip " + weapon.getName() + "!");
        }
    }

}
