import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Jun 27 14:17:37 CST 2025
 */



/**
 * @author fengzi
 */
public class UpdateInfoJF0 extends JFrame {
    public UpdateInfoJF0() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        findJTF = new JTextField();
        findJTF.setOpaque(false);
        dropdown = new JComboBox<>();
        findJBT = new JButton();
        retrunJBT = new JButton();

        retrunJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartJFrame();
            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        setBackground(SystemColor.activeCaptionBorder);
        setTitle("\u5a92\u4f53\u7f16\u8f91\u6a21\u5f0f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5a92\u4f53\u7f16\u8f91\u6a21\u5f0f");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 16f));
        contentPane.add(label1);
        label1.setBounds(145, 5, 195, 33);

        //---- label2 ----
        label2.setText("\u7f16\u8f91\u65b9\u5f0f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 8f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(115, 110), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5a92\u4f53\u7f16\u53f7");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 8f));
        contentPane.add(label3);
        label3.setBounds(115, 155, 83, 28);

        //---- findJTF ----
        findJTF.setFont(findJTF.getFont().deriveFont(findJTF.getFont().getStyle() | Font.BOLD, findJTF.getFont().getSize() + 6f));
        contentPane.add(findJTF);
        findJTF.setBounds(215, 155, 120, 35);

        //---- dropdown ----
        dropdown.setModel(new DefaultComboBoxModel<>(new String[] {
            "            ",
            "\u7f16\u8f91\u5a92\u4f53",
            "\u5220\u9664\u5a92\u4f53"
        }));
        dropdown.setFont(dropdown.getFont().deriveFont(dropdown.getFont().getStyle() & ~Font.ITALIC, dropdown.getFont().getSize() + 6f));
        dropdown.setSelectedIndex(0);
        contentPane.add(dropdown);
        dropdown.setBounds(215, 110, 120, 35);

        //---- findJBT ----
        findJBT.setText("\u786e\u5b9a");
        findJBT.setFont(findJBT.getFont().deriveFont(findJBT.getFont().getStyle() | Font.BOLD, findJBT.getFont().getSize() + 6f));
        findJBT.setForeground(Color.white);
        findJBT.setBackground(new Color(0x6699ff));
        findJBT.setBorder(null);
        contentPane.add(findJBT);
        findJBT.setBounds(120, 235, 95, 40);

        //---- retrunJBT ----
        retrunJBT.setText("\u8fd4\u56de");
        retrunJBT.setFont(retrunJBT.getFont().deriveFont(retrunJBT.getFont().getStyle() | Font.BOLD, retrunJBT.getFont().getSize() + 6f));
        retrunJBT.setForeground(Color.white);
        retrunJBT.setBackground(new Color(0x6699ff));
        retrunJBT.setBorder(null);
        contentPane.add(retrunJBT);
        retrunJBT.setBounds(235, 235, 95, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(465, 400);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        contentPane.setBackground(Color.white);

        findJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = dropdown.getSelectedIndex();
                String str = findJTF.getText();
                OperateInformation operate = new DateBase();
                if (index == 0) {
                    throwClue("请选择编辑模式！");
                }else if (str.isEmpty()) {
                    throwClue("请输入媒体编号！");
                }else {
                    Result result = operate.idFindInfo(str);
                    if (result.getCode() == 0) {
                        dispose();
                        new UpdateInoDisplay(index,str,result);
                    }else {
                        throwClue(result.getMsg());
                    }

                }


            }
        });

    }
    private void throwClue(String str) {
        new ClueDialog(this,str);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField findJTF;
    private JComboBox<String> dropdown;
    private JButton findJBT;
    private JButton retrunJBT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
