package com.endlessquest.endlessquest;

import com.endlessquest.endlessquest.entity.Entity;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private String name;
    private ImageView imageView;
    private int count;
    private int columns;
    private int offsetX;
    private int offsetY;
    private int width;
    private int height;
    private boolean repeat = false;
    private boolean isFlipped = false;

    private int lastIndex = 1;

    public SpriteAnimation(
            String name,
            String spriteSheetPath,
            int ImageViewSize,
            Duration duration,
            int count, int columns,
            int offsetX, int offsetY,
            int width, int height,
            boolean repeat,
            boolean flipped) {
        this.name = name;
        this.imageView = new ImageView(new Image(getClass().getResourceAsStream(spriteSheetPath)));
        this.count = count;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.repeat = repeat;
        this.isFlipped = flipped;

        FloorController.getFloorScene().getChildren().add(this.getImageView());



        imageView.setFitWidth(ImageViewSize);
        imageView.setPreserveRatio(true);

        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    public void playOnce() {
        this.setCycleCount(1);
        this.play();
    }

    public void playContinuous() {
        this.setCycleCount(Animation.INDEFINITE);
        this.play();
    }


    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % columns) * width + offsetX;
            final int y = (index / columns) * height + offsetY;

            // Appliquer le retournement si nécessaire
            if (isFlipped) {
                imageView.setScaleX(-1); // Flip horizontal
            } else {
                imageView.setScaleX(1); // Pas de flip
            }

            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }

    // Ajouter cette méthode pour obtenir l'ImageView utilisé
    public ImageView getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }

    public boolean isRepeat() {
        return repeat;
    }
}