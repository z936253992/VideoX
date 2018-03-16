package greendao_three;

import android.content.Context;
import android.util.Log;

import com.example.liuqi.project_three.three_mian;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import sorket_three.Msg_three;
import usermage.UserManage;
import usermage.user_info_sp;

/**
 * Created by liuqi on 2017/12/14.
 */

public class greedao_use {
    private DaoSession daoSession;
    private User_callDao User_call;
    private User_infoDao User_info;
    private Reward_listDao Reward_list;
    private User_magessDao User_magess;
    private Context context;
    public greedao_use(Context context ){
        daoSession = App_DAO.getDaoSession(context); // 获取DaoSession
        User_call = daoSession.getUser_callDao(); // 获取CALL 可对User进行操作
        User_info = daoSession.getUser_infoDao(); // 获取CALL 可对User进行操作
        Reward_list = daoSession.getReward_listDao(); // 获取CALL 可对User进行操作
        User_magess = daoSession.getUser_magessDao(); // 获取CALL 可对User进行操作
        this.context=context;
    }
    /**
     * Insert数据
     */
    //添加聊天数据
    public void insert(User_call call){
        User_call.insert(call);
    }
    //添加用户数据
    public void infoinsert(User_info call){
        User_info.insert(call);
    }
    /**
     * Delete数据 根据id删除对应数据
     */
    //删除聊天数据
    public String delete(){
        User_call.deleteAll();
        return "ok";
    }
    /**
     * 获取历史消息
     */
    public List<Msg_three> QueryById(){
        List<Msg_three> msgList = new ArrayList<Msg_three>();
        user_info_sp sp= UserManage.getInstance().hasUserInfo(context);
        List<User_call> list = User_call.queryBuilder().where(User_callDao.Properties.User_id.eq(sp.getUser_id())).
                build().list();//得到数据列表
        for (int i = (list.size()>15?list.size()-15:0); i < list.size(); i++) {
            Msg_three msgs = new Msg_three(list.get(i).getCall_info(),list.get(i).getCall_sety());
            System.out.println("query:" +  list.get(i).getCall_info());
            msgList.add(msgs);
        }
        if(list.size()>0) {
            Msg_three msgs = new Msg_three(list.get(list.size()-1).getCall_data(),4);
            msgList.add(msgs);
        }
        //
        //

        if (msgList!=null) {
            return msgList;
        }
        return  null;
    }
    public greendao_three.User_info userinfo(int i){
        user_info_sp sp= UserManage.getInstance().hasUserInfo(context);
        List<User_info> list = User_info.queryBuilder().where(User_infoDao.Properties.User_id.eq(sp.getUser_id())).
                build().list();//得到数据列表
        if(list.size()>0) {
            greendao_three.User_info userinfo=list.get(0);
            return userinfo;
        }
        return null;
    }
    public void magess(User_magess call,int id){
        User_magess.deleteByKey((long)id);
        User_magess.insert(call);
    }
    public String showmage(int i){
        List<User_magess> list = User_magess.queryBuilder().where(User_magessDao.Properties.User_id.eq(i)).
                build().list();//得到数据列表
        if(list.size()>0) {
            String info=list.get(0).getUser_magess();
            return info;
        }
        return null;
    }
//    /**
//     * Update数据 根据id更新对应的数据
//     * @param view
//     */
//    public void update(View view){
//
//        User user = new User();
//        user.setId(2l);
//        user.setUsername("update");
//        user.setPassword("update_psw");
//
//        userDao.update(user);
//    }
//
//    /**
//     * Query数据
//     * @param view
//     */
//    public void query(View view){
//        QueryBuilder<User> queryBuilder = userDao.queryBuilder();
//        List<User> userList = queryBuilder.list(); // 使用list进行查询
//        System.out.println("userList : " + userList.toString());
//    }
//
//    /**
//     * DeleteAll 删除所有数据
//     * @param view
//     */
//    public void deleteAll(View view){
//        userDao.deleteAll();
//    }
//


}
