package com.endlessquest.endlessquest.action.spell;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.hero.Wizard;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

public class Zap extends Spell{

    public static int hp = -8;
    public static int mp = -6;
    public static String description = "Throw a thunder on each enemies !";

    public static Class<? extends Entity> entity = Wizard.class;

    public static Class<? extends Weapon> weapon = null;

    public static void main(String[] args) {
        // Contenu de la méthode main
        System.out.println("zap !!!");
    }
}
