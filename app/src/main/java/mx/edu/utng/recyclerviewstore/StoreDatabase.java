package mx.edu.utng.recyclerviewstore;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Store.class}, version = 1, exportSchema = false)
public abstract class StoreDatabase extends RoomDatabase {
    public abstract StoreDao getStoreDao();
}
