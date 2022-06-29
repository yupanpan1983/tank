package com.tencent.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enemiesTank = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel(){
        int initTankCount = Integer.valueOf((String)PropertyMgr.get("initTankCount"));

        for(int i = 0;i<initTankCount;i++){
            enemiesTank.add(new Tank((50 + 80*i),200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g){
        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for(int i = 0;i <enemiesTank.size();i++){
            enemiesTank.get(i).paint(g);
        }

        for(int i = 0;i <explodes.size();i++){
            explodes.get(i).paint(g);
        }

        for(int i = 0; i<bullets.size();i++){
            for(int j = 0;j<enemiesTank.size();j++){
                bullets.get(i).collideWith(enemiesTank.get(j));
            }
        }

    }

    public Tank getMainTank(){
        return myTank;
    }



}
