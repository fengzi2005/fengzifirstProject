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
        textArea1 = new JTextArea();
        returnStartJBT = new JButton();
        returnJBT = new JButton();
        scrollPane1 = new JScrollPane();
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
        }
        if (result.getCode() == 0) {
            if(index == 1) {
                textArea1.setText(result.getDate().toString());
            }else {
                StringBuilder text = new StringBuilder();
                for(Information information : (ArrayList<Information>)result.getDate()) {
                    text = text.append(information);
                }
                textArea1.setText(text.toString());
            }
        }else {
            switch (index) {
                case 1 :
                    textArea1.setText("不存在编号为" + str + "的媒体");
                    break;
                case 2 :
                    textArea1.setText("不存标题号为" + str + "的媒体");
                    break;
                case 3 :
                    textArea1.setText("不存在类型为" + str + "的媒体");
                    break;
            }
        }
        textArea1.setCaretPosition(0);
        //Result result = operate.typeFindInfo(str);

        Result finalResult = result;
        returnJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(finalResult.getCode() == 0){
                    dispose();
                    new TestJF0();
                }

            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5a92\u4f53\u67e5\u8be2\u6a21\u5f0f");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 25f));
        contentPane.add(label1);
        label1.setBounds(375, 5, 245, 45);

        //======== scrollPane1 ========
        {
            scrollPane1.setWheelScrollingEnabled(false);
            scrollPane1.setAutoscrolls(true);

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 6f));
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }
        scrollPane1.setBounds(65, 105, 840, 365);
        contentPane.add(scrollPane1);

        //---- label2 ----
        label2.setText("\u4e3a\u60a8\u67e5\u8be2\u5230\u4ee5\u4e0b\u5a92\u4f53\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 75), label2.getPreferredSize()));

        //---- returnStartJBT ----
        returnStartJBT.setText("\u4e3b\u754c\u9762");
        contentPane.add(returnStartJBT);
        returnStartJBT.setBounds(310, 500, 95, 45);

        //---- returnJBT ----
        returnJBT.setText("\u8fd4\u56de");
        contentPane.add(returnJBT);
        returnJBT.setBounds(565, 500, 95, 45);

        contentPane.setPreferredSize(new Dimension(970, 635));
        setSize(970, 635);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
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
