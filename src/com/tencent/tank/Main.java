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

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
