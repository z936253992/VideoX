package greendao_three;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuqi on 2017/12/14.
 */
@Entity
public class User_call {

    @Property(nameInDb = "User_id")
    private  int User_id;
    @Property(nameInDb = "User_ran")
    private  String User_ran;
    @Property(nameInDb = "Call_info")
    private  String Call_info;
    @Property(nameInDb = "Call_sety")
    private  int Call_sety;
    @Property(nameInDb = "Call_data")
    private  String Call_data;
    @Property(nameInDb = "List_id")
    private  int List_id;
    @Generated(hash = 1024894649)
    public User_call(int User_id, String User_ran, String Call_info, int Call_sety,
            String Call_data, int List_id) {
        this.User_id = User_id;
        this.User_ran = User_ran;
        this.Call_info = Call_info;
        this.Call_sety = Call_sety;
        this.Call_data = Call_data;
        this.List_id = List_id;
    }
    @Generated(hash = 722396966)
    public User_call() {
    }
    public int getList_id() {
        return this.List_id;
    }
    public void setList_id(int List_id) {
        this.List_id = List_id;
    }
    public String getCall_data() {
        return this.Call_data;
    }
    public void setCall_data(String Call_data) {
        this.Call_data = Call_data;
    }
    public int getCall_sety() {
        return this.Call_sety;
    }
    public void setCall_sety(int Call_sety) {
        this.Call_sety = Call_sety;
    }
    public String getCall_info() {
        return this.Call_info;
    }
    public void setCall_info(String Call_info) {
        this.Call_info = Call_info;
    }
    public String getUser_ran() {
        return this.User_ran;
    }
    public void setUser_ran(String User_ran) {
        this.User_ran = User_ran;
    }
    public int getUser_id() {
        return this.User_id;
    }
    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }


}
