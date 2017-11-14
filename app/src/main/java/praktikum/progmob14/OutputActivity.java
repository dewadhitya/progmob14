package praktikum.progmob14;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dewa Adhitya on 11/13/2017.
 */

public class OutputActivity extends AppCompatActivity {
    TextView outputNama, outputAlamat, jenisKelamin, hobi, aktivitas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_form);

        ///MODUL 2 -- MENGAMBIL DATA DARI ACTIVITY INPUT
        //Inisialisasi Variabel pada outuput_from
        outputNama = (TextView) findViewById(R.id.output_nama);
        outputAlamat = (TextView) findViewById(R.id.output_alamat);
        jenisKelamin = (TextView) findViewById(R.id.jenis_kelamin);
        hobi = (TextView) findViewById(R.id.hobi);
        aktivitas = (TextView) findViewById(R.id.aktivitas);

        //Mengambil data dari InputActivity
        outputNama.setText(getIntent().getStringExtra("nama"));
        outputAlamat.setText(getIntent().getStringExtra("alamat"));
        jenisKelamin.setText(getIntent().getStringExtra("kelamin"));
        hobi.setText(getIntent().getStringExtra("hobi"));
        aktivitas.setText(getIntent().getStringExtra("hasilAktivitas"));
    }

    //MODUL 2 --
    //Untuk mengetahui status dari Lifecycle di Pesan Log
    String status = "Android: ";
    /**Method ini dipanggil ketika activity sudah terlihat pada user. */
    @Override
    protected void onStart(){
        super.onStart();
        Log.d( status,"The onStart() event");
    }
    /**Method ini dipanggil ketika activity mulai berinteraksi dengan user.*/
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(status, "The onResume() event");
    }
    /**Method ini Dipanggil ketika activity berhenti sementara tidak menerima inputan user
     dan tidak mengeksekusi kode apapun.*/
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(status,"The onPause() event ");
        Toast.makeText(getApplicationContext(), "On Pause Method Applied in OutputActivity", Toast.LENGTH_LONG).show();
    }
    /**Method ini dipanggil ketika activity sudah tidak terlihat pada user.*/
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(status,"The onStop() event");
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
