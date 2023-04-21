package com.morvencat.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame(){
        initJFrame();

        initJMenuBar();

        //显示窗口
        this.setVisible(true);
    }

    private void initJMenuBar() {
        //初始化菜单
        //创建菜单对象
        JMenuBar jmenubar = new JMenuBar();

        //创建菜单栏目对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于");

        //创建条目对象
        JMenuItem replayItem = new JMenuItem("重开");
        JMenuItem reLoginItem = new JMenuItem("重进");
        JMenuItem closeItem = new JMenuItem("退出");

        JMenuItem accountItem = new JMenuItem("关于我们");

        //把条目选项装到栏目里面
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        //把菜单栏目装到菜单里
        jmenubar.add(functionMenu);
        jmenubar.add(aboutMenu);

        this.setJMenuBar(jmenubar);
    }

    private void initJFrame() {
        //界面设置
        this.setSize(603,680);
        this.setTitle("测试 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
    }
}
