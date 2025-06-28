import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Jun 28 16:53:12 CST 2025
 */



/**
 * @author fengzi
 */
public class AddInfoJFrame extends JFrame {
    public AddInfoJFrame() {
        initComponents();
        this.setVisible(true);
    }

    private void throwClue(String str) {
        new ClueDialog(this,str);
    }
    private void initLabalofBooks() {
        label7.setText("出版社：");
        label8.setText("ISBN号：");
        label6.setText("页数：");
    }

    private void initLabalofVedio() {
        label7.setText("出品者：");
        label8.setText("出品年份：");
        label6.setText("视频时长：");
    }

    private void initLabalofPicture() {
        label7.setText("出品国籍：");
        label8.setText("作品的长：");
        label6.setText("作品的宽：");
    }
    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label10 = new JLabel();
        textField8 = new JTextField();
        label11 = new JLabel();
        label12 = new JLabel();
        textField9 = new JTextField();
        textField10 = new JTextField();
        label13 = new JLabel();
        label14 = new JLabel();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField10.getText();
                String title = textField9.getText();
                String author = textField3.getText();
                String grade = textField4.getText();
                String type = textField8.getText();
                String publishHouse = textField6.getText();
                String ISBN = textField7.getText();
                String pageNumber = textField5.getText();
                if (id.isEmpty() || title.isEmpty() || author.isEmpty() ||
                        grade.isEmpty() || type.isEmpty() || publishHouse.isEmpty()||
                        ISBN.isEmpty() || pageNumber.isEmpty()){
                    throwClue("请将信息填写完整！");
                }else if (!(label11.getText().equals("") && label12.getText().equals("")
                && label13.getText().equals("") && label14.getText().equals(""))){
                    throwClue("信息格式有误！");
                }else {
                    OperateInformation operate = new DateBase();
                    Result result = operate.addInfo(id,title,author,grade,publishHouse,ISBN,pageNumber,type);
                    if (result.getCode() == 0) {
                        throwClue("添加成功！");
                        textField10.setText("");
                        textField9.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField8.setText("");
                        textField6.setText("");
                        textField7.setText("");
                        textField5.setText("");
                    }else {
                        throwClue(result.getMsg());
                    }
                }

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartJFrame();
            }
        });
        textField5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("监视短");
                if(label6.getText().equals("作品的宽：") && !textField5.getText().isEmpty() && !textField5.getText().matches("\\d{1,}")){
                    label14.setText("作品的宽只能为整数! （cm）");
                }else {
                    label14.setText("");
                }
            }
        });

        textField7.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("监视长");
                if(label8.getText().equals("作品的长：") && !textField7.getText().isEmpty() && !textField7.getText().matches("\\d{1,}")){
                    label13.setText("作品的长只能为整数! （cm）");
                }else {
                    label13.setText("");
                }
            }
        });

        textField10.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!textField10.getText().matches("\\d{1,9}") && !textField10.getText().isEmpty()){
                    label12.setText("\u7f16\u53f7\u683c\u5f0f\u9519\u8bef!\uff08\u4ec5\u652f\u63011-9\u4f4d\u6570\u5b57\uff09");
                }else {
                    label12.setText("");
                }
            }
        });

        textField8.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                String str = textField8.getText();
                label11.setText("");
                switch (str) {
                    case "" -> label11.setText("");
                    case "图书" -> initLabalofBooks();
                    case "视频光盘" -> initLabalofVedio();
                    case "图画" -> initLabalofPicture();
                    default -> label11.setText("暂不支持此类型！(目前仅支持 图书/图画/视频光盘 )");
                }
            }
        });


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u65b0\u589e\u5a92\u4f53");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 20f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(240, 0), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u7f16\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 7f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 105), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u6807\u9898\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 7f));
        contentPane.add(label3);
        label3.setBounds(120, 155, 75, 27);

        //---- label4 ----
        label4.setText("\u4f5c\u8005\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 7f));
        contentPane.add(label4);
        label4.setBounds(120, 205, 60, 27);

        //---- label5 ----
        label5.setText("\u8bc4\u7ea7\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 7f));
        contentPane.add(label5);
        label5.setBounds(120, 255, 60, 27);

        //---- label6 ----
        label6.setText("\u4f5c\u54c1\u7684\u5bbd\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 7f));
        contentPane.add(label6);
        label6.setBounds(80, 455, 100, 27);

        //---- label7 ----
        label7.setText("\u51fa\u7248\u56fd\u7c4d\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 7f));
        contentPane.add(label7);
        label7.setBounds(80, 355, 100, 27);

        //---- label8 ----
        label8.setText("\u4f5c\u54c1\u7684\u957f\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 7f));
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(80, 405), label8.getPreferredSize()));

        //---- textField3 ----
        textField3.setFont(textField3.getFont().deriveFont(textField3.getFont().getStyle() | Font.BOLD, textField3.getFont().getSize() + 6f));
        contentPane.add(textField3);
        textField3.setBounds(180, 202, 220, 34);

        //---- textField4 ----
        textField4.setFont(textField4.getFont().deriveFont(textField4.getFont().getStyle() | Font.BOLD, textField4.getFont().getSize() + 6f));
        contentPane.add(textField4);
        textField4.setBounds(180, 252, 220, 34);

        //---- textField5 ----
        textField5.setFont(textField5.getFont().deriveFont(textField5.getFont().getStyle() | Font.BOLD, textField5.getFont().getSize() + 6f));
        contentPane.add(textField5);
        textField5.setBounds(180, 452, 300, 34);

        //---- textField6 ----
        textField6.setFont(textField6.getFont().deriveFont(textField6.getFont().getStyle() | Font.BOLD, textField6.getFont().getSize() + 6f));
        contentPane.add(textField6);
        textField6.setBounds(180, 352, 300, 34);

        //---- textField7 ----
        textField7.setFont(textField7.getFont().deriveFont(textField7.getFont().getStyle() | Font.BOLD, textField7.getFont().getSize() + 6f));
        contentPane.add(textField7);
        textField7.setBounds(180, 402, 300, 34);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0\u5a92\u4f53");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 6f));
        button1.setForeground(Color.white);
        button1.setBackground(new Color(0x6699ff));
        contentPane.add(button1);
        button1.setBounds(135, 520, 110, 55);

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.setFont(button2.getFont().deriveFont(Font.BOLD, button2.getFont().getSize() + 6f));
        button2.setForeground(Color.white);
        button2.setBackground(new Color(0x6699ff));
        contentPane.add(button2);
        button2.setBounds(355, 520, 110, 55);

        //---- label10 ----
        label10.setText("\u7c7b\u578b\uff1a");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 7f));
        contentPane.add(label10);
        label10.setBounds(120, 305, 60, 27);

        //---- textField8 ----
        textField8.setFont(textField8.getFont().deriveFont(textField8.getFont().getStyle() | Font.BOLD, textField8.getFont().getSize() + 6f));
        contentPane.add(textField8);
        textField8.setBounds(180, 302, 220, 34);

        //---- label11 ----
        label11.setForeground(Color.red);
        contentPane.add(label11);
        label11.setBounds(190, 335, 305, 18);

        //---- label12 ----
        label12.setForeground(Color.red);
        contentPane.add(label12);
        label12.setBounds(190, 135, 205, 18);

        //---- textField9 ----
        textField9.setFont(textField9.getFont().deriveFont(textField9.getFont().getStyle() | Font.BOLD, textField9.getFont().getSize() + 6f));
        contentPane.add(textField9);
        textField9.setBounds(180, 152, 220, 34);

        //---- textField10 ----
        textField10.setFont(textField10.getFont().deriveFont(textField10.getFont().getStyle() | Font.BOLD, textField10.getFont().getSize() + 6f));
        contentPane.add(textField10);
        textField10.setBounds(180, 102, 220, 34);

        //---- label13 ----
        label13.setForeground(Color.red);
        contentPane.add(label13);
        label13.setBounds(190, 435, 205, 18);

        //---- label14 ----
        label14.setForeground(Color.red);
        contentPane.add(label14);
        label14.setBounds(190, 485, 205, 18);

        contentPane.setPreferredSize(new Dimension(610, 640));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        this.setTitle("新增媒体");
        textField3.setOpaque(false);
        textField4.setOpaque(false);
        textField5.setOpaque(false);
        textField6.setOpaque(false);
        textField7.setOpaque(false);
        textField8.setOpaque(false);
        textField9.setOpaque(false);
        textField10.setOpaque(false);

        contentPane.setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button1;
    private JButton button2;
    private JLabel label10;
    private JTextField textField8;
    private JLabel label11;
    private JLabel label12;
    private JTextField textField9;
    private JTextField textField10;
    private JLabel label13;
    private JLabel label14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
