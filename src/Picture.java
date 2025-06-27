public class Picture extends Information{
    String publishState;
    String length;
    String width;

    public String toString() {
        return "[编号:" + id + "  标题:" + title + "  作者:" + author + "  评级:" + grade + "  出品国籍:" + publishState + "  作品的长:" + length + "作品的宽:" + width + "  类型:图画]\n";

    }

    public Picture(String id, String title, String author, String grade, String length, String publishState, String width) {
        super(id, title, author, grade);
        this.length = length;
        this.publishState = publishState;
        this.width = width;
    }
}
