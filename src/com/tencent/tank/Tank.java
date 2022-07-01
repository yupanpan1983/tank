package com.tencent.tank;

import com.tencent.tank.strategy.DefaultFireStrategy;
import com.tencent.tank.strategy.FireStrategy;
import com.tencent.tank.strategy.FourDirFireStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Tank extends GameObject {

    public static final int WIDTH = ResourceMgr.badTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.badTankU.getHeight();
    private static final int SPEED = 6;
    public int x, y;
    //public int preX,preY;

    public Dir dir;
    public Group group = Group.BAD;
    public GameModel gm;
    Rectangle rect = new Rectangle();
    FireStrategy fs = null;
    private boolean moving = true;
    private boolean living = true;
    private Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (this.group == Group.GOOD) {
            String goodFS = (String) PropertyMgr.get("goodFS");

            //JDK1.9之后不推荐使用newInstance()
//                fs = (FourDirFireStrategy)Class.forName(goodFS).newInstance();
            try {
                fs = (FourDirFireStrategy) Class.forName(goodFS).getDeclaredConstructor().newInstance();
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
        } else {
            fs = new DefaultFireStrategy();
        }
    }

    public Rectangle getRect() {
        return rect;
    }

    public Group getGroup() {
        return group;
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
    public void paint(Graphics g) {
        if (!living) {
            gm.objects.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankL : ResourceMgr.goodTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankU : ResourceMgr.goodTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankR : ResourceMgr.goodTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankD : ResourceMgr.goodTankD, x, y, null);
                break;
        }

        move();
    }

    public void move() {
        // preX = x;
        // preY = y;

        if (!moving) return;

        switch (dir) {
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

        if (this.group == Group.BAD && random.nextInt(100) > 94) {
            this.fire();
        }

        if (this.group == Group.BAD && random.nextInt(100) > 94) {
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public void fire() {
        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public void stop(){
        this.moving = false;
    }
}
