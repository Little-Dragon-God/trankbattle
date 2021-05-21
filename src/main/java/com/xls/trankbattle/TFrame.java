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
    //构造器
    public TFrame(){
        setTitle("坦克大战");
        setSize(800,600);
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
        g.fillRect(x,y,50,50);
          x += 10;
//        y += 10;

    }
    //键盘监听内部类
    class MyKeyListener extends KeyAdapter{
        //按下有效
        @Override
        public void keyPressed(KeyEvent e) {
            x += 200;

        }

        //键盘抬起有效
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
