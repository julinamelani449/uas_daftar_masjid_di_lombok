package com.julina.lombokseribumasjid;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.julina.lombokseribumasjid.model.MasidLombok;

public class FormMasjidActivity extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilNama, tilDesa, tilKecamatan;
    Spinner spnKabupaten;
    final String[] tipe = {MasidLombok.LOMBOKBARAT, MasidLombok.LOMBOKTENGAH, MasidLombok.LOMBOKTIMUR, MasidLombok.LOMBOKUTARA, MasidLombok.MATARAM};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_masjid);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        tilNama = findViewById(R.id.til_nama_masjid);
        tilDesa = findViewById(R.id.til_desa);
        tilKecamatan = findViewById(R.id.til_kecamatan);
        spnKabupaten = findViewById(R.id.spn_kabupaten);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipe
        );
        spnKabupaten.setAdapter(adapter);
        spnKabupaten.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            MasidLombok tr = new MasidLombok();
            tr.setNamaMasjid(tilNama.getEditText().getText().toString());
            tr.setDesa(tilDesa.getEditText().getText().toString());
            tr.setKecamatan(tilKecamatan.getEditText().getText().toString());
            tr.setKabupaten(spnKabupaten.getSelectedItem().toString());
            SharedPreferenceUtility.addMasjid(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);


        }
    }

    private boolean isDataValid() {
        if (tilNama.getEditText().getText().toString().isEmpty() || tilDesa.getEditText().getText().toString().isEmpty() || tilKecamatan.getEditText().getText().toString().isEmpty() || spnKabupaten.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}