package com.xls.trankbattle;

import java.awt.*;
import java.util.Random;

public class Tank {

    private int x,y;
    //默认向下
    private Dir dir = Dir.DOWN;
    private static int speed = 5;
    public static  int WIDTH = ResourMgr.goodTankL.getWidth();
    public static  int HEIGHT = ResourMgr.goodTankL.getHeight();
    //处理坦克移动状态
    private  boolean moving = true;
    private  boolean living = true;//存活状态
    private Random random = new Random();
    //区分子弹是谁的
    private Group group = Group.BAD;
    private TFrame tf;
    public Tank(int x, int y, Dir dir,Group group, TFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
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

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Tank.speed = speed;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        //画矩形
        //g.fillRect(x, y, 50, 50);
        if (!living)
            //不画死亡状态
            tf.enemytanks.remove(this);
        //根据方向画坦克
        switch (dir){
            case LEFT:
                g.drawImage(this.group==Group.BAD ? ResourMgr.badTankL :ResourMgr.goodTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.BAD ? ResourMgr.badTankR :ResourMgr.goodTankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.BAD ? ResourMgr.badTankU :ResourMgr.goodTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.BAD ? ResourMgr.badTankD :ResourMgr.goodTankD,x,y,null);
                break;
        }
        //敌方坦克自动发射子弹
        if (this.group == Group.BAD && random.nextInt(100)>85)
            this.fire();
        //敌方坦克随机旋转
        if (this.group == Group.BAD && random.nextInt(100)>70)
            randomDir();
        //碰撞检测
        boundsCheck();
        moving();
    }

    private void boundsCheck() {
        if (this.x<3) x=3;
        if (this.y<30) y=30;
        if (this.x>TFrame.GAME_WIDTH - Tank.WIDTH-2) x = TFrame.GAME_WIDTH - Tank.WIDTH-2;
        if (this.y>TFrame.GAME_HEIGHT - Tank.HEIGHT-2) y = TFrame.GAME_HEIGHT - Tank.HEIGHT-2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    private void moving() {
        if (!moving) return;//坦克静止
        //根据方向进行移动
        switch (dir) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;

        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2-Bullet.HEIGHT/2+5;
        tf.bullets.add(new Bullet(bX,bY,this.dir,group,this.tf));
    }

    public void die() {
        this.living = false;
    }
}
