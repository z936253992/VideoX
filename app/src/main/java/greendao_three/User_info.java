package greendao_three;

import android.content.SyncRequest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuqi on 2017/12/14.
 */
@Entity
public class User_info {

    @Property(nameInDb = "User_id")
    private  int User_id;
    @Property(nameInDb = "User_name")
    private  String User_name;
    @Property(nameInDb = "User_paswd")
    private  String User_paswd;
    @Property(nameInDb = "User_ranname")
    private  String User_ranname;
    @Property(nameInDb = "User_ident")
    private  String User_ident;
    @Property(nameInDb = "User_age")
    private  int User_age;
    @Property(nameInDb = "User_sex")
    private  String User_sex;
    @Property(nameInDb = "User_major")
    private String User_major;
    @Property(nameInDb = "User_ap")
    private  int User_ap;
    @Property(nameInDb = "User_leve")
    private  int User_leve;
    @Property(nameInDb = "User_gradit")
    private  int User_gradit;
    @Property(nameInDb = "User_reward")
    private  int User_reward;
    @Property(nameInDb = "User_telephone")
    private  int User_telephone;
    @Property(nameInDb = "User_image")
    private String User_image;
    @Generated(hash = 561673906)
    public User_info(int User_id, String User_name, String User_paswd,
            String User_ranname, String User_ident, int User_age, String User_sex,
            String User_major, int User_ap, int User_leve, int User_gradit,
            int User_reward, int User_telephone, String User_image) {
        this.User_id = User_id;
        this.User_name = User_name;
        this.User_paswd = User_paswd;
        this.User_ranname = User_ranname;
        this.User_ident = User_ident;
        this.User_age = User_age;
        this.User_sex = User_sex;
        this.User_major = User_major;
        this.User_ap = User_ap;
        this.User_leve = User_leve;
        this.User_gradit = User_gradit;
        this.User_reward = User_reward;
        this.User_telephone = User_telephone;
        this.User_image = User_image;
    }
    @Generated(hash = 1734137856)
    public User_info() {
    }
    public String getUser_image() {
        return this.User_image;
    }
    public void setUser_image(String User_image) {
        this.User_image = User_image;
    }
    public int getUser_telephone() {
        return this.User_telephone;
    }
    public void setUser_telephone(int User_telephone) {
        this.User_telephone = User_telephone;
    }
    public int getUser_reward() {
        return this.User_reward;
    }
    public void setUser_reward(int User_reward) {
        this.User_reward = User_reward;
    }
    public int getUser_gradit() {
        return this.User_gradit;
    }
    public void setUser_gradit(int User_gradit) {
        this.User_gradit = User_gradit;
    }
    public int getUser_leve() {
        return this.User_leve;
    }
    public void setUser_leve(int User_leve) {
        this.User_leve = User_leve;
    }
    public int getUser_ap() {
        return this.User_ap;
    }
    public void setUser_ap(int User_ap) {
        this.User_ap = User_ap;
    }
    public String getUser_major() {
        return this.User_major;
    }
    public void setUser_major(String User_major) {
        this.User_major = User_major;
    }
    public String getUser_sex() {
        return this.User_sex;
    }
    public void setUser_sex(String User_sex) {
        this.User_sex = User_sex;
    }
    public int getUser_age() {
        return this.User_age;
    }
    public void setUser_age(int User_age) {
        this.User_age = User_age;
    }
    public String getUser_ident() {
        return this.User_ident;
    }
    public void setUser_ident(String User_ident) {
        this.User_ident = User_ident;
    }
    public String getUser_ranname() {
        return this.User_ranname;
    }
    public void setUser_ranname(String User_ranname) {
        this.User_ranname = User_ranname;
    }
    public String getUser_paswd() {
        return this.User_paswd;
    }
    public void setUser_paswd(String User_paswd) {
        this.User_paswd = User_paswd;
    }
    public String getUser_name() {
        return this.User_name;
    }
    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }
    public int getUser_id() {
        return this.User_id;
    }
    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }



}
