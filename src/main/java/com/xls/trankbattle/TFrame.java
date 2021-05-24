package com.xls.trankbattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TFrame extends JFrame {

    Tank myTank = new Tank(200,200,Dir.DOWN,Group.GOOD,this);
    ArrayList<Bullet> bullets =  new ArrayList<Bullet>();
    //敌方坦克
    ArrayList<Tank> enemytanks = new ArrayList<Tank>();
    public static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    Explodes e = new Explodes(100,300,this);
    //构造器
    public TFrame() {
        setTitle("坦克大战");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //窗口不可改变大小
        setResizable(false);
        //窗口可见
        setVisible(true);
        //添加键盘监听事件
        this.addKeyListener(new MyKeyListener());
        //关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    //消除图片闪烁
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    //画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myTank.paint(g);//画主坦克
        //敌方坦克
        for (int i = 0; i < enemytanks.size(); i++) {
            enemytanks.get(i).paint(g);
        }
        //画子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //子弹和敌方坦克碰撞
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemytanks.size(); j++) {
                bullets.get(i).collideWith(enemytanks.get(j));
            }
        }
        e.paint(g);//画爆炸
        g.drawString("子弹个数"+bullets.size(),50,60);
        g.drawString("敌方坦克数量"+enemytanks.size(),50,80);

    }

    //键盘监听内部类
    class MyKeyListener extends KeyAdapter {
        //坦克朝向
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        //按下有效
        @Override
        public void keyPressed(KeyEvent e) {
            //控制方向，默认不开启方向,按下开启
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
            //坦克开火发射子弹
                case KeyEvent.VK_CONTROL:
                myTank.fire();
                break;
            }
            //坦克按下改方向
            setMainTrankDir();
        }

        //键盘抬起有效
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            //控制方向，默认不开启方向,按下开启
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
            }
            setMainTrankDir();
        }

        //键盘按下改方向方法
        private void setMainTrankDir() {
            //坦克静止
            if (!bR&&!bL&&!bD&&!bU)
                myTank.setMoving(false);
            else {
                //告诉坦克可以移动
                myTank.setMoving(true);
            if (bU)
                myTank.setDir(Dir.UP);
            if (bD)
                myTank.setDir(Dir.DOWN);
            if (bL)
                myTank.setDir(Dir.LEFT);
            if (bR)
                myTank.setDir(Dir.RIGHT);
            }
        }
    }
}
