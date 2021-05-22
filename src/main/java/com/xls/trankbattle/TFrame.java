package com.xls.trankbattle;

import javax.lang.model.element.VariableElement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TFrame extends JFrame {

    Trank myTrank = new Trank(200,200,Dir.DOWN,this);
    Bullet bullet = new Bullet(200,200,Dir.RIGHT);
    public static final int GAME_WIDTH=800,GAME_HEIGHT=600;

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



    //画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myTrank.paint(g);//画坦克
        bullet.paint(g);//画子弹

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
                myTrank.fire();
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
                myTrank.setMoving(false);
            else {
                //告诉坦克可以移动
                myTrank.setMoving(true);
            if (bU)
                myTrank.setDir(Dir.UP);
            if (bD)
                myTrank.setDir(Dir.DOWN);
            if (bL)
                myTrank.setDir(Dir.LEFT);
            if (bR)
                myTrank.setDir(Dir.RIGHT);
            }
        }
    }
}
