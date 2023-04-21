package com.morvencat.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame(){
        //菜單初始化
        initJFrame();
        //功能欄初始化
        initJMenuBar();
        //圖片初始化
        initImage();
        //显示窗口
        this.setVisible(true);
    }

    private void initImage() {
        int number = 1;
        for (int i = 0 ; i < 4 ; i ++) {
            for (int j =0 ; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal3/"+number+".jpg"));
                //指定圖片位置
                jLabel.setBounds(105*j,105*i,105,105);
                //把管理容器添加到主界面
                this.getContentPane().add(jLabel);
                number++;
            }
        }
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

        //
        this.setJMenuBar(jmenubar);
    }

    private void initJFrame() {
        //界面设置
        this.setSize(603,680);
        this.setTitle("测试 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默認的居中放置
        this.setLayout(null);
    }
}
