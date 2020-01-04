package top.mypath.domain;

import java.io.Serializable;

/**
 * @author 李亚林
 * @date 2019/12/22 16:03
 */
public class User implements Serializable {
    private String userId;
    private String head;
    private String userName;
    private String password;
    private Integer sex;
    private String email;
    private Double myBalance;
    private Integer cancel;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMyBalance() {
        return myBalance;
    }

    public void setMyBalance(Double myBalance) {
        this.myBalance = myBalance;
    }

    public Integer getCancel() {
        return cancel;
    }

    public void setCancel(Integer cancel) {
        this.cancel = cancel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", head='" + head + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", myBalance=" + myBalance +
                ", cancel=" + cancel +
                '}';
    }
}
