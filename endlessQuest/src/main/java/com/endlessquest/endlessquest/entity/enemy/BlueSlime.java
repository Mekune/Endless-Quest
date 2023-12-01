package com.endlessquest.endlessquest.entity.enemy;

import com.endlessquest.endlessquest.SpriteAnimation;
import com.endlessquest.endlessquest.Tower;
import javafx.util.Duration;



public class BlueSlime extends Enemy {

    private SpriteAnimation deathAnimation;
    private SpriteAnimation hurtAnimation;
    private SpriteAnimation idleAnimation;
    public BlueSlime() {
        name="slime";
        hp=50;
        mp=30;
        armor=3;
        agility=10;
        attack=8;
        deathAnimation = new SpriteAnimation("death", "/entity/enemy/BlueSlime/death.png", 200, Duration.millis(500), 14, 14, 0, 0, 96, 32, false, true);
        addSpriteAnimation(deathAnimation);
        hurtAnimation = new SpriteAnimation("hurt","/entity/enemy/BlueSlime/hurt.png", 200, Duration.millis(500), 11, 11, 0, 0, 96, 32, false, true);
        addSpriteAnimation(hurtAnimation);
        idleAnimation = new SpriteAnimation("idle","/entity/enemy/BlueSlime/idle.png", 200, Duration.millis(500), 7, 7, 0, 0, 96, 32, true, true);
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
        Tower.removeEnemy(this);
    }


}
