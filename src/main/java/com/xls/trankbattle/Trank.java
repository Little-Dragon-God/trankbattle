package com.xls.trankbattle;

import java.awt.*;

public class Trank {

    private int x,y;
    //默认向下
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    //处理坦克静止状态
    private  boolean moving = false;
    public Trank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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
        g.fillRect(x, y, 50, 50);

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
}
