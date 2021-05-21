package com.xls.trankbattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TFrame extends JFrame {
    int x = 200;
    int y = 200;

    //默认向下
    Dir dir = Dir.DOWN;

    private static final int SPEED = 10;

    //构造器
    public TFrame() {
        setTitle("坦克大战");
        setSize(800, 600);
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
        //画矩形
        g.fillRect(x, y, 50, 50);
        //x += 10;
        //y += 10;
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
            if (bU)
                dir = Dir.UP;
            if (bD)
                dir = Dir.DOWN;
            if (bL)
                dir = Dir.LEFT;
            if (bR)
                dir = Dir.RIGHT;
        }
    }
}
