package com.endlessquest.endlessquest.entity.weapon;

import com.endlessquest.endlessquest.entity.hero.Hero;
import com.endlessquest.endlessquest.entity.hero.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Weapon {

    public Staff(String name, int damage) {
        super(name, damage);
    }
    public List<String> getAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("Caduce");
        return abilities;
    }

    public void caduce(Hero target){
        target.setHp(target.getHp() + getDamage());
        target.setMp(target.getMp() + getDamage());
    }



}
