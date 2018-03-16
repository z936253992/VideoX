package usermage;

/**
 * Created by liuqi on 2017/12/16.
 */

public class user_info_sp {
    private  String UserName;
    private  String Password;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    private int User_id;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRanName() {
        return RanName;
    }

    public void setRanName(String ranName) {
        RanName = ranName;
    }

    private  String RanName;

}
