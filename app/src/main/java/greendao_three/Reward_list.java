package greendao_three;

import android.provider.ContactsContract;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuqi on 2017/12/14.
 */
@Entity
public class Reward_list {

    @Property(nameInDb = "User_id")
    private  int User_id;
    @Property(nameInDb = "Reward_info")
    private  String Reward_info;
    @Property(nameInDb = "Reward_id")
    private  int Reward_id;
    @Property(nameInDb = "Reward_sety")
    private  int Reward_sety;
    @Property(nameInDb = "User_oid")
    private  int User_oid;
    @Property(nameInDb = "Reward_flag")
    private  int Reward_flag;
    @Property(nameInDb = "Reward_true")
    private  int Reward_true;
    @Property(nameInDb = "Reward_data")
    private String Reward_data;
    @Property(nameInDb = "reward_level")
    private  int reward_level;
    @Generated(hash = 1739834400)
    public Reward_list(int User_id, String Reward_info, int Reward_id,
            int Reward_sety, int User_oid, int Reward_flag, int Reward_true,
            String Reward_data, int reward_level) {
        this.User_id = User_id;
        this.Reward_info = Reward_info;
        this.Reward_id = Reward_id;
        this.Reward_sety = Reward_sety;
        this.User_oid = User_oid;
        this.Reward_flag = Reward_flag;
        this.Reward_true = Reward_true;
        this.Reward_data = Reward_data;
        this.reward_level = reward_level;
    }
    @Generated(hash = 1731149515)
    public Reward_list() {
    }
    public int getReward_level() {
        return this.reward_level;
    }
    public void setReward_level(int reward_level) {
        this.reward_level = reward_level;
    }
    public String getReward_data() {
        return this.Reward_data;
    }
    public void setReward_data(String Reward_data) {
        this.Reward_data = Reward_data;
    }
    public int getReward_true() {
        return this.Reward_true;
    }
    public void setReward_true(int Reward_true) {
        this.Reward_true = Reward_true;
    }
    public int getReward_flag() {
        return this.Reward_flag;
    }
    public void setReward_flag(int Reward_flag) {
        this.Reward_flag = Reward_flag;
    }
    public int getUser_oid() {
        return this.User_oid;
    }
    public void setUser_oid(int User_oid) {
        this.User_oid = User_oid;
    }
    public int getReward_sety() {
        return this.Reward_sety;
    }
    public void setReward_sety(int Reward_sety) {
        this.Reward_sety = Reward_sety;
    }
    public int getReward_id() {
        return this.Reward_id;
    }
    public void setReward_id(int Reward_id) {
        this.Reward_id = Reward_id;
    }
    public String getReward_info() {
        return this.Reward_info;
    }
    public void setReward_info(String Reward_info) {
        this.Reward_info = Reward_info;
    }
    public int getUser_id() {
        return this.User_id;
    }
    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

}
