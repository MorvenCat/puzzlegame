package com.morvencat.ui;

import com.morvencat.ui.Util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements ActionListener, MouseListener {
    //创建一个集合存储正确的用户名与密码
    static ArrayList<User> list = new ArrayList<User>();
    static {
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }
    private final JButton register = new JButton();
    private final JButton login = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    public LoginJFrame() throws HeadlessException {
        //初始化界面
        initJFrame();
        //在界面中添加内容
        initView();

        
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image/login/密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("image/login/验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        String codeStr = CodeUtil.getCode();
        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮

        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        //按钮增加事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        //增加监听事件
        register.addMouseListener(this);

        this.getContentPane().add(register);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    public void initJFrame() {
        this.setSize(488,430);
        this.setTitle("测试 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        if (obj == login){
            String un = username.getText();
            String pw = password.getText();
            String cd = code.getText();

            if (un.equals("") || pw.equals("")){
                showJDialog("用户名和密码不能为空");
            }
            if (login(un,pw)){
                this.setVisible(false);
                GameJFrame game = new GameJFrame();
            }else {
                showJDialog("用户名或密码错误");
            }


        } else if ( obj == register) {
            System.out.println("注册");
        }
    }

    private boolean login(String un, String pw) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(u.getUsername().equals(un)&&u.getPassword().equals(pw)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        if (obj == login){
            this.login.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if ( obj == register) {
            this.register.setIcon(new ImageIcon("image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        if (obj == login){
            this.login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if ( obj == register) {
            this.register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        if (obj == login){

        } else if ( obj == register) {

        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Object obj = mouseEvent.getSource();
        if (obj == login){

        } else if ( obj == register) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();
        if (obj == login){

        } else if ( obj == register) {

        }
    }
}
