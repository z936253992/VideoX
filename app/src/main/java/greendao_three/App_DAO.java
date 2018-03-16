package greendao_three;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuqi on 2017/12/14.
 */
//在Application层，写两个方法，用于获取DaoMaster和DaoSession
public class App_DAO extends Application {
    private App_DAO Instance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    public App_DAO getInstance() {
        if (Instance == null) {
            Instance = this;
        }
        return Instance;
    }
          /**
 30      * 获取DaoMaster
 31      *
 32      * @param context
 33      * @return
 34      */
          public static DaoMaster getDaoMaster(Context context) {
              if (daoMaster == null) {
                  DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, "THREE.db", null);
                  daoMaster = new DaoMaster(helper.getWritableDatabase());
              }
              return daoMaster;
          }

           /**
 48      * 获取DaoSession对象
 49      *
 50      * @param context
 51      * @return
 52      */
           public static DaoSession getDaoSession(Context context) {
                if (daoSession == null) {
                    if (daoMaster == null) {
                        getDaoMaster(context);
                    }
                    daoSession = daoMaster.newSession();
                }
                return daoSession;
          }
}
