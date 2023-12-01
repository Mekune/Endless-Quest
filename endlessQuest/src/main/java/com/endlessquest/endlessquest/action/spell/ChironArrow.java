package com.endlessquest.endlessquest.action.spell;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.hero.Archer;
import com.endlessquest.endlessquest.entity.hero.Wizard;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

import java.util.List;

public class ChironArrow extends Spell{

    public static int hp = -5;
    public static int mp = -6;
    public static String description = "Arrow rain";

    public static Class<? extends Entity> entity = Archer.class;

    public static Class<? extends Weapon> weapon = null;

    public static String main(Entity entity ,List<Entity> target){
        return "";
    }
}
