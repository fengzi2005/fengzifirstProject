import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TestJFrame extends JFrame{
    JButton findJBT = new JButton("查询");
    public TestJFrame() {
        initJFrame();
        initImage();
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置界面宽高
        this.setSize(688,630);
        //设置界面的标题
        this.setTitle("添加图书");
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
        String[] options = {"选项1","选项二","选项三"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(400,100,100,30);
        dropdown.setOpaque(false);


        JLabel jLabel = new JLabel("请选择查询模式");
        jLabel.setBounds(50,15,200,200);

        this.getContentPane().add(jLabel);
        this.getContentPane().add(dropdown);

        findJBT.setBounds(125,240,90,50);
        this.getContentPane().add(findJBT);
        findJBT.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == findJBT){
                    System.out.println("选择了第" + dropdown.getSelectedIndex() + "个");
                }

            }
        });
    }
}
