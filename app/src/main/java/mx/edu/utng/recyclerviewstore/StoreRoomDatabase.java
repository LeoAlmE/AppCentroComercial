package mx.edu.utng.recyclerviewstore;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Store.class}, version = 1, exportSchema = false)

public abstract class StoreRoomDatabase extends RoomDatabase {

    public abstract StoreDao storeDao();

    private static volatile StoreRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static StoreRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StoreRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StoreRoomDatabase.class, "store_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
