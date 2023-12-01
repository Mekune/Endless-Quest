package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.hero.Archer;
import com.endlessquest.endlessquest.entity.hero.Hero;
import com.endlessquest.endlessquest.entity.hero.Knight;
import com.endlessquest.endlessquest.entity.hero.Wizard;

public class ClassChoiceController extends Controller {

    public void handleWizardClass() throws Exception{
        Hero.chosenClass = Wizard.class;
        loadScene("Lore.fxml");
    }

    public void handleKnightClass() throws Exception{
        Hero.chosenClass = Knight.class;
        loadScene("Lore.fxml");
    }

    public void handleArcherClass() throws Exception{
        Hero.chosenClass = Archer.class;
        loadScene("Lore.fxml");
    }

}
