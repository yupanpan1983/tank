package com.tencent.tank;

import com.tencent.tank.abstractfactory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {

    private int x,y;

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

//    private boolean living = true;
    private static int step = 0;

    TankFrame tf = null;

    public Explode(int x, int y,TankFrame tf){
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],this.x,this.y,null);

        if(step >= ResourceMgr.explodes.length){
            step = 0;
            tf.explodes.remove(this);
        }

    }

}
