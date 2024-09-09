import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.rachmadiansah.tanjung.kuis.AppDatabase;
import com.rachmadiansah.tanjung.kuis.Mahasiswa;
import com.rachmadiansah.tanjung.kuis.R;

public class TambahActivity extends AppCompatActivity {

    private EditText etNamaLengkap, etNim;
    private Spinner spProgramStudi;
    private Button btnSimpan;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaLengkap = findViewById(R.id.et_nama_lengkap);
        etNim = findViewById(R.id.et_nim);
        spProgramStudi = findViewById(R.id.sp_program_studi);
        btnSimpan = findViewById(R.id.btn_simpan);

        // Initialize Room Database
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mahasiswa_db")
                .allowMainThreadQueries()
                .build();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert new Mahasiswa into the database
                Object Mahasiwa;
                Mahasiswa mahasiswa;
                Mahasiwa. mahasiswa = new Mahasiswa();
                mahasiswa.namaLengkap = etNamaLengkap.getText().toString();
                mahasiswa.nim = etNim.getText().toString();
                mahasiswa.programStudi = spProgramStudi.getSelectedItem().toString();

                db.mahasiswaDao().insert(mahasiswa);

                // Finish this activity and return to the main activity
                finish();
            }
        });
    }
}
