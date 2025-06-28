import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestJF0 extends JFrame{
    public TestJF0() {
        initComponents();
        this.setVisible(true);
    }


    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        findJTF = new JTextField();
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
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5a92\u4f53\u67e5\u8be2\u6a21\u5f0f");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 16f));
        contentPane.add(label1);
        label1.setBounds(145, 5, 195, 33);

        //---- label2 ----
        label2.setText("\u67e5\u8be2\u65b9\u5f0f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 8f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(115, 110), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u67e5\u8be2\u5185\u5bb9");
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
            "\u7f16\u53f7\u67e5\u8be2",
            "\u6807\u9898\u67e5\u8be2",
            "\u7c7b\u578b\u67e5\u8be2",
            "\u5168\u90e8\u67e5\u8be2"
        }));
        dropdown.setFont(dropdown.getFont().deriveFont(dropdown.getFont().getStyle() & ~Font.ITALIC, dropdown.getFont().getSize() + 6f));
        dropdown.setSelectedIndex(0);
        contentPane.add(dropdown);
        dropdown.setBounds(215, 110, 120, 35);

        //---- findJBT ----
        findJBT.setText("\u67e5\u8be2");
        findJBT.setFont(findJBT.getFont().deriveFont(findJBT.getFont().getStyle() | Font.BOLD, findJBT.getFont().getSize() + 6f));
        findJBT.setForeground(Color.white);
        findJBT.setBackground(new Color(0x6699ff));
        contentPane.add(findJBT);
        findJBT.setBounds(95, 235, 95, 40);

        //---- retrunJBT ----
        retrunJBT.setText("\u8fd4\u56de");
        retrunJBT.setFont(retrunJBT.getFont().deriveFont(retrunJBT.getFont().getStyle() | Font.BOLD, retrunJBT.getFont().getSize() + 6f));
        retrunJBT.setForeground(Color.white);
        retrunJBT.setBackground(new Color(0x6699ff));
        contentPane.add(retrunJBT);
        retrunJBT.setBounds(260, 235, 95, 40);

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

        dropdown.setOpaque(false);
        findJTF.setOpaque(false);
        setTitle("媒体查询模式");

        findJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = dropdown.getSelectedIndex();
                String findStr = findJTF.getText();
                if (selectedIndex == 0) {
                    throwClue("请选择查询方式");
                }else {
                    if (selectedIndex != 4 && findStr.isEmpty()) {
                        throwClue("请输入查询内容");
                    } else {
                        new FindDisplay(selectedIndex, findStr);
                        dispose();
                    }
                }
            }
        });
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

    private void throwClue(String str) {
        new ClueDialog(this,str);
    }
}
