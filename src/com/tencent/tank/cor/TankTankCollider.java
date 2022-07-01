package com.tencent.tank.cor;

import com.tencent.tank.GameObject;
import com.tencent.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if(t1.getRect().intersects(t2.getRect())){
                    t1.stop();
//                    t2.stop();
            }
        }else{
            return;
        }

    }
}
