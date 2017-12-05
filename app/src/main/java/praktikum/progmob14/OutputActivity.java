package praktikum.progmob14;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dewa Adhitya on 11/13/2017.
 */

public class OutputActivity extends AppCompatActivity {
    TextView outputNama, outputAlamat, jenisKelamin, hobi, aktivitas;
    Button simpanDatabase, kembali;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_form);

        //MODUL 2 -- Untuk mengetahui cek Status Lifecycle pada Pesan Log
        Log.d(status, "The onCreate() event");
        //MODUL 2 -- END

        ///MODUL 2 -- MENGAMBIL DATA DARI ACTIVITY INPUT
        //Inisialisasi Variabel pada output_from
        outputNama = (TextView) findViewById(R.id.output_nama);
        outputAlamat = (TextView) findViewById(R.id.output_alamat);
        jenisKelamin = (TextView) findViewById(R.id.jenis_kelamin);
        hobi = (TextView) findViewById(R.id.hobi);
        aktivitas = (TextView) findViewById(R.id.aktivitas);

        //Inisialiasi Tombol kembali ke Input Activity
        kembali = (Button) findViewById(R.id.kembali);

        ///MODUL 3
        //Inisialisasi  Variabel Button ke Database
//        simpanDatabase = (Button) findViewById(R.id.simpan_database);
        ///MODUL 3 -- END

        ///MODUL 2
        //Mengambil data dari InputActivity dan menampilkannya
        outputNama.setText(getIntent().getStringExtra("nama"));
        outputAlamat.setText(getIntent().getStringExtra("alamat"));
        jenisKelamin.setText(getIntent().getStringExtra("kelamin"));
        hobi.setText(getIntent().getStringExtra("hobi"));
        aktivitas.setText(getIntent().getStringExtra("hasilAktivitas"));

        //Jika ingin kembali ke Inpu Activity
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause();
            }
        });

        ///MODUL 3
        //Menyimpan ke Database
//        simpanDatabase.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                final String nama = String.valueOf(outputNama.getText().toString());
//                final String alamat = String.valueOf(outputAlamat.getText().toString());
//                final String haktivitas = String.valueOf(aktivitas.getText().toString());
//                DataHelper dataHelper = new DataHelper(OutputActivity.this);
//                dataHelper.insert_data(nama,alamat,haktivitas);
//                Toast.makeText(OutputActivity.this, "Data telah disimpan di Database", Toast.LENGTH_LONG).show();
//            }
//        });

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
        Toast.makeText(getApplicationContext(), "Yuhuu lanjut lagi~", Toast.LENGTH_LONG).show();
    }
    /**Method ini Dipanggil ketika activity berhenti sementara tidak menerima inputan user
     dan tidak mengeksekusi kode apapun.*/
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(status,"The onPause() event ");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Yakin mau kembali?");
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(OutputActivity.this, InputActivity.class);
//                        startActivity(intent);
                        onBackPressed();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        //Membuat Alert Dialog dari Builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //Menampilkan Alert Dialog
        alertDialog.show();
        //Toast.makeText(getApplicationContext(),"Sebentar dulu bos!", Toast.LENGTH_LONG).show();
    }
    /**Method ini dipanggil ketika activity sudah tidak terlihat pada user.*/
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(status,"The onStop() event");
        Toast.makeText(getApplicationContext(),"di-Setoop dulu ya~", Toast.LENGTH_LONG).show();
    }
    /**Method ini dipanggil sebelum sebuah activity dimatikan (di destroy).*/
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(status,"The onDestroy() event");
        Toast.makeText(getApplicationContext(), "Sampai ketemu lagi !", Toast.LENGTH_LONG).show();
    }
}
