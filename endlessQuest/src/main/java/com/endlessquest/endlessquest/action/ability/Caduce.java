package com.endlessquest.endlessquest.action.ability;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.weapon.Staff;
import com.endlessquest.endlessquest.entity.weapon.Weapon;

import java.util.List;

public class Caduce extends Ability{

    public static int hp = 25;
    public static int mp = 10;
    public static String description = "heal hp and mp";

    public static Class<? extends Entity> entity = null;

    public static Class<? extends Weapon> weapon = Staff.class;

    public static String main(Entity entity ,List<Entity> target){
        return "";
    }
}
