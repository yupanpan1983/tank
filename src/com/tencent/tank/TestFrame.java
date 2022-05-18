package com.tencent.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author YuPanpan
 * @version 1.0
 */

public class TestFrame {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setTitle("tank war");
        f.setSize(800,600);
        f.setResizable(false);
        f.setVisible(true);


        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
