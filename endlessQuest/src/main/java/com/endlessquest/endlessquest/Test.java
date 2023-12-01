package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.action.Action;
import com.endlessquest.endlessquest.action.ability.Ability;
import com.endlessquest.endlessquest.action.spell.Spell;
import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.enemy.BlueSlime;
import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.hero.*;
import com.endlessquest.endlessquest.entity.weapon.*;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main() {
        System.out.println("CREATION ENTITY");
        System.out.println("-----------------------------------");
        Priest priest = new Priest("the priest", 100, 100, 10, 15, 10,null);
        Knight knight = new Knight("the knight", 100, 40, 8, 12, 10,null);
        Archer archer = new Archer("the archer", 100, 40 , 8 , 10 , 10,null);
        System.out.println("-----------------------------------");
        System.out.println("CREATION WEAPON");
        System.out.println("-----------------------------------");
        Staff staff = new Staff("Holy Staff", 20);
        Sword sword = new Sword("Holy Sword", 20);
        Bow bow = new Bow("Holy Bow", 20);
        Axe axe = new Axe("Holy Axe", 30);
        System.out.println("-----------------------------------");
        System.out.println("ADD WEAPON TO HERO");
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        priest.setEquippedWeapon(sword); // Ce test devrait afficher "A priest can only equip staff!"
        priest.setEquippedWeapon(staff);
        knight.setEquippedWeapon(staff);
        knight.setEquippedWeapon(sword);
/*            System.out.println(sword.getHero());
            knight.setEquippedWeapon(axe);
            System.out.println(sword.getHero());*/

        archer.setEquippedWeapon(staff);
        archer.setEquippedWeapon(bow);
        System.out.println("-----------------------------------");
        System.out.println("TEST PRIEST & KNIGHT + Slimebleu");
        System.out.println("-----------------------------------");
        BlueSlime slime = new BlueSlime();
        BlueSlime slime2 = new BlueSlime();
        BlueSlime slime3 = new BlueSlime();
        List<Enemy> combat = new ArrayList<>();
        combat.add(slime);
        combat.add(slime2);
        combat.add(slime3);
        Tower.setEnemies(combat);
        //------
        List<Hero> herocombat = new ArrayList<>();
        herocombat.add(knight);
        herocombat.add(priest);
        herocombat.add(archer);
        Tower.setHeros(herocombat);
        System.out.println("-----------------------------------");
        Tpt tpt = new Tpt();
        tpt.chooseActions(herocombat);

        int i =0;
        for (Hero hero : Tower.getHeros()) {
            System.out.println(i + " " + hero.getName() +" " + hero.getHp());
            i++;
        }
        i=0;
        System.out.println("-----------------------------------");
        for (Enemy enemy : Tower.getEnemies()) {
            System.out.println(i + " " + enemy.getName() +" " + enemy.getHp());
            i++;
        }
        System.out.println("-----------------------------------");


        priest.heal(knight); // Devrait soigner la cible
        priest.meditation(); // Devrait augmenter le MP du prêtre
        knight.heal(priest);
        knight.heal(knight);
        sword.falconAttack(Tower.getEnemies().get(0));



        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");

        i =0;
        for (Hero hero : Tower.getHeros()) {
            System.out.println(i + " " + hero.getName() +" " + hero.getHp());
            i++;
        }
        i=0;
        System.out.println("-----------------------------------");
        for (Enemy enemy : Tower.getEnemies()) {
            System.out.println(i + " " + enemy.getName() +" " + enemy.getHp());
            i++;
        }
        System.out.println("-----------------------------------");
    }


        public static void EnemisGenTest() throws IOException {
//            Hero player = new Wizard("Amadeus ", 125, 60, 25, 10);
//            Tower.addHero(player);
//
//            Tower.setFloor(10);
//            Tower.setEnemies(Tower.generateEnemies(Tower.getFloor()));
//            System.out.println("--------------------------------");
//            System.out.println(Tower.getEnemies());

            for (int i = 0; i < 100;i++){
                Tower.setFloor(i);
                System.out.println(Tower.generateEnemies(Tower.getFloor()));
            }

        }

        public void testFloorScene(){

            FloorController.getFloorScene().getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("/entity/enemy/slime/hurt.png"))));

        }

        public static void actionTest(){
            Staff staff = new Staff("Holy Staff", 20);
            Wizard Player = new Wizard("Amadeus ", 125, 60, 25, 10, 10, staff);

            Class<? extends Entity> targetClass = Player.getClass();
            Class<? extends Action> action = Spell.class;

//            class<Weapon> targetClass = Player.getEquippedWeapon().getClass();
//            Class<? extends Action> action = Spell.class;

            List<Class<?>> childClasses = new ArrayList<>();

            // Get all classes in the same package as the ParentClass
            Package pkg = action.getPackage();
            String packageName = pkg.getName();

            // Get all classes and check if they are subclasses of ParentClass
            for (Class<?> clazz : getAllClasses(packageName)) {
                if (action.isAssignableFrom(clazz) && !clazz.equals(action)) {
                    childClasses.add(clazz);
                }
            }

            // Print out the child classes found
            System.out.println("Child classes of ParentClass:");
            for (Class<?> childClass : childClasses) {
                try {
                    Field entityField = childClass.getDeclaredField("entity");
                    Class<?> entityValue = (Class<?>) entityField.get(null);
                    if (entityValue != null && entityValue.equals(targetClass)) {

                        System.out.println("Child class: " + childClass.getSimpleName());

                        Field hpField = childClass.getDeclaredField("hp");
                        int hpValue = (int) hpField.get(null);
                        System.out.println("HP: " + hpValue);

                        Field mpField = childClass.getDeclaredField("mp");
                        int mpValue = (int) mpField.get(null);
                        System.out.println("MP: " + mpValue);

                        Field descField = childClass.getDeclaredField("description");
                        String descValue = (String) descField.get(null);
                        System.out.println("Description: " + descValue);

                        // Exécuter la méthode main des classes enfants trouvées
                        try {
                            Method mainMethod = childClass.getDeclaredMethod("main", String[].class);
                            if (mainMethod != null) {
                                System.out.println("Executing main method of: " + childClass.getSimpleName());
                                // Vous pouvez définir des arguments pour la méthode main si nécessaire
                                String[] arguments = new String[]{};
                                mainMethod.invoke(null, (Object) arguments);
                            }
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        System.out.println("-----------------------------");

                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }

    // Helper method to get all classes in a package
    private static List<Class<?>> getAllClasses(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            java.net.URL resource = classLoader.getResource(path);
            java.io.File directory = new java.io.File(resource.getFile());
            if (directory != null && directory.exists()) {
                java.io.File[] files = directory.listFiles();
                for (java.io.File file : files) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        Class<?> clazz = Class.forName(className);
                        classes.add(clazz);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }


}
