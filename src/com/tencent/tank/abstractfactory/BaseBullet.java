package com.tencent.tank.abstractfactory;

import com.tencent.tank.Tank;

import java.awt.*;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 9:10
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public abstract class BaseBullet {

    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
