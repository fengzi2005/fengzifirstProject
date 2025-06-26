public class Result {
    private int code;
    private String msg;
    private Object date;

    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final String OK_MSG = "OK";

    public Result(int code, String msg, Object date){
        this.code = code;
        this.msg = msg;
        this.date = date;
    }
    public static Result ok(String msg) {
        return new Result (OK,msg,null);
    }

    public static Result ok(Object date) {
        return new Result (OK,OK_MSG,date);
    }

    public static Result ok() {
        return Result.ok(null);
    }

    public static Result fail(String msg) {
        return new Result (FAIL,msg,null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getDate() {
        return date;
    }
}
