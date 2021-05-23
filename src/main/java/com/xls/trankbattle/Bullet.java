package com.xls.trankbattle;

import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    public static  int WIDTH = ResourMgr.bulletD.getWidth();
    public static  int HEIGHT = ResourMgr.bulletD.getHeight();
    private boolean living = true;
    private Group group = Group.BAD;
    private TFrame tf;
    public Bullet(int x, int y, Dir dir,Group group,TFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        //g.setColor(Color.RED);
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
        if (!living)
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
            living = false;
        }
    }
    //子弹和敌方坦克碰撞方法
    public void collideWith(Tank tank) {
        //队友射中无效
        if (this.group == tank.getGroup()) return;
        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);//子弹矩形
        Rectangle rectangle2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        //两个矩形相交
        if (rectangle1.intersects(rectangle2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
