import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddJFrame extends JFrame implements ActionListener {
    JButton addJBT = new JButton("下一步");
    JTextField addJTF = new JTextField();
    JButton returnJBT = new JButton("返回");
    JDialog clueDialog = new JDialog();
    JTextField clueJTF = new JTextField();
    JButton sureJBT = new JButton("确定");
    public AddJFrame() {
        initJFrame();
        initImage();
        this.setVisible(true);

    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("添加物品");
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
        JLabel addJLB = new JLabel(new ImageIcon("addJFramePng/添加物品类别输入提示.png"));
        addJLB.setBounds(116,0,250,250);
        this.getContentPane().add(addJLB);

        addJTF.setBounds(146,134,200,30);
        this.getContentPane().add(addJTF);

        JLabel addClueJLB = new JLabel(new ImageIcon("addJFramePng/添加物品类别输入样例 .png"));
        addClueJLB.setBounds(116,60,250,250);
        this.getContentPane().add(addClueJLB);

        addJBT.setBounds(96,250,90,40);
        this.getContentPane().add(addJBT);
        addJBT.addActionListener(this);

        returnJBT.setBounds(306,250,90,40);
        this.getContentPane().add(returnJBT);
        returnJBT.addActionListener(this);

        JLabel bgJLB = new JLabel(new ImageIcon("addPng/background.png"));
        bgJLB.setBounds(0,0,508,560);
        this.getContentPane().add(bgJLB);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addJBT) {
            String objectName = addJTF.getText();
            switch (objectName) {
                case "图书" :
                    this.setVisible(false);
                    new AddBookJFrame();
                    break;
                case "视频光盘" :
                    this.setVisible(false);
                    new VedioJFrame();
                    break;
                case "图画" :
                    this.setVisible(false);
                    new PictureJFrame();
                    break;
                default :
                    clueDialog.setSize(250,150);
                    clueDialog.setTitle("提示");
                    clueDialog.setLocationRelativeTo(null);
                    clueDialog.setModal(true);
                    clueDialog.setAlwaysOnTop(true);
                    clueDialog.getContentPane().setLayout(null);
                    clueDialog.getContentPane().removeAll();

                    clueJTF = new JTextField("您的输入有误，请重新输入");
                    clueJTF.setBounds(50,30,150,30);

                    sureJBT.setBounds(90,60,60,30);
                    sureJBT.addActionListener(this);

                    clueDialog.getContentPane().add(clueJTF);
                    clueDialog.getContentPane().add(sureJBT);
                    clueDialog.getContentPane().repaint();
                    clueDialog.setVisible(true);
            }
        }else if (source == sureJBT) {
            clueDialog.setVisible(false);
        }else  {
            this.setVisible(false);
        }
    }
}
