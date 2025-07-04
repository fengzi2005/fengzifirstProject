import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 26 19:12:07 CST 2025
 */



/**
 * @author fengzi
 */
public class FindDisplay extends JFrame {
    public FindDisplay(int index, String str) {
        initComponents(index,str);
        this.setVisible(true);
    }

    private void initComponents(int index,String str) {
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label2 = new JLabel();
        returnStartJBT = new JButton();
        returnJBT = new JButton();
        textArea1.setEditable(false);
        OperateInformation operate = new DateBase();
        Result result = null;
        switch (index) {
            case 1 :
                result = operate.idFindInfo(str);
                break;
            case 2:
                result = operate.titleFindInfo(str);
                break;
            case 3:
                result = operate.typeFindInfo(str);
                break;
            case 4:
                result = operate.allFindInfo();
                break;
        }
        if (result.getCode() == 0) {
            if(index == 1) {
                textArea1.setText(result.getDate().toString());
            }else {
                StringBuilder text = new StringBuilder();
                if (index ==4 ) {
                    int size = ((ArrayList<?>) result.getDate()).size();
                    text.append("媒体库中媒体数量为：" + size + "\n");
                    for(Information information : (ArrayList<Information>)result.getDate()) {
                        text = text.append(information);
                    }
                    text.append("\n");

                    result =  operate.typeFindInfo("图书");
                    if (result.getCode() == 0) {
                        size = ((ArrayList<?>) result.getDate()).size();
                        text.append("其中图书数量为：" + size + "\n");
                        for(Information information : (ArrayList<Information>)result.getDate()) {
                            text = text.append(information);
                        }
                    }else {
                        text.append("其中图书数量为：0" + "\n");
                    }
                    text.append("\n");

                    result =  operate.typeFindInfo("视频光盘");
                    if(result.getCode() == 0) {
                        size = ((ArrayList<?>) result.getDate()).size();
                        text.append("视频光盘数量为：" + size + "\n");
                        for(Information information : (ArrayList<Information>)result.getDate()) {
                            text = text.append(information);
                        }
                    }else {
                        text.append("视频光盘数量为：0" + "\n");
                    }
                    text.append("\n");

                    result = operate.typeFindInfo("图画");
                    if (result.getCode() == 0){
                        size = ((ArrayList<?>) result.getDate()).size();
                        text.append("图画数量为：" + size + "\n");
                        for(Information information : (ArrayList<Information>)result.getDate()) {
                            text = text.append(information);
                        }
                    }else {
                        text.append("图画数量为：0" + "\n");
                    }

                }else {
                    for(Information information : (ArrayList<Information>)result.getDate()) {
                        text = text.append(information);
                    }
                }

                textArea1.setText(text.toString());
            }
        }else {
            switch (index) {
                case 1 :
                    textArea1.setText("不存在编号为" + str + "的媒体");
                    break;
                case 2 :
                    textArea1.setText("不存在标题为" + str + "的媒体");
                    break;
                case 3 :
                    textArea1.setText("不存在类型为" + str + "的媒体");
                    break;
                case 4 :
                    textArea1.setText("媒体库中什么也没有！");
                    break;
            }
        }
        textArea1.setCaretPosition(0);
        //Result result = operate.typeFindInfo(str);

        Result finalResult = result;
        returnJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new TestJF0();


            }
        });

        returnStartJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartJFrame();
            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setTitle("\u5a92\u4f53\u67e5\u8be2\u6a21\u5f0f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5a92\u4f53\u67e5\u8be2\u6a21\u5f0f");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 25f));
        contentPane.add(label1);
        label1.setBounds(505, 0, 245, 45);

        //======== scrollPane1 ========
        {
            scrollPane1.setWheelScrollingEnabled(false);
            scrollPane1.setAutoscrolls(true);

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 6f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(70, 105, 1125, 425);

        //---- label2 ----
        label2.setText("\u4e3a\u60a8\u67e5\u8be2\u5230\u4ee5\u4e0b\u5a92\u4f53\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(75, 75), label2.getPreferredSize()));

        //---- returnStartJBT ----
        returnStartJBT.setText("\u4e3b\u754c\u9762");
        returnStartJBT.setBackground(new Color(0x6699ff));
        returnStartJBT.setFont(returnStartJBT.getFont().deriveFont(returnStartJBT.getFont().getStyle() | Font.BOLD, returnStartJBT.getFont().getSize() + 6f));
        returnStartJBT.setForeground(Color.white);
        returnStartJBT.setBorder(null);
        contentPane.add(returnStartJBT);
        returnStartJBT.setBounds(395, 555, 120, 55);

        //---- returnJBT ----
        returnJBT.setText("\u8fd4\u56de");
        returnJBT.setFont(returnJBT.getFont().deriveFont(returnJBT.getFont().getStyle() | Font.BOLD, returnJBT.getFont().getSize() + 6f));
        returnJBT.setForeground(Color.white);
        returnJBT.setBackground(new Color(0x6699ff));
        returnJBT.setBorder(null);
        contentPane.add(returnJBT);
        returnJBT.setBounds(695, 555, 120, 55);

        contentPane.setPreferredSize(new Dimension(1290, 705));
        setSize(1290, 705);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        textArea1.setOpaque(false);
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setViewportView(textArea1);

        contentPane.setBackground(Color.white);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label2;
    private JButton returnStartJBT;
    private JButton returnJBT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
