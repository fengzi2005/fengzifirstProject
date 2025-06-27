import java.sql.*;
import java.util.ArrayList;

public class DateBase implements OperateInformation {
    String url = "jdbc:mysql://localhost:3306/system?useUnicode=true&characterEncoding=utf8";
    String user = "root";
    String password = "123456";
    String sql1 = "INSERT INTO information (id,title,author,grade,publishHouse,ISBN,pageNumber,type) VALUES (?,?,?,?,?,?,?,?)";
    String sql2 = "SELECT * FROM information WHERE id = ?";
    String sql3 = "SELECT * FROM information WHERE title = ?";
    String sql4 = "SELECT * FROM information WHERE type = ?";
    String sql5 = "SELECT * FROM information";


    public Result addInfo(String id, String title, String author, String grade, String publishHouse, String ISBN, String pageNum, String str) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql1);
                 PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

                if (idFindInfo(id).getCode() == 0) {
                    return Result.fail("该编号已被占用！");
                } else {
                    pstmt.setString(1, id);
                    pstmt.setString(2, title);
                    pstmt.setString(3, author);
                    pstmt.setString(4, grade);
                    pstmt.setString(5, publishHouse);
                    pstmt.setString(6, ISBN);
                    pstmt.setString(7, pageNum);
                    pstmt.setString(8, str);
                    int row = pstmt.executeUpdate();
                    System.out.println(row + "行");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Result.ok("添加成功！");
    }

    @Override
    public Result idFindInfo(String id) {
        try (Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstmt = conn.prepareStatement(sql2);){
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String str = rs.getString("type");
                if (str.equals("图书")){
                    return returnBooks(rs);
                }else if(str.equals("视频光盘")){
                    return returnVedio(rs);
                }else {
                    return returnPicture(rs);
                }

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.fail("不存在此编号的媒体！");
    }

    @Override
    public Result titleFindInfo(String title) {
        ArrayList<Information> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql3);){
            pstmt.setString(1,title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                switch (rs.getString("type")){
                    case "图书" -> addBookTolist(list, rs);
                    case "视频光盘" -> addVedioTolist(list,rs);
                    case "图画" -> addPictureTolist(list,rs);
                }

            }
            if (list.size() != 0) return Result.ok(list);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.fail("不存在此标题的媒体！");
    }

    @Override
    public Result typeFindInfo(String type) {
        ArrayList<Information> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql4);){
            pstmt.setString(1,type);
            ResultSet rs = pstmt.executeQuery();
            /*while (rs.next()) {
                switch (type){
                    case "book" -> addBookTolist(list, rs);
                    case "vedio" -> addVedioTolist(list,rs);
                    case "picture" -> addPictureTolist(list,rs);
                }
            }*/
            switch (type) {
                case "图书" -> addToListOfBooks(rs, list);

                case "视频光盘" -> addToListOfVedio(rs, list);

                case "图画" -> addToListOfPicture(rs, list);
            }
            if (list.size() != 0) return Result.ok(list);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.fail("不存在此类型的媒体！");
    }

    @Override
    public Result allFindInfo() {
        ArrayList<Information> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql5);){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                switch (rs.getString("type")){
                    case "图书" -> addBookTolist(list, rs);
                    case "视频光盘" -> addVedioTolist(list,rs);
                    case "图画" -> addPictureTolist(list,rs);
                }

            }
            if (list.size() != 0) return Result.ok(list);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.fail("媒体库中无媒体！");
    }

    private static void addToListOfPicture(ResultSet rs, ArrayList<Information> list) throws SQLException {
        while(rs.next()){
            addPictureTolist(list, rs);
        }
    }

    private static void addToListOfVedio(ResultSet rs, ArrayList<Information> list) throws SQLException {
        while(rs.next()){
            addVedioTolist(list, rs);
        }
    }

    private static void addToListOfBooks(ResultSet rs, ArrayList<Information> list) throws SQLException {
        while(rs.next()){
            addBookTolist(list, rs);
        }
    }

    private static Result returnPicture(ResultSet rs) throws SQLException {
        return Result.ok(new Picture(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }

    private static Result returnVedio(ResultSet rs) throws SQLException {
        return Result.ok(new VideoDiscs(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }

    private static Result returnBooks(ResultSet rs) throws SQLException {
        return Result.ok(new Books(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }
    private static void addPictureTolist(ArrayList<Information> list, ResultSet rs) throws SQLException {
        list.add(new Picture(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }
    private static void addVedioTolist(ArrayList<Information> list, ResultSet rs) throws SQLException {
        list.add(new VideoDiscs(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }

    private static void addBookTolist(ArrayList<Information> list, ResultSet rs) throws SQLException {
        list.add(new Books(rs.getString("id"), rs.getString("title"),
                rs.getString("author"), rs.getString("grade"),
                rs.getString("publishHouse"), rs.getString("ISBN"),
                rs.getString("pageNumber")));
    }
}


