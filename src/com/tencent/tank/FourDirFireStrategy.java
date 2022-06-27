package com.tencent.tank;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/15 - 06 - 15 - 9:14
 * @Description: com.tencent.tank
 * @version: 1.0
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        for(Dir dir : Dir.values()){
            new Bullet(bX,bY,dir,t.group,t.tf);
        }

        if(t.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
