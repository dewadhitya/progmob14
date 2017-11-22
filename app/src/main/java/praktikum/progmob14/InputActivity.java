package praktikum.progmob14;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by Dewa Adhitya on 11/6/2017.
 */

public class InputActivity extends AppCompatActivity {
    MaterialEditText inputNama, inputAlamat;
    RadioGroup jenisKelamin;
    RadioButton jkelamin;
    CheckBox hbJogging, hbBersepeda, hbMembaca, hbMenari, hbMelukis, hbBermain;
    SeekBar aktivitas;
    Button simpanHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_form);

        //Inisialisasi
        inputNama = (MaterialEditText) findViewById(R.id.input_nama);
        inputAlamat = (MaterialEditText) findViewById(R.id.input_alamat);
        jenisKelamin = (RadioGroup) findViewById(R.id.jenis_kelamin);
        hbJogging = (CheckBox) findViewById(R.id.hb_jogging);
        hbBersepeda = (CheckBox) findViewById(R.id.hb_bersepeda);
        hbMembaca = (CheckBox) findViewById(R.id.hb_membaca);
        hbMenari = (CheckBox) findViewById(R.id.hb_menari);
        hbMelukis = (CheckBox) findViewById(R.id.hb_melukis);
        hbBermain = (CheckBox) findViewById(R.id.hb_bermain);
        aktivitas = (SeekBar) findViewById(R.id.aktivitas);
        simpanHasil = (Button) findViewById(R.id.simpan);

        simpanHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validasi Inputan
                if (inputNama.getText().toString().length()==0){
                    inputNama.setError("Nama diperlukan !");
                }
                else if(inputAlamat.getText().toString().length()==0){
                    inputAlamat.setError("Alamat diperlukan !");
                }
                else if(!inputNama.getText().toString().trim().matches("[a-zA-Z]+")){
                    inputNama.setError("Format Nama Salah !");
                }
                else{
                    showDialog();
                }
            }
        });
    }

    //Menampilkan Alert Dialog
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //Set Title Dialog
        alertDialogBuilder.setTitle("Apakah ingin mengkonfirmasi?");

        //Mengambil Hasil Inputan
        final String nama = String.valueOf(inputNama.getText().toString());
        final String alamat = String.valueOf(inputAlamat.getText().toString());

        int gender = jenisKelamin.getCheckedRadioButtonId();
        jkelamin = (RadioButton) findViewById(gender);
        final String kelamin = String.valueOf(jkelamin.getText().toString());

        //Mengambil hasil inputan checkbox
        String hobi = "";
        if(hbJogging.isChecked()){
            hobi+="- Jogging\n";
        }
        if(hbBersepeda.isChecked()){
            hobi+="- Bersepeda\n";
        }
        if(hbMembaca.isChecked()){
            hobi+="- Membaca\n";
        }
        if(hbMenari.isChecked()){
            hobi+="- Menari\n";
        }
        if(hbMelukis.isChecked()){
            hobi+="- Melukis\n";
        }
        if(hbBermain.isChecked()){
            hobi+="- Bermain\n";
        }

        String hasilAktivitas = "";
        int hAktivitas = aktivitas.getProgress();
        if (hAktivitas == 0){
            hasilAktivitas="5 hari sekali";
        }
        else if(hAktivitas == 1){
            hasilAktivitas="3 hari sekali";
        }
        else {
            hasilAktivitas="setiap hari";
        }

        //Deklarasi variabel tipe final ini untuk membawa data ke Activity Output
        final String finalHobi = hobi;
        final String finalHasilAktivitas = hasilAktivitas;

        //Set Pesan Dialog dari Input Data
        alertDialogBuilder
                .setMessage("Nama    : "+nama+"\nAlamat  : "+alamat+"\nJenis Kelamin : "+kelamin+
                        "\nAktivitas yang disukai   : \n"+hobi+"Aktivitas sering dilakukan   : "+hasilAktivitas)
                .setCancelable(false)
                .setPositiveButton("Konfirmasi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(InputActivity.this, OutputActivity.class);
                        intent.putExtra("nama",nama);
                        intent.putExtra("alamat",alamat);
                        intent.putExtra("kelamin",kelamin);
                        intent.putExtra("hobi", finalHobi);
                        intent.putExtra("hasilAktivitas", finalHasilAktivitas);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        //Membuat Alert Dialog dari Builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //Menampilkan Alert Dialog
        alertDialog.show();
    }

    //Dialog Exit
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }
}
