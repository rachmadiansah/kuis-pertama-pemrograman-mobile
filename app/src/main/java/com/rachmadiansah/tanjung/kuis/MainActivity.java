package com.rachmadiansah.tanjung.kuis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity {
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ListView;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.room.Room;

    import com.google.android.material.floatingactionbutton.FloatingActionButton;

    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        private ListView lvMahasiswa;
        private FloatingActionButton fabTambah;
        private AppDatabase db;
        private MahasiswaAdapter mahasiswaAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lvMahasiswa = findViewById(R.id.lv_mahasiswa);
            fabTambah = findViewById(R.id.fab_tambah);

            // Initialize Room Database
            db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mahasiswa_db")
                    .allowMainThreadQueries()
                    .build();

            // Fetch all mahasiswa from database
            List<Mahasiswa> mahasiswaList = db.mahasiswaDao().getAll();

            // Set up the adapter
            mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaList);
            lvMahasiswa.setAdapter(mahasiswaAdapter);

            // Floating Action Button to add a new Mahasiswa
            fabTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                    startActivity(intent);
                }
            });

            // Click on list item to edit or delete
            lvMahasiswa.setOnItemClickListener((parent, view, position, id) -> {
                Mahasiswa mahasiswa = mahasiswaList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("mahasiswaId", mahasiswa.id);
                startActivity(intent);
            });
        }

        @Override
        protected void onResume() {
            super.onResume();
            // Refresh the data when returning to this activity
            mahasiswaAdapter.updateData(db.mahasiswaDao().getAll());
        }
    }

}
