package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.SpriteAnimation;
import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.weapon.Axe;
import com.endlessquest.endlessquest.entity.weapon.Staff;
import com.endlessquest.endlessquest.entity.weapon.Sword;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wizard extends Hero {
    private SpriteAnimation deathAnimation;
    private SpriteAnimation hurtAnimation;
    private SpriteAnimation idleAnimation;
    private SpriteAnimation attack1Animation;
    private SpriteAnimation attack2Animation;

    public static String classTitle = "entity/hero";
    public static String classLore = "The Magi, long marginalized and misunderstood for their mysterious powers, have discovered that the tower is a link between worlds. Convinced that the key to understanding the secrets of the cosmos lies at the top of the tower, the Erudits of the Ethereal Arcanum set out on a perilous journey. Their goal is to master the primordial energies that permeate every floor of the tower, and thus unlock the true nature of reality. Rumors suggest that the tower itself may be an ancient magical artifact, waiting to be awakened by skilled hands.";

    public Wizard(String name, int hp, int mp, int armor, int agility,int attack, Weapon weapon) {
        super(name, hp, mp, armor, agility, attack,weapon);
//        deathAnimation = new SpriteAnimation("death", "/entity/hero/wizard/death.png", 400, Duration.millis(800), 7, 7, 0, 0, 231, 190, true, false);
//        addSpriteAnimation(deathAnimation);
//        hurtAnimation = new SpriteAnimation("hurt","/entity/hero/wizard/hurt.png", 400, Duration.millis(600), 4, 4, 0, 0, 231, 190, true, false);
//        addSpriteAnimation(hurtAnimation);
//        idleAnimation = new SpriteAnimation("idle","/entity/hero/wizard/idle.png", 400, Duration.millis(600), 6, 6, 0, 0, 231, 190, true, false);
//        addSpriteAnimation(idleAnimation);
//        attack1Animation = new SpriteAnimation("attack1","/entity/hero/wizard/attack1.png", 400, Duration.millis(600), 8, 8, 0, 0, 231, 190, true, false);
//        addSpriteAnimation(attack1Animation);
//        attack2Animation = new SpriteAnimation("attack2","/entity/hero/wizard/attack2.png", 400, Duration.millis(600), 8, 8, 0, 0, 231, 190, true, false);
//        addSpriteAnimation(attack2Animation);
//        updateAnimation("idle");
    }

    public List<String> getWizardAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("Fireball");
        abilities.add("Zap");
        return abilities;
    }
    public void performAbility(String abilityName, Enemy enemy) {
        switch (abilityName) {
            case "Fireball":
                fireBall(enemy);
                break;
            case "Zap":
                zap(Arrays.asList(enemy));
                break;
            default:
                System.out.println("Ability not recognized");
        }
    }

    public void fireBall(Enemy target){
        int manacost = 10;
        int damage = (int) (attack * 1.50) - target.getArmor();
        setMp(getMp() - manacost);
        target.setHp(target.getHp() - damage);
    }

    public void zap(List<Enemy> getEnemies){
        int manacost = 15;
        int damage = (int) (attack * 0.75);
        setMp(getMp() - manacost);
        for (Enemy target : getEnemies) {
            target.setHp(target.getHp() - (damage - target.getArmor()));
        }
    }


    @Override
    public void setEquippedWeapon(Weapon weapon) {
        if (!(weapon instanceof Staff)) {
            System.out.println("A " + getName() +" can't equip " + weapon.getName() + "!");
        } else {
            if (equippedWeapon != null) {
                equippedWeapon.setHero(null);
            }if (weapon instanceof Staff) {
                ((Staff) weapon).setHero(this);
            }
            equippedWeapon = weapon;
            equippedWeapon.setHero(this);
            System.out.println(getName() + " equip " + weapon.getName());
        }
    }


}
