package com.endlessquest.endlessquest;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class LoadingController extends Controller {

    public void initialize() {
        // Créer une Timeline avec un KeyFrame de 3 secondes
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    loadScene("Floor.fxml");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));

        // Démarrer la Timeline
        timeline.play();
    }
}
