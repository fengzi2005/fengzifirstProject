public interface OperateInformation {
    Result addInfo(String id, String title, String author, String grade, String publishHouse, String ISBN, String pageNum, String str);
    Result idFindInfo (String id);
    Result titleFindInfo (String title);
    Result typeFindInfo (String title);


}
