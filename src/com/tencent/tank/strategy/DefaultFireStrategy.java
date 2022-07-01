package com.tencent.tank.strategy;

import com.tencent.tank.Audio;
import com.tencent.tank.Bullet;
import com.tencent.tank.Group;
import com.tencent.tank.Tank;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/15 - 06 - 15 - 9:13
 * @Description: com.tencent.tank
 * @version: 1.0
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX,bY,t.dir,t.group,t.gm);

        if(t.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
