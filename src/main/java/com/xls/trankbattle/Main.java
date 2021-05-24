package com.xls.trankbattle;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TFrame f = new TFrame();
        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount")) ;
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            f.enemytanks.add(new Tank(50+i*80,100,Dir.DOWN,Group.BAD,f));
        }
        //让坦克一直动
        while (true){
            Thread.sleep(100);
            //每动一下就重新绘制
            f.repaint();
        }

    }
}
