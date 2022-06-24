package com.tencent.tank.abstractfactory;

import com.tencent.tank.Audio;
import com.tencent.tank.ResourceMgr;
import com.tencent.tank.TankFrame;

import java.awt.*;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 9:22
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public class RectExplode extends BaseExplode {
    private int x,y;

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    //    private boolean living = true;
    private static int step = 0;

    TankFrame tf = null;

    public RectExplode(int x, int y,TankFrame tf){
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){

//        g.drawImage(ResourceMgr.explodes[step++],this.x,this.y,null);
        Color c = g.getColor();
        g.setColor(Color.blue);
        g.fillRect(x,y,step * 10, step * 10);
        step++;

        if(step >= 15){
            step = 0;
            tf.explodes.remove(this);
        }
        g.setColor(c);

    }
}
