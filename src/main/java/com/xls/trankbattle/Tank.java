package com.xls.trankbattle;

import java.awt.*;
import java.util.Random;

public class Tank {

    private int x,y;
    //默认向下
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 3;
    public static  int WIDTH = ResourMgr.tankL.getWidth();
    public static  int HEIGHT = ResourMgr.tankL.getHeight();
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
                g.drawImage(ResourMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourMgr.tankD,x,y,null);
                break;
        }
        //坦克自动发射子弹
        if (random.nextInt(10)>8)
            this.fire();
        moving();
    }

    private void moving() {
        if (!moving) return;//坦克静止
        //根据方向进行移动
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
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
