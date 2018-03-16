package usermage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by liuqi on 2017/12/16.
 */

public class UserManage {
    private static UserManage instance;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, int id,String username, String password, String ranname) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("USER_id", id);
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.putString("RANNAME", ranname);
        editor.commit();
    }
    //清空数据
    public void deletinfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public user_info_sp getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        user_info_sp userInfo = new user_info_sp();
        userInfo.setUser_id(sp.getInt("USER_id", 0));
        userInfo.setUserName(sp.getString("USER_NAME", ""));
        userInfo.setPassword(sp.getString("PASSWORD", ""));
        userInfo.setRanName(sp.getString("RANNAME", ""));
        return userInfo;
    }


    /**
     * userInfo中是否有数据
     */
    public user_info_sp hasUserInfo(Context context) {
        user_info_sp userInfo = getUserInfo(context);
        if (userInfo != null) {
            if ((!TextUtils.isEmpty(userInfo.getUserName())) && (!TextUtils.isEmpty(userInfo.getPassword()))) {//有数据
                return userInfo;
            } else {
                return null;
            }
        }
        return null;
    }

}
