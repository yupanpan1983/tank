package com.tencent.tank;

import java.awt.*;

public class Explode extends GameObject {

    private int x,y;

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

//    private boolean living = true;
    private static int step = 0;

    GameModel gm;

    public Explode(int x, int y,GameModel gm){
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],this.x,this.y,null);

        if(step >= ResourceMgr.explodes.length){
            step = 0;
            gm.objects.remove(this);
        }

    }

}
