public class Books extends Information{
    String publicHouse;
    String ISBN;
    String pageNum;

    public Books() {
    }

    @Override
    public String toString() {
        return "[编号:" + id + "  标题:" + title + "  作者:" + author + "  评级:" + grade + "  出版社:" + publicHouse + "  ISBN号:" + ISBN + "  页数:" + pageNum + "  类型:图书]\n";

    }

    public Books(String id, String title, String author, String grade , String publicHouse, String ISBN, String pageNum) {
        super(id, title,author, grade);
        this.ISBN = ISBN;
        this.pageNum = pageNum;
        this.publicHouse = publicHouse;
    }
}
