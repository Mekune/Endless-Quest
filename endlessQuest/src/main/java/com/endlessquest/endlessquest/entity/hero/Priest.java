package com.endlessquest.endlessquest.entity.hero;

import com.endlessquest.endlessquest.entity.weapon.Axe;
import com.endlessquest.endlessquest.entity.weapon.Sword;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import com.endlessquest.endlessquest.entity.weapon.Staff;

import java.util.ArrayList;
import java.util.List;

public class Priest extends Hero {

    public Priest(String name, int hp, int mp, int armor, int agility,int attack, Weapon weapon) {
        super(name, hp, mp, armor, agility,attack, weapon);
    }

    public List<String> getPriestAbilities() {
        List<String> abilities = new ArrayList<>();
        abilities.add("heal");
        abilities.add("multiHeal");
        abilities.add("meditation");
        return abilities;
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

    public void mutliHeal(Hero cible){
        // récupere la liste de héro et ajoute a tous du heal a hauteur de 50%
    }

    public void meditation(){
        setMp(getMp() + (getMaxmp()/4));
        if (getMp() > maxmp){
            setMp(maxmp);
        }
        System.out.println(getName() +  " +" + getMp()/4 + " mp!"); // Affiche le nouveau MP du prêtre
    }
}
