package top.mypath.commons;

/**
 * @author 李亚林
 * @date 2019/12/25 13:36
 */
public class Result<T>{
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code=0;
        this.msg="success";
        this.data=data;
    }

    private Result(CodeMsg cm) {
        if (cm==null){
            return;
        }
        this.code=cm.getCode();
        this.msg=cm.getMsg();
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
