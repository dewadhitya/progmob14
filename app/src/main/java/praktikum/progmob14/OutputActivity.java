package praktikum.progmob14;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dewa Adhitya on 11/13/2017.
 */

public class OutputActivity extends AppCompatActivity {
    TextView outputNama, outputAlamat, jenisKelamin, hobi, aktivitas;
    DataHelper dbHelper;
    Button simpanDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_form);

        ///MODUL 2 -- MENGAMBIL DATA DARI ACTIVITY INPUT
        //Inisialisasi Variabel pada output_from
        outputNama = (TextView) findViewById(R.id.output_nama);
        outputAlamat = (TextView) findViewById(R.id.output_alamat);
        jenisKelamin = (TextView) findViewById(R.id.jenis_kelamin);
        hobi = (TextView) findViewById(R.id.hobi);
        aktivitas = (TextView) findViewById(R.id.aktivitas);

        //Inisialisasi  Variabel Button ke Database
        simpanDatabase = (Button) findViewById(R.id.simpan_database);

        //Mengambil data dari InputActivity dan menampilkannya
        outputNama.setText(getIntent().getStringExtra("nama"));
        outputAlamat.setText(getIntent().getStringExtra("alamat"));
        jenisKelamin.setText(getIntent().getStringExtra("kelamin"));
        hobi.setText(getIntent().getStringExtra("hobi"));
        aktivitas.setText(getIntent().getStringExtra("hasilAktivitas"));

        //Menyimpan ke Database
        simpanDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tb_kuisioner('nama', 'alamat', 'aktivitas') values('outputNama','outputAlamat','aktivitas');");
            }
        });
    }

    //DoubleTap2Back --
    //Inisialisasi Tombol Back
    private boolean tombolBack = false;

    @Override
    public void onBackPressed() {
        if(!tombolBack){
            Toast.makeText(this,"Tekan Tombol Kembali sekali lagi!", Toast.LENGTH_SHORT).show();
            tombolBack = true;
        } else {
            super.onBackPressed();
        }
    }
}
