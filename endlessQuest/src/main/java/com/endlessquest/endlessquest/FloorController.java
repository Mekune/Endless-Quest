package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.Entity;
import com.endlessquest.endlessquest.entity.enemy.Enemy;
import com.endlessquest.endlessquest.entity.hero.Hero;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.spreadsheet.Grid;

import java.io.IOException;
import java.util.Random;

public class FloorController extends Controller {

    @FXML
    private ImageView backgroundImg;

    @FXML
    private GridPane MainScene;

    @FXML
    private Label floorInfoLabel;

    @FXML
    private GridPane floorInfo;


    @FXML
    private GridPane floorActionMenu;

    @FXML
    private GridPane floorEnemies;

    @FXML
    private GridPane floorEnemiesLabels;

    @FXML
    private GridPane floorInfoLabels;

    @FXML
    private GridPane floorAction;

    @FXML
    private Label HeroName;

    private String action;

    private static GridPane floorScene = new GridPane();

    public static GridPane getFloorScene() {
        return floorScene;
    }

    public void hideUi() {
        floorInfo.setVisible(false);
        floorEnemies.setVisible(false);
        floorAction.setVisible(false);

    }

    public void actionAttack() {
        hideUi();
        action = "attack";
        floorEnemies.setVisible(true);
    }

    public void actionAbility() {
        hideUi();
        action = "ability";
        floorAction.setVisible(true);

    }

    public void doActionMenu(Entity target){
        switch (action) {
            case "attack":
                System.out.println("attack " + target.getClass().getSimpleName());
                Tower.getHeros().get(0).getEquippedWeapon().attack((Enemy) target);

                break;
            case "Zap":
                // aoe
                break;
            case "SummonCreature":
                break;
            default:
                // Gérer d'autres compétences par défaut
                break;
        }
    }

    public void initialize() {
        floorActionMenu.toFront();


        // Set a random background
        Random random = new Random();
        String backgroundPath = "/background/" + random.nextInt(18) + ".jpg";
        Image backgroundImage = new Image(getClass().getResource(backgroundPath).toString());
        backgroundImg.setImage(backgroundImage);

        // floorScene
        floorScene.setId("FloorScene");
        GridPane.setRowIndex(floorScene, 1);
        GridPane.setColumnIndex(floorScene, 0);
        floorScene.setMaxHeight(530);
        GridPane.setValignment(floorScene, javafx.geometry.VPos.TOP);
        floorScene.setPrefWidth(1350);

        MainScene.getChildren().add(floorScene);

        /// hero name

        HeroName.setText(Tower.getHeros().get(0).getName());


        hideUi();
        floorInfo.setVisible(true);
        floorActionMenu.setVisible(false);


        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(3), event -> {
            hideUi();
            floorActionMenu.setVisible(true);
        }));
        timeline.play();

        // generate enemies
        Tower.setEnemies(Tower.generateEnemies(Tower.getFloor()));

        String floorInfoText = "";

        // pos enemies
        for (int i = 0; i < Tower.getEnemies().size(); i++) {
            Enemy enemy = Tower.getEnemies().get(i);
            enemy.setStartPos(200 + (150 * i), 215);

            Label label = new Label();
            label.setText("- " + enemy.getClass().getSimpleName());
            label.getStyleClass().add("selection");
            label.setOnMouseClicked(event -> {
                doActionMenu(enemy);
            });
            floorEnemiesLabels.setRowIndex(label, i);
            floorEnemiesLabels.setColumnIndex(label, 0);
            floorEnemiesLabels.getChildren().add(label);

            Label label2 = new Label();
            label2.setText("- " + enemy.getClass().getSimpleName() + " is approaching from the depths!");
            floorInfoLabels.setRowIndex(label2, i);
            floorInfoLabels.setColumnIndex(label2, 0);
            floorInfoLabels.getChildren().add(label2);

        }
        for (int i = 0; i < Tower.getHeros().size(); i++) {
            Hero hero = Tower.getHeros().get(i);
            hero.setStartPos(-200 + (-150 * i), 215);
        }



//        floorInfoLabel.setText(floorInfoText);
    }
}