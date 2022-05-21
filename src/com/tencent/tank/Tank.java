package com.tencent.tank;

import java.awt.*;

public class Tank {

    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;

    public Tank(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,50,50);

        move();
    }

    public void move(){
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


}
