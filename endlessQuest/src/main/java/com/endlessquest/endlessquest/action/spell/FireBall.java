package com.endlessquest.endlessquest.action.spell;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.hero.Wizard;
import com.endlessquest.endlessquest.entity.weapon.Staff;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

import java.util.List;

public class FireBall extends Spell{

    public static int hp = -20;
    public static int mp = -6;
    public static String description = "Throw a Fireball !";

    public static Class<? extends Entity> entity = Wizard.class;

    public static Class<? extends Weapon> weapon = null;

    public static void main(String[] args) {
        // Contenu de la méthode main
        System.out.println("cool raoul");
    }
}
