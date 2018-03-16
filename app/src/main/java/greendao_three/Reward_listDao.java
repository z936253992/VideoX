package greendao_three;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "REWARD_LIST".
*/
public class Reward_listDao extends AbstractDao<Reward_list, Void> {

    public static final String TABLENAME = "REWARD_LIST";

    /**
     * Properties of entity Reward_list.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property User_id = new Property(0, int.class, "User_id", false, "User_id");
        public final static Property Reward_info = new Property(1, String.class, "Reward_info", false, "Reward_info");
        public final static Property Reward_id = new Property(2, int.class, "Reward_id", false, "Reward_id");
        public final static Property Reward_sety = new Property(3, int.class, "Reward_sety", false, "Reward_sety");
        public final static Property User_oid = new Property(4, int.class, "User_oid", false, "User_oid");
        public final static Property Reward_flag = new Property(5, int.class, "Reward_flag", false, "Reward_flag");
        public final static Property Reward_true = new Property(6, int.class, "Reward_true", false, "Reward_true");
        public final static Property Reward_data = new Property(7, String.class, "Reward_data", false, "Reward_data");
        public final static Property Reward_level = new Property(8, int.class, "reward_level", false, "reward_level");
    }


    public Reward_listDao(DaoConfig config) {
        super(config);
    }
    
    public Reward_listDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"REWARD_LIST\" (" + //
                "\"User_id\" INTEGER NOT NULL ," + // 0: User_id
                "\"Reward_info\" TEXT," + // 1: Reward_info
                "\"Reward_id\" INTEGER NOT NULL ," + // 2: Reward_id
                "\"Reward_sety\" INTEGER NOT NULL ," + // 3: Reward_sety
                "\"User_oid\" INTEGER NOT NULL ," + // 4: User_oid
                "\"Reward_flag\" INTEGER NOT NULL ," + // 5: Reward_flag
                "\"Reward_true\" INTEGER NOT NULL ," + // 6: Reward_true
                "\"Reward_data\" TEXT," + // 7: Reward_data
                "\"reward_level\" INTEGER NOT NULL );"); // 8: reward_level
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REWARD_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Reward_list entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getUser_id());
 
        String Reward_info = entity.getReward_info();
        if (Reward_info != null) {
            stmt.bindString(2, Reward_info);
        }
        stmt.bindLong(3, entity.getReward_id());
        stmt.bindLong(4, entity.getReward_sety());
        stmt.bindLong(5, entity.getUser_oid());
        stmt.bindLong(6, entity.getReward_flag());
        stmt.bindLong(7, entity.getReward_true());
 
        String Reward_data = entity.getReward_data();
        if (Reward_data != null) {
            stmt.bindString(8, Reward_data);
        }
        stmt.bindLong(9, entity.getReward_level());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Reward_list entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getUser_id());
 
        String Reward_info = entity.getReward_info();
        if (Reward_info != null) {
            stmt.bindString(2, Reward_info);
        }
        stmt.bindLong(3, entity.getReward_id());
        stmt.bindLong(4, entity.getReward_sety());
        stmt.bindLong(5, entity.getUser_oid());
        stmt.bindLong(6, entity.getReward_flag());
        stmt.bindLong(7, entity.getReward_true());
 
        String Reward_data = entity.getReward_data();
        if (Reward_data != null) {
            stmt.bindString(8, Reward_data);
        }
        stmt.bindLong(9, entity.getReward_level());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Reward_list readEntity(Cursor cursor, int offset) {
        Reward_list entity = new Reward_list( //
            cursor.getInt(offset + 0), // User_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Reward_info
            cursor.getInt(offset + 2), // Reward_id
            cursor.getInt(offset + 3), // Reward_sety
            cursor.getInt(offset + 4), // User_oid
            cursor.getInt(offset + 5), // Reward_flag
            cursor.getInt(offset + 6), // Reward_true
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // Reward_data
            cursor.getInt(offset + 8) // reward_level
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Reward_list entity, int offset) {
        entity.setUser_id(cursor.getInt(offset + 0));
        entity.setReward_info(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setReward_id(cursor.getInt(offset + 2));
        entity.setReward_sety(cursor.getInt(offset + 3));
        entity.setUser_oid(cursor.getInt(offset + 4));
        entity.setReward_flag(cursor.getInt(offset + 5));
        entity.setReward_true(cursor.getInt(offset + 6));
        entity.setReward_data(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setReward_level(cursor.getInt(offset + 8));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Reward_list entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Reward_list entity) {
        return null;
    }

    @Override
    public boolean hasKey(Reward_list entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}