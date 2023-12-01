package com.endlessquest.endlessquest.entity;

import com.endlessquest.endlessquest.SpriteAnimation;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    // ajout list static enemies & heroes

    protected String name;

    protected int hp;
    protected int maxhp;

    protected int mp;
    protected int maxmp;

    protected int armor;

    protected int agility;

    protected int attack;
    protected double startX = 0;
    protected double startY = 0;

    protected double curX = 0;
    protected double curY = 0;


    protected List<SpriteAnimation> spriteAnimations = new ArrayList<>();

    public List<SpriteAnimation> getSpriteAnimations() {
        return spriteAnimations;
    }


    public void addSpriteAnimation(SpriteAnimation spriteAnimation){
        this.spriteAnimations.add(spriteAnimation);
    }


    public Entity(){};

    public void setStartPos(double x, double y) {
        this.startX = x;
        this.startY = y;
        this.curX = x;
        this.curY = y;
        updatePosAnimation();
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getCurX() {
        return curX;
    }

    public double getCurY() {
        return curY;
    }

    public Entity(String name, int maxhp, int maxmp, int armor, int agility, int attack){
        this.name = name;
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.maxmp = maxhp;
        this.mp = maxmp;
        this.armor = armor;
        this.agility = agility;
        this.attack = attack;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxhp(){
        return maxhp;
    }

    public int getMp(){
        return mp;
    }

    public int getMaxmp(){
        return maxmp;
    }

    public int getArmor(){
        return armor;
    }

    public int getAgility(){
        return agility;
    }

    public int getAttack(){
        return attack;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public void setMp(int mp){
        this.mp = mp;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }

    public void updatePosAnimation(){
        for (SpriteAnimation spriteAnimation : getSpriteAnimations()) {
            spriteAnimation.getImageView().setTranslateX(curX);
            spriteAnimation.getImageView().setTranslateY(curY);
        }
    }

    public void updateAnimation(String animation) {
        updatePosAnimation();
        for (SpriteAnimation spriteAnimation : getSpriteAnimations()) {
            if (spriteAnimation.getName() == animation){
                spriteAnimation.getImageView().setVisible(true);
                if (spriteAnimation.isRepeat()){
                    spriteAnimation.playContinuous();
                }else {
                    spriteAnimation.playOnce();
                }
            }else {
                spriteAnimation.getImageView().setVisible(false);
            }
        }
    }
}
