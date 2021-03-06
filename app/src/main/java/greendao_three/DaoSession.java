package greendao_three;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import greendao_three.Reward_list;
import greendao_three.User_call;
import greendao_three.User_info;
import greendao_three.User_magess;

import greendao_three.Reward_listDao;
import greendao_three.User_callDao;
import greendao_three.User_infoDao;
import greendao_three.User_magessDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig reward_listDaoConfig;
    private final DaoConfig user_callDaoConfig;
    private final DaoConfig user_infoDaoConfig;
    private final DaoConfig user_magessDaoConfig;

    private final Reward_listDao reward_listDao;
    private final User_callDao user_callDao;
    private final User_infoDao user_infoDao;
    private final User_magessDao user_magessDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        reward_listDaoConfig = daoConfigMap.get(Reward_listDao.class).clone();
        reward_listDaoConfig.initIdentityScope(type);

        user_callDaoConfig = daoConfigMap.get(User_callDao.class).clone();
        user_callDaoConfig.initIdentityScope(type);

        user_infoDaoConfig = daoConfigMap.get(User_infoDao.class).clone();
        user_infoDaoConfig.initIdentityScope(type);

        user_magessDaoConfig = daoConfigMap.get(User_magessDao.class).clone();
        user_magessDaoConfig.initIdentityScope(type);

        reward_listDao = new Reward_listDao(reward_listDaoConfig, this);
        user_callDao = new User_callDao(user_callDaoConfig, this);
        user_infoDao = new User_infoDao(user_infoDaoConfig, this);
        user_magessDao = new User_magessDao(user_magessDaoConfig, this);

        registerDao(Reward_list.class, reward_listDao);
        registerDao(User_call.class, user_callDao);
        registerDao(User_info.class, user_infoDao);
        registerDao(User_magess.class, user_magessDao);
    }
    
    public void clear() {
        reward_listDaoConfig.clearIdentityScope();
        user_callDaoConfig.clearIdentityScope();
        user_infoDaoConfig.clearIdentityScope();
        user_magessDaoConfig.clearIdentityScope();
    }

    public Reward_listDao getReward_listDao() {
        return reward_listDao;
    }

    public User_callDao getUser_callDao() {
        return user_callDao;
    }

    public User_infoDao getUser_infoDao() {
        return user_infoDao;
    }

    public User_magessDao getUser_magessDao() {
        return user_magessDao;
    }

}
