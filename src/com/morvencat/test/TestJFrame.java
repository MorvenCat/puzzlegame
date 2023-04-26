package com.morvencat.test;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestJFrame extends JFrame implements ActionListener, MouseListener, KeyListener {
    JButton jtb1 = new JButton("点我玩玩");
    JButton jtb2 = new JButton("不要点我");
    JButton jtb3 = new JButton("勉强能点");

    public TestJFrame(){
        //设置尺寸
        this.setSize(488,500);
        //设置标题
        this.setTitle("事件演示");
        //设置页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置
        this.setLayout(null);

        jtb1.setBounds(0,0,100,50);
        jtb2.setBounds(120,0,100,50);
        jtb3.setBounds(240,0,100,50);


        this.addKeyListener(this  );

        this.add(jtb1);
        jtb1.addActionListener(this);
        this.add(jtb2);
        jtb2.addActionListener(this);
        this.add(jtb3);
        jtb3.addMouseListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();
        Object source = e.getSource();
        if(source == jtb1 ){
            System.out.println("按钮被点击了");
        } else if (source==jtb2) {
            jtb2.setBounds(r.nextInt(400),r.nextInt(400),100,50);
            System.out.println("达咩，这里不能碰");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("按钮被点击了");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("放手啊魂淡~");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("你松开了按钮");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("欸欸欸你往哪走");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("唔~~");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("按下键盘");
    }
}
