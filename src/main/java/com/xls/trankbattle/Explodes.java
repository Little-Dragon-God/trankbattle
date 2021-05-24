package com.xls.trankbattle;

import java.awt.*;

public class Explodes {
    public static int WIDTH = ResourMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourMgr.explodes[0].getHeight();
    private int x,y;
    private boolean living = true;
    TFrame tf = null;
    //当前数组第几步
    private int step = 0;

    public Explodes(int x, int y, TFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourMgr.explodes[step++],x,y,null);
        if (step >= ResourMgr.explodes.length)
            step=0;

    }
}
