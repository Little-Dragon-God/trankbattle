package com.xls.trankbattle;

import java.awt.*;

public class Trank {

    private int x,y;
    //默认向下
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    public static  int WIDTH = ResourMgr.tankL.getWidth();
    public static  int HEIGHT = ResourMgr.tankL.getHeight();
    //处理坦克静止状态
    private  boolean moving = false;
    private TFrame tf;
    public Trank(int x, int y, Dir dir,TFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
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
        //开火发射子弹的位置：坦克位置+坦克图片的一半-子弹的一半
        int bX = this.x + Trank.WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y + Trank.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY,this.dir,this.tf));
    }
}
