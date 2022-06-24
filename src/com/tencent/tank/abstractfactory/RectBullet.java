package com.tencent.tank.abstractfactory;

import com.tencent.tank.*;

import java.awt.*;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 10:24
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public class RectBullet extends BaseBullet {


    private int x,y;
    private static final int SPEED = 15;
    private Dir dir;

    public static final int WIDTH = ResourceMgr.bulletL.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletL.getHeight();

    private boolean living = true;

    TankFrame tf = null;
    private Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public RectBullet(int x,int y,Dir dir,Group group,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,15,15);
        g.setColor(c);

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


    public void collideWith(BaseTank tank) {
        if(this.group == tank.getGroup()){
            return;
        }

        if(rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(tf.gf.createExplode(eX,eY,tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
