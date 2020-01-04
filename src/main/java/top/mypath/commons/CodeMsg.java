package top.mypath.commons;

/**
 * @author 李亚林
 * @date 2019/12/25 13:45
 */
public class CodeMsg {
    private int code;
    private String msg;
    public static CodeMsg SUCCESS=new CodeMsg(0,"success");
    public static CodeMsg LOGIN_INFO_NULL=new CodeMsg(1,"登录的账号或密码为空");
    public static CodeMsg LOGIN_INFO_ERROR=new CodeMsg(2,"账号或密码错误");
    public static CodeMsg REGISTER_INFO_NULL=new CodeMsg(3,"注册信息为空");
    public static CodeMsg REGISTER_FAIL=new CodeMsg(4,"注册失败");
    public static CodeMsg REGISTER_FAIL_REPEAT=new CodeMsg(5,"该账号已被注册");
    public static CodeMsg DETAIL_INSERT_FAIL=new CodeMsg(6,"保存失败");
    public static CodeMsg DETAIL_UPDATE_USER_ERROR=new CodeMsg(7,"修改的数据不是当前登录用户的");
    public static CodeMsg DETAIL_NULL=new CodeMsg(8,"该数据不存在");
    public static CodeMsg ERROR=new CodeMsg(500,"服务端异常");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
