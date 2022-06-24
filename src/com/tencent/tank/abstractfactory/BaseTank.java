package com.tencent.tank.abstractfactory;

import com.tencent.tank.Group;

import java.awt.*;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 9:10
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public abstract class BaseTank {
    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup(){
        return this.group;
    }

    public abstract void die();


    public abstract int getX();


    public abstract int getY();
}
