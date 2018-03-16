package greendao_three;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuqi on 2017/12/19.
 */
@Entity
public class User_magess {
    @Id
    private Long id;
    @Property(nameInDb = "User_id")
    private  int User_id;
    @Property(nameInDb = "User_magess")
    private  String User_magess;
    public String getUser_magess() {
        return this.User_magess;
    }
    public void setUser_magess(String User_magess) {
        this.User_magess = User_magess;
    }
    public int getUser_id() {
        return this.User_id;
    }
    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 896997328)
    public User_magess(Long id, int User_id, String User_magess) {
        this.id = id;
        this.User_id = User_id;
        this.User_magess = User_magess;
    }
    @Generated(hash = 398346133)
    public User_magess() {
    }
}
