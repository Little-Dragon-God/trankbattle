package com.xls.trankbattle;

import java.awt.*;

public class Tank {



    private int x,y;
    //默认向下
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    public static  int WIDTH = ResourMgr.tankL.getWidth();
    public static  int HEIGHT = ResourMgr.tankL.getHeight();
    //处理坦克静止状态
    private  boolean moving = false;
    private  boolean living = true;
    private TFrame tf;
    public Tank(int x, int y, Dir dir, TFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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
        tf.bullets.add(new Bullet(bX,bY,this.dir,this.tf));
    }

    public void die() {
        this.living = false;
    }
}
