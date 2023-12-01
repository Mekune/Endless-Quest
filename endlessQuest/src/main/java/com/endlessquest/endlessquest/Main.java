package com.endlessquest.endlessquest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        scene = new Scene(root, 1350, 760);
        scene.getStylesheets().add(getClass().getResource("/style/global.css").toExternalForm());

        Image image = new Image(getClass().getResourceAsStream("/UI/cursor.png"));  //pass in the image path
        scene.setCursor(new ImageCursor(image));

        // runTest();

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Endless Quest");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runTest() throws IOException {
//        Test.EnemisGenTest();
//        Test.main();
        Test.actionTest();
    }
    public static void main(String[] args) {
        launch();
    }
}