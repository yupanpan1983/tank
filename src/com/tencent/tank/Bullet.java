package com.tencent.tank;

import java.awt.*;

public class Bullet {

    private int x,y;
    private static final int SPEED = 15;
    private Dir dir;

    public static final int WIDTH = ResourceMgr.bulletL.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletL.getHeight();

    private boolean living = true;

    private Group group = Group.BAD;

    Rectangle rect = new Rectangle();

    GameModel gm;

    public Bullet(int x,int y,Dir dir,Group group,GameModel gm){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.bullets.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if(!living){
            gm.bullets.remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();
    }

    public void move(){
        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            living = false;
        }
    }


    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()){
            return;
        }

        if(rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 -Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gm.explodes.add(new Explode(eX,eY,gm));
        }
    }

    private void die() {
        this.living = false;
    }
}
