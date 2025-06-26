import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TestFindJFrame extends JFrame implements ActionListener {
    JTextField findJTF = new JTextField();
    JButton findJBT = new JButton("查询");
    JButton titlefindJBT = new JButton("标题查询");
    JButton typefindJBT = new JButton("类型查询");
    JButton returnJBT = new JButton("返回");
    JButton returnStartJBT = new JButton("回到主界面");
    JButton returnfindJBT = new JButton("返回");
    JButton sure2JBT = new JButton("确定");
    JDialog clueDialog = new JDialog(this,"提示",true);
    JTextField clueJTF = new JTextField();
    String[] options = {"编号查询","标题查询","类型查询"};
    JComboBox<String> dropdown = new JComboBox<>(options);

    public TestFindJFrame() {
        initJFrame();
        initImage();
        initClueDialog();
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置界面宽高
        this.setSize(540,500);
        //设置界面的标题
        this.setTitle("查询媒体");
        //设置界面置顶
        //this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中放置
        this.setLayout(null);
    }

    private void initImage() {
        JLabel titleJLB = new JLabel(new ImageIcon("findJFramePng/媒体查询模式.png"));
        titleJLB.setBounds(138,0,250,55);
        this.getContentPane().add(titleJLB);


        dropdown.setBounds(280,150,100,35);
        dropdown.setFont(new Font("宋体-粗体", Font.BOLD, 18));
        dropdown.setOpaque(false);


        findJBT.setBounds(125,240,90,50);
        this.getContentPane().add(findJBT);
        //findJBT.setFocusable(false);
        findJBT.addActionListener(this);

        JLabel jLabel = new JLabel("请输入查询内容并选择查询模式：");
        jLabel.setBounds(90,35,400,200);
        jLabel.setFont(new Font("宋体-粗体", Font.BOLD, 23));

        returnJBT.setBounds(315,240,90,50);
        this.getContentPane().add(returnJBT);
        returnJBT.addActionListener(this);

        findJTF.setBounds(130,152,130,30);
        this.getContentPane().add(findJTF);

        this.getContentPane().add(jLabel);
        this.getContentPane().add(dropdown);

        JLabel bgJLB = new JLabel(new ImageIcon("addPng/addBackground.png"));
        bgJLB.setBounds(0,0,688,630);
        this.getContentPane().add(bgJLB);
    }







    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("按一次");
        Object source = e.getSource();
        OperateInformation operate = new DateBase();
        int Index = dropdown.getSelectedIndex();
        if (source == findJBT) {
            findJBT.requestFocusInWindow();
            findJBT.setEnabled(false);
            System.out.println("按了一次查询");
            //findJTF.setText("");
            switch (Index){
                case 0 -> {
                    if (findJTF.getText().isEmpty()) {
                        throwClue("请输入查询编号！");
                    }else if(!findJTF.getText().matches("\\d{1,9}")) {
                        throwClue("查询失败，编号格式错误！");
                    }else if (operate.idFindInfo(findJTF.getText()).getCode() == 0) {
                        JTextArea textArea = new JTextArea(10, 30);
                        textArea.append(operate.idFindInfo(findJTF.getText()).getDate().toString());
                        reStructJFrame(operate,textArea);
                        //System.out.println(operate.idFindInfo(Integer.parseInt(findJTF.getText())).getDate());
                    }else {
                        throwClue(operate.idFindInfo(findJTF.getText()).getMsg());
                    }
                }
                case 1 -> {
                    if (findJTF.getText().isEmpty()) {
                        throwClue("请输入查询标题！");
                    }else if (operate.titleFindInfo(findJTF.getText()).getCode() == 0) {
                        JTextArea textArea = new JTextArea(10, 30);
                        ArrayList <Information> list = (ArrayList<Information>) operate.titleFindInfo(findJTF.getText()).getDate();
                        for(Information info : list) {
                            textArea.append(info + "\n");
                        }
                        reStructJFrame(operate,textArea);
                        //System.out.println(operate.titleFindInfo(findJTF.getText()).getDate());
                    }else {
                        throwClue(operate.titleFindInfo(findJTF.getText()).getMsg());
                    }
                }
                case 2 -> {
                    if (findJTF.getText().isEmpty()) {
                        throwClue("请输入查询类型！");
                    }else {
                        String str = switch (findJTF.getText()){
                            case "图书" -> "book";
                            case "视频光盘" -> "vedio";
                            case "图画" -> "picture";
                            default -> "";
                        };
                        if (str.isEmpty()) {
                            throwClue("类型格式错误！");
                        }else if (operate.typeFindInfo(str).getCode() == 0) {
                            JTextArea textArea = new JTextArea(10, 30);
                            ArrayList <Information> list = (ArrayList<Information>) operate.typeFindInfo(str).getDate();
                            for(Information info : list) {
                                textArea.append(info + "\n");
                                //textArea.append(operate.typeFindInfo(findJTF.getText()).getDate().toString());
                                reStructJFrame(operate,textArea);
                                //System.out.println(operate.typeFindInfo(str).getDate());
                            }

                        }else {
                            throwClue(operate.typeFindInfo(str).getMsg());
                        }

                    }

                }

            }
        }else if (source == returnfindJBT) {
            this.getContentPane().removeAll();
            initJFrame();
            initImage();
            findJBT.setEnabled(true);
            findJTF.setText("");
        }/*else if(source == sure2JBT){
            *//*this.getContentPane().removeAll();
            initJFrame();
            initJFrame();*//*
            clueDialog.setVisible(false);
        }*/
    }

    private void reStructJFrame(OperateInformation operate,JTextArea textArea) {
        this.getContentPane().removeAll();
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(1040,700);
        this.setLocationRelativeTo(null);

        JLabel titleJLB = new JLabel(new ImageIcon("findJFramePng/媒体查询模式.png"));
        titleJLB.setBounds(370,0,250,55);
        this.getContentPane().add(titleJLB);

        JLabel findJLB = new JLabel(new ImageIcon("findJFramePng/为您查询到以下媒体.png"));
        findJLB.setBounds(50,58,115,30);
        this.getContentPane().add(findJLB);

        returnfindJBT.setBounds(580,570,150,50);
        this.getContentPane().add(returnfindJBT);
        returnfindJBT.addActionListener(this);

        returnStartJBT.setBounds(295,570,150,50);
        this.getContentPane().add(returnStartJBT);
        returnStartJBT.addActionListener(this);

        //JTextArea textArea = new JTextArea(10, 30);
        //textArea.append(operate.idFindInfo(Integer.parseInt(findJTF.getText())).getDate().toString());
        textArea.setEditable(false); // 设置为只读
        textArea.setFont(new Font("宋体-粗体", Font.BOLD, 20));
        textArea.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // 创建面板并添加组件
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        this.getContentPane().add(panel);
        this.revalidate(); // 重新计算布局
        this.repaint();    // 强制重绘界面
        panel.setBounds(90,85,850,450);

        JLabel bgJLB = new JLabel(new ImageIcon("findJFramePng/BG.png"));
        bgJLB.setBounds(0,0,1040,700);
        this.getContentPane().add(bgJLB);

        this.getContentPane().repaint();
    }

    private void throwClue(String str) {
        System.out.println("弹出一次");
        clueJTF.setText(str);
        //clueDialog.getContentPane().repaint();
        //clueDialog.setModal(true);
        //clueDialog.getRootPane().setDefaultButton(null);
        clueDialog.setVisible(true);
    }

    private void initClueDialog() {
        clueDialog.setSize(250,150);
        clueDialog.setTitle("提示");
        clueDialog.setLocationRelativeTo(null);
        clueDialog.setModal(true);
        clueDialog.setAlwaysOnTop(true);
        clueDialog.getContentPane().setLayout(null);
        sure2JBT.setBounds(90,60,60,30);
        sure2JBT.removeActionListener(this);
        sure2JBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sure2JBT.setEnabled(false);
                clueDialog.dispose();
                findJBT.setEnabled(true);
            }
        });
        clueDialog.getContentPane().add(sure2JBT);
        clueJTF = new JTextField();
        clueJTF.setBounds(50,30,150,30);
        clueDialog.add(clueJTF);

        // 新增：对话框关闭后的焦点恢复
        clueDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                findJTF.requestFocusInWindow();
                sure2JBT.setEnabled(true); // 恢复按钮状态
            }
        });
    }

}
