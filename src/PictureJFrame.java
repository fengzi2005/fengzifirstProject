import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureJFrame extends JFrame implements ActionListener {
    JButton sureJBT = new JButton("确定");
    JButton sure2JBT = new JButton("确定");
    JButton returnJBT = new JButton("返回");
    JTextField idJTF = new JTextField();
    JTextField bookTitleJTF = new JTextField();
    JTextField authorJTF = new JTextField();
    JTextField gradeJTF = new JTextField();
    JTextField PSJTF = new JTextField();
    JTextField lengthJTF = new JTextField();
    JTextField widthJTF = new JTextField();
    JDialog clueDialog = new JDialog();
    JTextField clueJTF = new JTextField();

    public PictureJFrame() {
        initJFrame();
        initImage();
        this.setVisible(true);

    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(688,630);
        //设置界面的标题
        this.setTitle("添加图画");
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
        JLabel titleJLB = new JLabel(new ImageIcon("addPicture/增加图画类大提示.png"));
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

        JLabel PSJLB = new JLabel(new ImageIcon("addPicture/publishState.png"));
        PSJLB.setBounds(43,250,120,120);
        this.getContentPane().add(PSJLB);

        PSJTF.setBounds(160,295,400,25);
        this.getContentPane().add(PSJTF);

        JLabel ISBNJLB = new JLabel(new ImageIcon("addPicture/作品的长.png"));
        ISBNJLB.setBounds(45,334,120,30);
        this.getContentPane().add(ISBNJLB);

        lengthJTF.setBounds(160,340,400,25);
        this.getContentPane().add(lengthJTF);

        JLabel pageNumJLB = new JLabel(new ImageIcon("addPicture/作品的宽.png"));
        pageNumJLB.setBounds(45,380,120,30);
        this.getContentPane().add(pageNumJLB);

        widthJTF.setBounds(160,385,400,25);
        this.getContentPane().add(widthJTF);

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

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == sureJBT) {
            if (isEmpty(idJTF.getText()) || isEmpty(PSJTF.getText()) || isEmpty(bookTitleJTF.getText())
                    || isEmpty(authorJTF.getText()) || isEmpty(gradeJTF.getText()) || isEmpty(lengthJTF.getText())
                    || isEmpty(widthJTF.getText())) {
                throwClue("添加失败,信息不完整！");
            }else if(!idJTF.getText().matches("\\d{1,9}")) {
                throwClue("添加失败，id格式错误！");
            } else {
                String id = idJTF.getText();
                String title = bookTitleJTF.getText();
                String author = authorJTF.getText();
                String grade = gradeJTF.getText();
                String publishState = PSJTF.getText();
                String length = lengthJTF.getText();
                String width = widthJTF.getText();
                OperateInformation operate = new DateBase();
                Result result = operate.addInfo(id, title, author, grade, publishState, length, width, "图画");
                throwClue(result.getMsg());
                if (result.getCode() == 0) {
                    idJTF.setText("");
                    bookTitleJTF.setText("");
                    authorJTF.setText("");
                    gradeJTF.setText("");
                    PSJTF.setText("");
                    lengthJTF.setText("");
                    widthJTF.setText("");
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

