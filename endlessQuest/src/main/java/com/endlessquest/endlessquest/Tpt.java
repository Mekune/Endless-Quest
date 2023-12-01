package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.hero.*;
import com.endlessquest.endlessquest.entity.weapon.*;

import java.util.List;

public class Tpt {

    public void chooseActions(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero.getName() + ", choose action :");

            if (hero instanceof Wizard) {
                Wizard wizard = (Wizard) hero;
                List<String> wizardAbilities = wizard.getWizardAbilities();
                for (String ability : wizardAbilities) {
                    System.out.println("Wizard's skill : " + ability);
                }

                Weapon equippedWeapon = wizard.getEquippedWeapon();
                if (equippedWeapon instanceof Staff) {
                    List<String> weaponAbilities = ((Staff) equippedWeapon).getAbilities();
                    for (String ability : weaponAbilities) {
                        System.out.println("Weapon's skill : " + ability);

                    }
                }
            } else if (hero instanceof Archer) {
                Archer archer = (Archer) hero;
                List<String> archerAbilities = archer.getArcherAbilities();
                for (String ability : archerAbilities) {
                    System.out.println("Archer's skill : " + ability);
                }

                Weapon equippedWeapon = archer.getEquippedWeapon();
                if (equippedWeapon instanceof Bow) {
                    List<String> weaponAbilities = ((Bow) equippedWeapon).getAbilities();
                    for (String ability : weaponAbilities) {
                        System.out.println("Weapon's skill : " + ability);
                    }
                }

            } else if (hero instanceof Knight) {
                Knight knight = (Knight) hero;
                List<String> archerAbilities = knight.getKnightAbilities();
                for (String ability : archerAbilities) {
                    System.out.println("Knight's skill : " + ability);
                }

                Weapon equippedWeapon = knight.getEquippedWeapon();
                if (equippedWeapon instanceof Sword) {
                    List<String> weaponAbilities = ((Sword) equippedWeapon).getAbilities();
                    for (String ability : weaponAbilities) {
                        System.out.println("Weapon's skill : " + ability);
                    }
                } else if (equippedWeapon instanceof Axe) {
                    List<String> weaponAbilities = ((Axe) equippedWeapon).getAbilities();
                    for (String ability : weaponAbilities) {
                        System.out.println("Weapon's skill : " + ability);
                    }
                }
            } else if (hero instanceof Priest) {
                Priest priest = (Priest) hero;
                List<String> archerAbilities = priest.getPriestAbilities();
                for (String ability : archerAbilities) {
                    System.out.println("Priest's skill : " + ability);
                }

                Weapon equippedWeapon = priest.getEquippedWeapon();
                if (equippedWeapon instanceof Staff) {
                    List<String> weaponAbilities = ((Staff) equippedWeapon).getAbilities();
                    for (String ability : weaponAbilities) {
                        System.out.println("Weapon's skill : " + ability);
                    }
                }
            }
            // add new champ
        }
    }

}
