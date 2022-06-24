package com.tencent.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author YuPanpan
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.valueOf((String)PropertyMgr.get("initTankCount"));

        for(int i = 0;i<initTankCount;i++){
            tf.enemiesTank.add(tf.gf.createTank((50 + 80*i),200,Dir.DOWN,Group.BAD,tf));
        }
        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
