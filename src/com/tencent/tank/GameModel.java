package com.tencent.tank;

import com.tencent.tank.cor.BulletTankCollider;
import com.tencent.tank.cor.Collider;
import com.tencent.tank.cor.ColliderChain;
import com.tencent.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);

    public List<GameObject> objects = new ArrayList<>();

//    Collider collider1 = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();

    ColliderChain chain = new ColliderChain();

    public GameModel(){
        int initTankCount = Integer.valueOf((String)PropertyMgr.get("initTankCount"));

        for(int i = 0;i<initTankCount;i++){
            objects.add(new Tank((50 + 80*i),200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g){
        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size() ; j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
//                o1.collideWith(o2);
                //comparator.compara(o1,o2)
//                collider1.collide(o1,o2);
//                collider2.collide(o1,o2);
                chain.collide(o1,o2);
            }
        }
    }

    public Tank getMainTank(){
        return myTank;
    }



}
