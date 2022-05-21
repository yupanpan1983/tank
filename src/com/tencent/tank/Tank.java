package com.tencent.tank;

import java.awt.*;

public class Tank {

    private int x,y;
    private Dir dir;
    private static final int SPEED = 5;

    private boolean moving = false;

    TankFrame tf = null;

    public Tank(int x,int y,Dir dir,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x,y,50,50);
        g.setColor(c);

        move();
    }

    public void move(){
        if(!moving) return;

        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }


    public void fire() {
        tf.b = new Bullet(this.x,this.y,this.dir);
    }
}
