package com.endlessquest.endlessquest.entity.enemy;

import com.endlessquest.endlessquest.SpriteAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GreenSlime extends Enemy {

    private SpriteAnimation deathAnimation;
    private SpriteAnimation hurtAnimation;
    private SpriteAnimation idleAnimation;

    public GreenSlime() {
        deathAnimation = new SpriteAnimation("death", "/entity/enemy/GreenSlime/death.png", 200, Duration.millis(500), 14, 14, 0, 0, 96, 32, false, true);
        addSpriteAnimation(deathAnimation);
        hurtAnimation = new SpriteAnimation("hurt","/entity/enemy/GreenSlime/hurt.png", 200, Duration.millis(500), 11, 11, 0, 0, 96, 32, false, true);
        addSpriteAnimation(hurtAnimation);
        idleAnimation = new SpriteAnimation("idle","/entity/enemy/GreenSlime/idle.png", 200, Duration.millis(500), 7, 7, 0, 0, 96, 32, true, true);
        addSpriteAnimation(idleAnimation);
        updateAnimation("idle");
    };

    @Override
    public void hurt(){
        updateAnimation("hurt");
        hurtAnimation.setOnFinished(event -> {
            updateAnimation("idle");
        });
    }

    @Override
    public void death(){
        updateAnimation("death");

    }
}
