package com.xls.trankbattle;

import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    public static  int WIDTH = ResourMgr.bulletD.getWidth();
    public static  int HEIGHT = ResourMgr.bulletD.getHeight();
    private boolean live = true;
    private TFrame tf;
    public Bullet(int x, int y, Dir dir,TFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        //画子弹
        //g.fillOval(x,y,WIDTH, HEIGHT);
        //根据方向画坦克
        switch (dir){
            case LEFT:
                g.drawImage(ResourMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourMgr.bulletD,x,y,null);
                break;
        }
        //如果子弹不是存活状态就删除
        if (!live)
            tf.bullets.remove(this);
        move();
    }
    private void move() {
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
        //子弹飞出消失
        if (y > tf.getHeight() || y < 0 || x>tf.getWidth() || x<0){
            live = false;
        }
    }
}
