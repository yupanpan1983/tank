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

        for(int i = 0;i<5;i++){
             tf.enemiesTank.add(new Tank((50 + 40*i),200,Dir.DOWN,tf));
        }

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
