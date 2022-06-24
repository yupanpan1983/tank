package com.tencent.tank.abstractfactory;

import com.tencent.tank.Dir;
import com.tencent.tank.Group;
import com.tencent.tank.TankFrame;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 9:05
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x,int y,TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

}
