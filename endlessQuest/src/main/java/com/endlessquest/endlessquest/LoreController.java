package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.hero.Archer;
import com.endlessquest.endlessquest.entity.hero.Hero;
import com.endlessquest.endlessquest.entity.hero.Knight;
import com.endlessquest.endlessquest.entity.hero.Wizard;
import com.endlessquest.endlessquest.entity.weapon.Weapon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoreController extends Controller {

    @FXML
    private Label classTitle;

    @FXML
    private Label classLore;

    @FXML
    public void initialize() {

        try {
            String classTitle = Hero.chosenClass.getSimpleName();
            String classLore = Hero.chosenClass.getField("classLore").get(null).toString();

            this.classTitle.setText(classTitle);
            this.classLore.setText(classLore);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public void handleBackClassChoice() throws Exception {
        loadScene("ClassChoice.fxml");

    }

    public void startGame() throws Exception {
//        Hero heroInstance = Hero.chosenClass.getDeclaredConstructor().newInstance();
        Hero player = null; // Déclarez la variable à l'extérieur des blocs if

        if (Hero.chosenClass == Wizard.class) {
            player = new Wizard("Amadeus ", 125, 60, 25, 10, 10, null);
        } else if (Hero.chosenClass == Knight.class) {
            player = new Knight("Pontius", 125, 60, 25, 10, 10 , null);
        } else if (Hero.chosenClass == Archer.class) {
            player = new Archer("Zoya", 125, 60, 25, 10,10,null);
        }
        Tower.addHero(player);
        loadScene("Loading.fxml");

    }
}
