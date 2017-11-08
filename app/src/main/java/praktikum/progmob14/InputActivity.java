package praktikum.progmob14;

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
                showDialog();
            }
        });
    }

    //Menampilkan Alert Dialog
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //Set Title Dialog
        alertDialogBuilder.setTitle("Hasil");

        //Mengambil Hasil Inputan
        String nama = String.valueOf(inputNama.getText().toString());
        String alamat = String.valueOf(inputAlamat.getText().toString());

        int gender = jenisKelamin.getCheckedRadioButtonId();
        jkelamin = (RadioButton) findViewById(gender);
        String kelamin = String.valueOf(jkelamin.getText().toString());

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

        //Set Pesan Dialog
        alertDialogBuilder.
                setMessage("Nama    : "+nama+"\nAlamat  : "+alamat+"\nJenis Kelamin : "+kelamin+
                        "\nAktivitas yang disukai   : \n"+hobi+"Aktivitas sering dilakukan   : "+hasilAktivitas);

        //Membuat Alert Dialog dari Builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //Menampilkan Alert Dialog
        alertDialog.show();
    }
}
