import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jun 27 14:32:37 CST 2025
 */



/**
 * @author fengzi
 */
public class UpdateInoDisplay extends JFrame {
    public UpdateInoDisplay(int index,String id,Result result) {
        initComponents(index,id,result);
        this.setVisible(true);
    }

    private void initComponents(int index,String id,Result result) {
        textArea1 = new JTextArea();
        textArea1.setText(result.getDate().toString().replace("\n",""));
        textArea1.setCaretPosition(0);
        textArea1.setOpaque(false);

        scrollPane1 = new JScrollPane();
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setViewportView(textArea1);
        scrollPane1.setBorder(null);

        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label5 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();

        button3 = new JButton();

        /*this.setComponentZOrder(label8,0);
        this.setComponentZOrder(label9,0);
        this.setComponentZOrder(label10,0);*/

        Information info = (Information) result.getDate();
        textField9.setText(info.id);
        textField2.setText(info.title);
        textField3.setText(info.author);
        textField4.setText(info.grade);
        if (info.getClass().equals(new Picture().getClass())) {

            textField5.setText("图画");
            textField6.setText(((Picture) info).publishState);
            textField7.setText(((Picture) info).length);
            textField8.setText(((Picture) info).width);
            initLabalofPicture();
        } else if (info.getClass().equals(new VideoDiscs().getClass())) {
            textField5.setText("视频光盘");
            textField6.setText(((VideoDiscs) info).publisherName);
            textField7.setText(((VideoDiscs) info).publishYear);
            textField8.setText(((VideoDiscs) info).videoTime);
            initLabalofVedio();
        }else {
            textField5.setText("图书");
            textField6.setText(((Books) info).publicHouse);
            textField7.setText(((Books) info).ISBN);
            textField8.setText(((Books) info).pageNum);
            initLabalofBooks();
        }

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label11 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 17));
        setTitle("\u5a92\u4f53\u7f16\u8f91\u6a21\u5f0f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7f16\u8f91\u5a92\u4f53");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 19f));
        label1.setForeground(UIManager.getColor("ActionButton.focusedBorderColor"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(495, 0), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 6f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 90, 1040, 45);

        //---- label2 ----
        label2.setText("\u4e3a\u60a8\u627e\u5230\u4ee5\u4e0b\u5a92\u4f53\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));
        contentPane.add(label2);
        label2.setBounds(50, 55, 187, 35);

        //---- label3 ----
        label3.setText("\u8bf7\u8f93\u5165\u4fee\u6539\u540e\u5a92\u4f53\u7684\u8be6\u7ec6\u4fe1\u606f\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 6f));
        contentPane.add(label3);
        label3.setBounds(50, 135, 265, 35);

        //---- label4 ----
        label4.setText("\u7f16\u53f7\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 6f));
        label4.setBackground(new Color(0x3399ff));
        contentPane.add(label4);
        label4.setBounds(45, 190, 60, 35);

        //---- label5 ----
        label5.setText("\u6807\u9898\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 6f));
        contentPane.add(label5);
        label5.setBounds(45, 240, 60, 35);

        //---- textField2 ----
        textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getStyle() | Font.BOLD, textField2.getFont().getSize() + 6f));
        contentPane.add(textField2);
        textField2.setBounds(105, 242, 195, 34);

        //---- label6 ----
        label6.setText("\u4f5c\u8005\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 6f));
        contentPane.add(label6);
        label6.setBounds(45, 290, 60, 35);

        //---- textField3 ----
        textField3.setFont(textField3.getFont().deriveFont(textField3.getFont().getStyle() | Font.BOLD, textField3.getFont().getSize() + 6f));
        contentPane.add(textField3);
        textField3.setBounds(105, 292, 195, 34);

        //---- label7 ----
        label7.setText("\u8bc4\u7ea7\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 6f));
        contentPane.add(label7);
        label7.setBounds(45, 340, 60, 35);

        //---- textField4 ----
        textField4.setFont(textField4.getFont().deriveFont(textField4.getFont().getStyle() | Font.BOLD, textField4.getFont().getSize() + 6f));
        contentPane.add(textField4);
        textField4.setBounds(105, 342, 195, 34);

        //---- label8 ----
        label8.setText("\u51fa\u7248\u793e\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 6f));
        contentPane.add(label8);
        label8.setBounds(370, 190, 95, 35);

        //---- label9 ----
        label9.setText("ISBN\u53f7\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 6f));
        contentPane.add(label9);
        label9.setBounds(370, 240, 100, 35);

        //---- label10 ----
        label10.setText("\u9875\u6570 \uff1a");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 6f));
        contentPane.add(label10);
        label10.setBounds(370, 290, 100, 35);

        //---- label11 ----
        label11.setText("\u7c7b\u578b\uff1a");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getStyle() | Font.BOLD, label11.getFont().getSize() + 6f));
        contentPane.add(label11);
        label11.setBounds(45, 390, 70, 35);

        //---- textField5 ----
        textField5.setFont(textField5.getFont().deriveFont(textField5.getFont().getStyle() | Font.BOLD, textField5.getFont().getSize() + 6f));
        contentPane.add(textField5);
        textField5.setBounds(105, 392, 195, 34);

        //---- textField6 ----
        textField6.setFont(textField6.getFont().deriveFont(Font.BOLD, textField6.getFont().getSize() + 6f));
        contentPane.add(textField6);
        textField6.setBounds(455, 190, 310, 34);

        //---- textField7 ----
        textField7.setFont(textField7.getFont().deriveFont(textField7.getFont().getStyle() | Font.BOLD, textField7.getFont().getSize() + 6f));
        contentPane.add(textField7);
        textField7.setBounds(455, 240, 310, 34);

        //---- textField8 ----
        textField8.setFont(textField8.getFont().deriveFont(textField8.getFont().getStyle() | Font.BOLD, textField8.getFont().getSize() + 6f));
        contentPane.add(textField8);
        textField8.setBounds(455, 290, 310, 34);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(310, 440, 105, 50);

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        contentPane.add(button2);
        button2.setBounds(665, 440, 105, 50);

        //---- textField9 ----
        textField9.setFont(textField9.getFont().deriveFont(textField9.getFont().getStyle() | Font.BOLD, textField9.getFont().getSize() + 6f));
        contentPane.add(textField9);
        textField9.setBounds(105, 192, 195, 34);
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(new Rectangle(new Point(450, 305), scrollPane2.getPreferredSize()));

        //---- label15 ----
        label15.setForeground(Color.red);
        contentPane.add(label15);
        label15.setBounds(110, 225, 215, 18);

        //---- label16 ----
        label16.setForeground(Color.red);
        contentPane.add(label16);
        label16.setBounds(110, 425, 215, 18);

        contentPane.setPreferredSize(new Dimension(1145, 575));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        JLabel bgJLB = new JLabel(new ImageIcon("findJFramePng/background (5).png"));
        bgJLB.setBounds(0,0,1159,612);
        this.getContentPane().add(bgJLB);
        textField2.setOpaque(false);
        textField3.setOpaque(false);
        textField4.setOpaque(false);
        textField5.setOpaque(false);
        textField6.setOpaque(false);
        textField7.setOpaque(false);
        textField8.setOpaque(false);
        textField9.setOpaque(false);
        if (index == 2) {
            button3.setText("确认删除");
            contentPane.add(button3);
            button3.setBounds(310, 440, 105, 50);
            this.getContentPane().removeAll();
            this.getContentPane().add(label1);
            this.getContentPane().add(label2);
            this.getContentPane().add(scrollPane1);
            this.getContentPane().add(button3);
            this.getContentPane().add(button2);
            this.getContentPane().add(bgJLB);
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperateInformation operate = new DateBase();
                    Result result1 = operate.deleteInfo(id);
                    throwClue(result1.getMsg());
                    if (result1.getCode() == 0){
                        textArea1.setText("");
                    }
                }
            });
        }
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newId = textField9.getText();
                String title = textField2.getText();
                String author = textField3.getText();
                String grade = textField4.getText();
                String type = textField5.getText();
                String publishHouse = textField6.getText();
                String ISBN = textField7.getText();
                String pageNumber = textField8.getText();
                if (newId.isEmpty() || title.isEmpty() ||author.isEmpty()||
                grade.isEmpty() || publishHouse.isEmpty() ||ISBN.isEmpty()||
                pageNumber.isEmpty() || type.isEmpty()){
                    throwClue("请将信息填写完整！");
                }else if (!label15.getText().equals("")){
                    throwClue("编号格式错误！");
                }else if(!label16.getText().equals("")){
                    throwClue("暂不支持此类型！");
                }else {
                    OperateInformation operate = new DateBase();
                    Result result1 = operate.updateInfo(id,newId,title,author,grade,publishHouse,ISBN,pageNumber,type);
                    throwClue(result1.getMsg());
                    if (result1.getCode() == 0){
                        textArea1.setText("[编号:" + newId + "  标题:" + title + "  作者:" + author + "  评级:" + grade + "  出版社:" + publishHouse + "  ISBN号:" + ISBN + "  页数:" + pageNumber + "  类型:" +type + "]");
                    }
                }

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateInfoJF0();
            }
        });


        textField9.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!textField9.getText().matches("\\d{1,9}")){
                    label15.setText("\u7f16\u53f7\u683c\u5f0f\u9519\u8bef!\uff08\u4ec5\u652f\u63011-9\u4f4d\u6570\u5b57\uff09");
                }else {
                    label15.setText("");
                }
            }
        });

        textField5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                String str = textField5.getText();
                label16.setText("");
                switch (str) {
                    case "图书" -> initLabalofBooks();
                    case "视频光盘" -> initLabalofVedio();
                    case "图画" -> initLabalofPicture();
                    default -> label16.setText("暂不支持此类型！");
                }
            }
        });
    }

    private void initLabalofBooks() {
        label8.setText("出版社：");
        label9.setText("ISBN号：");
        label10.setText("页数：");
    }

    private void initLabalofVedio() {
        label8.setText("出品者：");
        label9.setText("出品年份：");
        label10.setText("视频时长：");
    }

    private void initLabalofPicture() {
        label8.setText("出品国籍：");
        label9.setText("作品的长：");
        label10.setText("作品的宽：");
    }

    private void throwClue(String str) {
        new ClueDialog(this,str);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label7;
    private JTextField textField4;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField9;
    private JScrollPane scrollPane2;
    private JLabel label15;
    private JLabel label16;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
