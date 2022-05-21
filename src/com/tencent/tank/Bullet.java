package com.tencent.tank;

import java.awt.*;

public class Bullet {

    private int x,y;
    private static final int SPEED = 1;
    private Dir dir;
    static final int WIDTH = 30,HEIGHT = 30;

    public Bullet(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

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
