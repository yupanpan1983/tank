package com.tencent.tank.abstractfactory;

import com.tencent.tank.Dir;
import com.tencent.tank.Group;
import com.tencent.tank.TankFrame;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 9:23
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }
}
