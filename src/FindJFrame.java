import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindJFrame extends JFrame implements ActionListener {
    JTextField findJTF = new JTextField();
    JButton idfindJBT = new JButton("编号查询");
    JButton titlefindJBT = new JButton("标题查询");
    JButton typefindJBT = new JButton("类型查询");
    JButton returnJBT = new JButton("返回");
    JButton returnStartJBT = new JButton("回到主界面");
    JButton returnfindJBT = new JButton("返回");
    JButton sure2JBT = new JButton("确定");
    JDialog clueDialog = new JDialog();
    JTextField clueJTF = new JTextField();

    public FindJFrame() {
        initJFrame();
        initImage();
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

        JLabel title2JLB = new JLabel(new ImageIcon("findJFramePng/输入提示.png"));
        title2JLB.setBounds(150,120,230,35);
        this.getContentPane().add(title2JLB);

        idfindJBT.setBounds(125,240,90,50);
        this.getContentPane().add(idfindJBT);
        idfindJBT.addActionListener(this);

        titlefindJBT.setBounds(315,240,90,50);
        this.getContentPane().add(titlefindJBT);
        titlefindJBT.addActionListener(this);

        typefindJBT.setBounds(125,310,90,50);
        this.getContentPane().add(typefindJBT);
        typefindJBT.addActionListener(this);

        returnJBT.setBounds(315,310,90,50);
        this.getContentPane().add(returnJBT);
        returnJBT.addActionListener(this);

        findJTF.setBounds(150,160,230,25);
        this.getContentPane().add(findJTF);


        JLabel bgJLB = new JLabel(new ImageIcon("addPng/addBackground.png"));
        bgJLB.setBounds(0,0,688,630);
        this.getContentPane().add(bgJLB);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        OperateInformation operate = new DateBase();
        if (source == idfindJBT) {
            if (findJTF.getText().isEmpty()) {
                throwClue("请输入查询编号！");
            }else if(!findJTF.getText().matches("\\d{1,9}")) {
                throwClue("查询失败，id格式错误！");
            }else if (operate.idFindInfo(findJTF.getText()).getCode() == 0) {
                JTextArea textArea = new JTextArea(10, 30);
                textArea.append(operate.idFindInfo(findJTF.getText()).getDate().toString());
                reStructJFrame(operate,textArea);
                //System.out.println(operate.idFindInfo(Integer.parseInt(findJTF.getText())).getDate());
            }else {
                throwClue(operate.idFindInfo(findJTF.getText()).getMsg());
            }
        }else if (source == titlefindJBT) {
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
        }else if(source == typefindJBT){
            if (findJTF.getText().isEmpty()) {
                throwClue("请输入查询类型！");
            }
            String str = switch (findJTF.getText()){
                case "图书" -> "book";
                case "视频光盘" -> "vedio";
                case "图画" -> "picture";
                default -> "";
            };
            if (operate.typeFindInfo(str).getCode() == 0) {
                JTextArea textArea = new JTextArea(10, 30);

                if (str.isEmpty()) {
                    throwClue("类型格式错误！");
                }else {
                    ArrayList <Information> list = (ArrayList<Information>) operate.typeFindInfo(str).getDate();
                    for(Information info : list) {
                        textArea.append(info + "\n");
                    }
                    //textArea.append(operate.typeFindInfo(findJTF.getText()).getDate().toString());
                    reStructJFrame(operate,textArea);
                    //System.out.println(operate.typeFindInfo(str).getDate());
                }

            }else {
                throwClue(operate.typeFindInfo(str).getMsg());
            }
        }else if (source == returnfindJBT) {
            this.getContentPane().removeAll();
            initJFrame();
            initImage();
            findJTF.setText("");
        }else {
            clueDialog.setVisible(false);
        }
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

        clueDialog.setSize(250,150);
        clueDialog.setTitle("提示");
        clueDialog.setLocationRelativeTo(null);
        clueDialog.setModal(true);
        clueDialog.setAlwaysOnTop(true);
        clueDialog.getContentPane().setLayout(null);
        clueDialog.getContentPane().removeAll();

        clueJTF = new JTextField(str);
        clueJTF.setBounds(50,30,150,30);

        sure2JBT.setBounds(90,60,60,30);
        sure2JBT.addActionListener(this);

        clueDialog.getContentPane().add(clueJTF);
        clueDialog.getContentPane().add(sure2JBT);
        clueDialog.getContentPane().repaint();
        clueDialog.setVisible(true);
    }
}
