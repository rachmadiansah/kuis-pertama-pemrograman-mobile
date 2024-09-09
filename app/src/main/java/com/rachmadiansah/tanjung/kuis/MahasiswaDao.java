package com.rachmadiansah.tanjung.kuis;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class MahasiswaDao {
    import androidx.room.Dao;
    import androidx.room.Delete;
    import androidx.room.Insert;
    import androidx.room.Query;
    import androidx.room.Update;

    import java.util.List;

    @Dao
    public interface MahasiswaDao {
        @Query("SELECT * FROM Mahasiswa")
        List<Mahasiswa> getAll();

        @Insert
        void insert(Mahasiswa mahasiswa);

        @Update
        void update(Mahasiswa mahasiswa);

        @Delete
        void delete(Mahasiswa mahasiswa);
    }

}
