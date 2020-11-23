package mx.edu.utng.recyclerviewstore;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class StoreLab {
    @SuppressLint("StaticFieldLeak")
    private static StoreLab sStoreLab;

    private StoreDao mStoreDao;

    private StoreLab(Context context) {
        Context appContext = context.getApplicationContext();
        StoreDatabase database = Room.databaseBuilder(appContext, StoreDatabase.class, "store_db")
                .allowMainThreadQueries().build();
        mStoreDao = database.getStoreDao();
    }

    public static StoreLab get(Context context) {
        if (sStoreLab == null) {
            sStoreLab = new StoreLab(context);
        }
        return sStoreLab;
    }

    public List<Store> getStores() {
        return mStoreDao.getStores();
    }

    public void addStore(Store store) {
        mStoreDao.addStore(store);
    }

    public void deleteStore(String nombreStore) {
        mStoreDao.deleteById(nombreStore);
    }

}
