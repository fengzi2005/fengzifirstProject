import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Jun 28 20:14:27 CST 2025
 */



/**
 * @author fengzi
 */
public class StartJFrame extends JFrame {
    public StartJFrame() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        menuBar1 = new JMenuBar();
        menuBar2 = new JMenuBar();
        menu3 = new JMenu();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        OperateInformation operate = new DateBase();
        Result result = operate.allFindInfo();
        StringBuilder text = new StringBuilder();
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
        textArea1.setText(text.toString());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddInfoJFrame();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TestJF0();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateInfoJF0();
            }
        });


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menuBar2 ========
            {

                //======== menu3 ========
                {
                    menu3.setText("\u529f\u80fd");

                    //======== menu4 ========
                    {
                        menu4.setText("\u66f4\u6362\u80cc\u666f");

                        //---- menuItem6 ----
                        menuItem6.setText("\u80cc\u666f1");
                        menu4.add(menuItem6);
                    }
                    menu3.add(menu4);

                    //---- menuItem7 ----
                    menuItem7.setText("\u5173\u95ed\u7cfb\u7edf");
                    menu3.add(menuItem7);
                }
                menuBar2.add(menu3);
            }
            menuBar1.add(menuBar2);

            //======== menu2 ========
            {
                menu2.setText("\u5173\u4e8e\u6211\u4eec");

                //---- menuItem3 ----
                menuItem3.setText("\u4f5b\u5c71\u5927\u5b66");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u5a92\u4f53\u7ba1\u7406\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 25f));
        contentPane.add(label1);
        label1.setBounds(455, 25, 235, 55);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 6f));
            textArea1.setEditable(false);
            textArea1.setBackground(Color.white);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(85, 100, 995, 400);

        //---- button1 ----
        button1.setText("\u65b0\u589e\u5a92\u4f53");
        button1.setBackground(new Color(0x6699ff));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 5f));
        button1.setForeground(Color.white);
        button1.setBorder(null);
        contentPane.add(button1);
        button1.setBounds(125, 540, 120, 55);

        //---- button2 ----
        button2.setText("\u67e5\u8be2\u5a92\u4f53");
        button2.setBackground(new Color(0x6699ff));
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 5f));
        button2.setForeground(Color.white);
        button2.setBorder(null);
        contentPane.add(button2);
        button2.setBounds(320, 540, 120, 55);

        //---- button3 ----
        button3.setText("\u7f16\u8f91\u5a92\u4f53");
        button3.setBackground(new Color(0x6699ff));
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 5f));
        button3.setForeground(Color.white);
        button3.setBorder(null);
        contentPane.add(button3);
        button3.setBounds(515, 540, 120, 55);

        //---- button4 ----
        button4.setText("\u5bfc\u51fa\u5a92\u4f53");
        button4.setBackground(new Color(0x6699ff));
        button4.setFont(button4.getFont().deriveFont(Font.BOLD, button4.getFont().getSize() + 5f));
        button4.setForeground(Color.white);
        button4.setBorder(null);
        contentPane.add(button4);
        button4.setBounds(710, 540, 120, 55);

        //---- button5 ----
        button5.setText("\u5bfc\u5165\u5a92\u4f53");
        button5.setBackground(new Color(0x6699ff));
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 5f));
        button5.setForeground(Color.white);
        button5.setBorder(null);
        contentPane.add(button5);
        button5.setBounds(905, 540, 120, 55);

        contentPane.setPreferredSize(new Dimension(1170, 665));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        this.getContentPane().setBackground(Color.white);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuBar menuBar2;
    private JMenu menu3;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
