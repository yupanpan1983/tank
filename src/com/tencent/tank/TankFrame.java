package com.tencent.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author YuPanpan
 * @version 1.0
 */
public class TankFrame extends Frame {

    int x = 200,y=200;

    public TankFrame(){
        setTitle("tank war");
        setSize(800,600);
        setResizable(false);
        setVisible(true);

        this.addKeyListener(new MyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        g.fillRect(x,y,50,50);
        x += 50;
//        y += 50;
    }

    class MyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("pressed");
//              x += 50;
//              repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("released");
        }
    }
}
