public class VideoDiscs extends Information{
    String publisherName;
    String publishYear;
    String videoTime;

    @Override
    public String toString() {
        return  "[编号:" + id + "  标题:" + title + "  作者:" + author + "  评级:" + grade + "  出品者" + publisherName + "  出品年份:" + publishYear + "  视频时长:" + videoTime + "  类型:视频光盘]";
    }
    public VideoDiscs(String id, String title, String author, String grade, String publisherName, String publishYear, String videoTime) {
        super(id, title, author, grade);
        this.publisherName = publisherName;
        this.publishYear = publishYear;
        this.videoTime = videoTime;
    }
}
