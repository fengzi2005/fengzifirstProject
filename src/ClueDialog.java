import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 26 21:00:35 CST 2025
 */



/**
 * @author fengzi
 */
public class ClueDialog extends JDialog{
    public ClueDialog(Window owner, String str) {
        super(owner);
        initComponents(str);
        this.setVisible(true);

    }

    private void initComponents(String str) {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea1.setText(str);
        button1 = new JButton();
        button1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            dispose();
    }});
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 5f));
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(95, 40, 190, 35);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        contentPane.add(button1);
        button1.setBounds(145, 100, 90, 39);

        contentPane.setPreferredSize(new Dimension(380, 195));
        setSize(380, 195);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        this.setTitle("提示");
        textArea1.setOpaque(false);
        textArea1.setBorder(null);
        scrollPane1.setBorder(null);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
