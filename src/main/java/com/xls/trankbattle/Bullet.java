package com.xls.trankbattle;

import javax.swing.tree.FixedHeightLayoutCache;
import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 3;
    private static final int WIDTH=10;
    private static final int HEIGHT=10;
    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        //画子弹
        g.fillOval(x,y,WIDTH, HEIGHT);
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
    }
}
