package praktikum.progmob14;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
                String nama = String.valueOf(inputNama.getText().toString());
                String alamat = String.valueOf(inputAlamat.getText().toString());

                int gender = jenisKelamin.getCheckedRadioButtonId();
                RadioButton jenis_kelamin = (RadioButton) findViewById(gender);
                String jKelamin = String.valueOf(jenis_kelamin.getText().toString());

                //// TODO: 11/6/2017 Ngambil hasil string dari Checkbox
                //// TODO: 11/6/2017 Ngambil hasil string dari Seekbar
            }
        });
    }
}
