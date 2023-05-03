package com.morvencat.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //生成存储图片位置数据的二维数组
    //管理数据，加载图片用
    int[][] data = new int[4][4];

    //获胜条件
    int[][] win = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //记录空白数字在二维数组中的位置
    int x = 0;
    int y = 0;

    //定义图片路径变量
    String path = "image/animal/animal3/";


    //计步器
    int step = 0;

    //创建条目对象
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("关于");
    JMenuItem help = new JMenuItem("帮助");


    public GameJFrame() {
        //菜單初始化
        initJFrame();
        //功能欄初始化
        initJMenuBar();
        //数据初始化
        initData();
        //圖片初始化
        initImage();
        //显示窗口
        this.setVisible(true);
    }

    private void initData() {
        Random r = new Random();
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    //图片初始化
    private void initImage() {
        //清空容器已有图片
        this.getContentPane().removeAll();

        //判断是否胜利
        if(victory()){
            JLabel win = new JLabel(new ImageIcon("image/win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }

        //计数器
        JLabel stepCount = new JLabel("步数: " + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon(this.path + data[i][j] + ".jpg"));
                //指定圖片位置
                jLabel.setBounds(105 * j + 84, 105 * i + 135, 105, 105);
                //给图片加个边框对象
                //让图片凸起来
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到主界面
                this.getContentPane().add(jLabel);

            }
        }
        JLabel jLabel = new JLabel(new ImageIcon("image/background.png"));
        jLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabel);

        //刷新容器
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //初始化菜单
        //创建菜单对象
        JMenuBar jmenubar = new JMenuBar();

        //创建更换图片栏目
        //创建菜单栏目对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于");
        JMenu changeImage = new JMenu("更换图片");



        //把条目选项装到栏目里面
        functionMenu.add(changeImage);
        aboutMenu.add(accountItem);
        aboutMenu.add(help);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);



        changeImage.add(girl);
        changeImage.add(sport);
        changeImage.add(animal);


        //绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        help.addActionListener(this);


        //把菜单栏目装到菜单里
        jmenubar.add(functionMenu);
        jmenubar.add(aboutMenu);

        //
        this.setJMenuBar(jmenubar);
    }

    private void initJFrame() {
        //界面设置
        this.setSize(603, 680);
        this.setTitle("测试 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默認的居中放置
        this.setLayout(null);
        //给界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //判断游戏是否结束
        if(victory()){
            return;
        }
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(84, 135, 420, 420);
            this.getContentPane().add(all);
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否结束
        if(victory()){
            return;
        }
        //对上下左右进行判断
        //👈：37 | 👆：38 | 👉：39 | 👇：40
        int code = e.getKeyCode();
        System.out.println(code);
        int temp;
        if (code == 37) {
            //判断边界，在边界位置不运行
            if (y == 0) {
                return;
            }
            //y-1
            System.out.println("左");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 0) {
                return;
            }
            //x-1
            System.out.println("上");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 39) {
            if (y == 3) {
                return;
            }
            //y+1
            System.out.println("右");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 3) {
                return;
            }
            //x+1
            System.out.println("下");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();
        } else if (code == 65) {
            System.out.println("还原");
            initImage();
        } else if (code == 87) {
            System.out.println("作弊");
            data =new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
            };
            x = 3;
            y = 3;
            initImage();
        }
    }
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        Random r = new Random();
        int i = r.nextInt(1,10);
        if(obj == replayItem){
            System.out.println("重开");
            step = 0;
            initData();
            initImage();
        } else if (obj == closeItem) {
            System.out.println("关闭");
            System.exit(0);
        } else if (obj == reLoginItem) {
            System.out.println("重新登陆");
            this.setVisible(false);
            LoginJFrame loginJFrame = new LoginJFrame();
        } else if (obj == accountItem) {
            System.out.println("关于");
            JDialog jDialog =new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image/about.png"));
            jLabel.setBounds(0,0,344,344);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == help) {
            System.out.println("帮助");
            JDialog jDialog =new JDialog();

            JLabel helpJB = new JLabel("玩   法");
            helpJB.setBounds(15,20,300,20);
            JLabel fangxiangJB = new JLabel("方向键：控制空白方块移动");
            fangxiangJB.setBounds(15,50,300,20);
            JLabel aJB = new JLabel("A: 查看完整图片");
            aJB.setBounds(15,80,300,20);
            JLabel wJB = new JLabel("W: 作弊");
            wJB.setBounds(15,110,300,20);
            JLabel emp = new JLabel(" ");

            jDialog.getContentPane().add(helpJB);
            jDialog.getContentPane().add(fangxiangJB);
            jDialog.getContentPane().add(aJB);
            jDialog.getContentPane().add(wJB);
            jDialog.getContentPane().add(emp);


            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if(obj == girl){
            this.path = "image/girl/girl"+i+"/";
            step = 0;
            initData();
            initImage();
        }else if(obj == animal){
            this.path = "image/animal/animal"+i+"/";
            step = 0;
            initData();
            initImage();
        }else if(obj == sport){
            this.path = "image/sport/sport"+i+"/";
            step = 0;
            initData();
            initImage();
        }
    }
}
