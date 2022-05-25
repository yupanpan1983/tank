package com.tencent.tank;

import java.awt.*;

public class Explode {

    private int x,y;

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private boolean living = true;
    private static int step = 0;

    TankFrame tf = null;

    public Explode(int x, int y,TankFrame tf){
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],this.x,this.y,null);

        if(step >= ResourceMgr.explodes.length){
            step = 0;
        }

    }

}
