import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VedioJFrame extends JFrame implements ActionListener {
    JTextField idJTF = new JTextField();
    JTextField bookTitleJTF = new JTextField();
    JTextField authorJTF = new JTextField();
    JTextField gradeJTF = new JTextField();
    JTextField PHJTF = new JTextField();
    JTextField PYJTF = new JTextField();
    JTextField VTJTF = new JTextField();
    JButton sureJBT = new JButton("确定");
    JButton sure2JBT = new JButton("确定");
    JButton returnJBT = new JButton("返回");
    JDialog clueDialog = new JDialog();
    JTextField clueJTF = new JTextField();

    public VedioJFrame(){
        initJFrame();
        initImage();
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置界面宽高
        this.setSize(688,630);
        //设置界面的标题
        this.setTitle("添加视频光盘");
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
        JLabel titleJLB = new JLabel(new ImageIcon("addVedio/增加视频光盘类大提示.png"));
        titleJLB.setBounds(135,0,400,70);
        this.getContentPane().add(titleJLB);

        JLabel idJLB = new JLabel(new ImageIcon("addPng/id.png"));
        idJLB.setBounds(90,115,65,25);
        this.getContentPane().add(idJLB);

        idJTF.setBounds(160,115,400,25);
        this.getContentPane().add(idJTF);

        JLabel bookTitleJLB = new JLabel(new ImageIcon("addPng/title.png"));
        bookTitleJLB.setBounds(92,160,62,27);
        this.getContentPane().add(bookTitleJLB);

        bookTitleJTF.setBounds(160,160,400,25);
        this.getContentPane().add(bookTitleJTF);

        JLabel authorJLB = new JLabel(new ImageIcon("addPng/author.png"));
        authorJLB.setBounds(92,205,62,27);
        this.getContentPane().add(authorJLB);

        authorJTF.setBounds(160,205,400,25);
        this.getContentPane().add(authorJTF);

        JLabel gradeJLB = new JLabel(new ImageIcon("addPng/grade.png"));
        gradeJLB.setBounds(72,214,100,100);
        this.getContentPane().add(gradeJLB);

        gradeJTF.setBounds(160,250,400,25);
        this.getContentPane().add(gradeJTF);

        JLabel PHJLB = new JLabel(new ImageIcon("addVedio/出品者.png"));
        PHJLB.setBounds(67,260,100,100);
        this.getContentPane().add(PHJLB);

        PHJTF.setBounds(160,295,400,25);
        this.getContentPane().add(PHJTF);

        JLabel PYJLB = new JLabel(new ImageIcon("addVedio/出品年份.png"));
        PYJLB.setBounds(73,334,80,33);
        this.getContentPane().add(PYJLB);

        PYJTF.setBounds(160,340,400,25);
        this.getContentPane().add(PYJTF);

        JLabel VTJLB = new JLabel(new ImageIcon("addVedio/视频时长.png"));
        VTJLB.setBounds(74,380,80,33);
        this.getContentPane().add(VTJLB);

        VTJTF.setBounds(160,385,400,25);
        this.getContentPane().add(VTJTF);

        sureJBT.setBounds(176,450,120,60);
        this.getContentPane().add(sureJBT);
        sureJBT.addActionListener(this);

        returnJBT.setBounds(366,450,120,60);
        this.getContentPane().add(returnJBT);
        returnJBT.addActionListener(this);

        JLabel bgJLB = new JLabel(new ImageIcon("addPng/addBackground.png"));
        bgJLB.setBounds(0,0,688,630);
        this.getContentPane().add(bgJLB);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == sureJBT) {
            if (isEmpty(idJTF.getText()) || isEmpty(PHJTF.getText()) || isEmpty(bookTitleJTF.getText())
                    || isEmpty(authorJTF.getText()) || isEmpty(gradeJTF.getText()) || isEmpty(PYJTF.getText())
                    || isEmpty(VTJTF.getText())) {
                throwClue("添加失败,信息不完整！");
            }else if(!idJTF.getText().matches("\\d{1,9}")) {
                throwClue("添加失败，id格式错误！");
            } else {
                String id = idJTF.getText();
                String title = bookTitleJTF.getText();
                String author = authorJTF.getText();
                String grade = gradeJTF.getText();
                String publisherName = PHJTF.getText();
                String publishYear = PYJTF.getText();
                String vedioTime = VTJTF.getText();
                OperateInformation operate = new DateBase();
                Result result = operate.addInfo(id,title,author,grade,publisherName,publishYear, vedioTime,"视频光盘");
                throwClue(result.getMsg());
                if (result.getCode() == 0) {
                    idJTF.setText("");
                    bookTitleJTF.setText("");
                    authorJTF.setText("");
                    gradeJTF.setText("");
                    PHJTF.setText("");
                    PYJTF.setText("");
                    VTJTF.setText("");
                }
            }
        }else if (source == sure2JBT) {
            clueDialog.setVisible(false);
        }else {
            this.setVisible(false);
            new AddJFrame();
        }
    }
    private void throwClue(String str) {

        clueDialog.setSize(250,150);
        clueDialog.setTitle("提示");
        clueDialog.setLocationRelativeTo(null);
        clueDialog.setModal(true);
        clueDialog.setAlwaysOnTop(true);
        clueDialog.getContentPane().setLayout(null);
        clueDialog.getContentPane().removeAll();

        clueJTF = new JTextField(str);
        clueJTF.setBounds(50,30,150,30);

        sure2JBT.setBounds(90,60,60,30);
        sure2JBT.addActionListener(this);

        clueDialog.getContentPane().add(clueJTF);
        clueDialog.getContentPane().add(sure2JBT);
        clueDialog.getContentPane().repaint();
        clueDialog.setVisible(true);
    }
    public boolean isEmpty(String str){
        if (str.isEmpty()) return true;
        return false;
    }
}
