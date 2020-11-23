package mx.edu.utng.recyclerviewstore;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StoreDao {

    @Insert
    void addStore(Store store);

    @Update
    void updateStore(Store store);

    @Query("DELETE FROM Store WHERE nombre=:nombreStore")
    void deleteById(String nombreStore);

    @Query("SELECT * FROM Store")
    List<Store> getStores();

    @Query("SELECT * FROM Store WHERE nombre LIKE :nom")
    Store getStore(String nom);

}
