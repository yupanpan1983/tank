package com.tencent.tank.cor;

import com.tencent.tank.Bullet;
import com.tencent.tank.Explode;
import com.tencent.tank.GameObject;
import com.tencent.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
                Bullet b = (Bullet) o1;
                Tank t = (Tank)o2;
            if(b.getGroup() == t.getGroup()){
                return;
            }

            if(b.getRect().intersects(t.getRect())){
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH/2 -Explode.WIDTH/2;
                int eY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                b.getGm().objects.add(new Explode(eX,eY,b.getGm()));
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
        }else{
            return;
        }
    }
}
