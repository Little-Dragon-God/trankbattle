package com.xls.trankbattle;

import javax.swing.text.LabelView;
import javax.swing.tree.FixedHeightLayoutCache;
import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 3;
    private static final int WIDTH=30;
    private static final int HEIGHT=30;
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
        g.fillOval(x,y,WIDTH, HEIGHT);
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
