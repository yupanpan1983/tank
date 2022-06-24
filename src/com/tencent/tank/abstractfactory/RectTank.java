package com.tencent.tank.abstractfactory;

import com.tencent.tank.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @Auther: Yu Panpan
 * @Date: 2022/6/24 - 06 - 24 - 11:08
 * @Description: com.tencent.tank.abstractfactory
 * @version: 1.0
 */
public class RectTank extends BaseTank {

    int x,y;
    Dir dir;
    private static final int SPEED = 6;

    private boolean moving = true;
    private boolean living = true;

    private Random random = new Random();

    public static final int WIDTH = ResourceMgr.badTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.badTankU.getHeight();

    public TankFrame tf = null;

    FireStrategy fs = null;

    public RectTank(int x,int y,Dir dir,Group group,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if(this.group == Group.GOOD){
            String goodFS = (String)PropertyMgr.get("goodFS");

            //JDK1.9之后不推荐使用newInstance()
//                fs = (FourDirFireStrategy)Class.forName(goodFS).newInstance();
            try {
                fs = (FourDirFireStrategy)Class.forName(goodFS).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            fs = new DefaultFireStrategy();
        }
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    @Override
    public void paint(Graphics g){
        if(!living){
            tf.enemiesTank.remove(this);
        }

        Color c = g.getColor();
        g.setColor(this.group == Group.GOOD ? Color.GREEN : Color.yellow);
        g.fillRect(x,y,40,40);
        g.setColor(c);

        move();
    }

    public void move(){
        if(!moving) return;

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

        if(this.group == Group.BAD && random.nextInt(100) > 94){
            this.fire();
        }

        if(this.group == Group.BAD &&random.nextInt(100) > 94){
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 2) {
            x = 2;
        }
        if(this.y < 28){
            y = 28;
        }
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH -2){
            x = TankFrame.GAME_WIDTH- Tank.WIDTH -2;
        }
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ){
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT -2  ;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        for(Dir dir : Dir.values()){
//            new Bullet(bX,bY,dir,t.group,t.tf);
            this.tf.gf.createBullet(bX,bY,dir,this.group,this.tf);
        }

        if(this.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    public void die() {
        this.living = false;
    }
}
