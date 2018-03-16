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
 * DAO for table "USER_CALL".
*/
public class User_callDao extends AbstractDao<User_call, Void> {

    public static final String TABLENAME = "USER_CALL";

    /**
     * Properties of entity User_call.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property User_id = new Property(0, int.class, "User_id", false, "User_id");
        public final static Property User_ran = new Property(1, String.class, "User_ran", false, "User_ran");
        public final static Property Call_info = new Property(2, String.class, "Call_info", false, "Call_info");
        public final static Property Call_sety = new Property(3, int.class, "Call_sety", false, "Call_sety");
        public final static Property Call_data = new Property(4, String.class, "Call_data", false, "Call_data");
        public final static Property List_id = new Property(5, int.class, "List_id", false, "List_id");
    }


    public User_callDao(DaoConfig config) {
        super(config);
    }
    
    public User_callDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_CALL\" (" + //
                "\"User_id\" INTEGER NOT NULL ," + // 0: User_id
                "\"User_ran\" TEXT," + // 1: User_ran
                "\"Call_info\" TEXT," + // 2: Call_info
                "\"Call_sety\" INTEGER NOT NULL ," + // 3: Call_sety
                "\"Call_data\" TEXT," + // 4: Call_data
                "\"List_id\" INTEGER NOT NULL );"); // 5: List_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_CALL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User_call entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getUser_id());
 
        String User_ran = entity.getUser_ran();
        if (User_ran != null) {
            stmt.bindString(2, User_ran);
        }
 
        String Call_info = entity.getCall_info();
        if (Call_info != null) {
            stmt.bindString(3, Call_info);
        }
        stmt.bindLong(4, entity.getCall_sety());
 
        String Call_data = entity.getCall_data();
        if (Call_data != null) {
            stmt.bindString(5, Call_data);
        }
        stmt.bindLong(6, entity.getList_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User_call entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getUser_id());
 
        String User_ran = entity.getUser_ran();
        if (User_ran != null) {
            stmt.bindString(2, User_ran);
        }
 
        String Call_info = entity.getCall_info();
        if (Call_info != null) {
            stmt.bindString(3, Call_info);
        }
        stmt.bindLong(4, entity.getCall_sety());
 
        String Call_data = entity.getCall_data();
        if (Call_data != null) {
            stmt.bindString(5, Call_data);
        }
        stmt.bindLong(6, entity.getList_id());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public User_call readEntity(Cursor cursor, int offset) {
        User_call entity = new User_call( //
            cursor.getInt(offset + 0), // User_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // User_ran
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Call_info
            cursor.getInt(offset + 3), // Call_sety
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Call_data
            cursor.getInt(offset + 5) // List_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User_call entity, int offset) {
        entity.setUser_id(cursor.getInt(offset + 0));
        entity.setUser_ran(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCall_info(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCall_sety(cursor.getInt(offset + 3));
        entity.setCall_data(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setList_id(cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(User_call entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(User_call entity) {
        return null;
    }

    @Override
    public boolean hasKey(User_call entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
