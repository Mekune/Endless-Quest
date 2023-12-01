package com.endlessquest.endlessquest;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    private double xOffset, yOffset;

    @FXML
    private ImageView FrenchPicture;

    @FXML
    private ImageView AnglaisPicture;

    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;
    public void loadScene(String path) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) Main.scene.getWindow();
        Scene scene = new Scene(root, 1350, 760);
        Main.scene = scene;
        Image image = new Image(getClass().getResourceAsStream("/UI/cursor.png"));  //pass in the image path
        scene.setCursor(new ImageCursor(image));
        scene.getStylesheets().add(getClass().getResource("/style/global.css").toExternalForm());
        window.setScene(scene);
    }

    // exit application
    public void handleExitAction(){
        Platform.exit();
    }

    // close the window
    public void handleCloseAction(){
        Stage stage = (Stage) Main.scene.getWindow();
        stage.close();
    }

    // minimizes the window
    public void handleMinimizedAction(){
        Stage stage = (Stage) Main.scene.getWindow();
        stage.setIconified(true);
    }

    // stores an x and y offset of the mouse click on the titl bar, used to calculate the frame's position relative to mouse movement
    public void handleTitleBarClickAction(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
        event.consume();
    }

    // updates the position of the frame based on the mouse drag on the title bar, using the offsets from the click action
    public void handleTitleBarMovementAction(MouseEvent event){
        Scene scene = Main.scene;
        Window window = scene.getWindow();

        // set new window position based on mouse drag
        window.setX(event.getScreenX() - xOffset);
        window.setY(event.getScreenY() - yOffset);
        event.consume();
    }

//    language selection
    public void handleLanguageChange(MouseEvent event) {
        ImageView clickedImage = (ImageView) event.getSource();
        Locale newLocale;

        if (clickedImage == FrenchPicture) {
            newLocale = new Locale("fr");
        } else if (clickedImage == AnglaisPicture) {
            newLocale = new Locale("en");
        } else {
            // Par défaut, en cas d'une autre image (ce qui ne devrait pas arriver normalement)
            newLocale = Locale.getDefault();
        }
        // Charger les propriétés en fonction de la nouvelle langue
        ResourceBundle bundle = ResourceBundle.getBundle("langue.labels", new Locale(newLocale.getLanguage()));
        updateLabels(bundle);
    }

    private void updateLabels(ResourceBundle bundle) {
        startBtn.setText(bundle.getString("startBtn"));
        exitBtn.setText(bundle.getString("exitBtn"));
    }

}