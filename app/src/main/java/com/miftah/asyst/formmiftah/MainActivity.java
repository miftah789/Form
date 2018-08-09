package com.miftah.asyst.formmiftah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String stringSatu;
    String stringDua;
    TextView textViewHasil;
    EditText editTextSatu;
    EditText editTextDua;
    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;
    float angkasatu;
    float angkadua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalkulator_layout);
        editTextSatu = findViewById(R.id.edit_text_satu);
        editTextDua = findViewById(R.id.edit_text_dua);
        btnTambah = findViewById(R.id.btn_tambah);
        btnKurang = findViewById(R.id.btn_kurang);
        btnKali = findViewById(R.id.btn_kali);
        btnBagi = findViewById(R.id.btn_bagi);
        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
        textViewHasil = findViewById(R.id.text_view_hasil);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_tambah:
                HasilTambah();
                break;
            case R.id.btn_kurang:
                HasilKurang();
                break;
            case R.id.btn_kali:
                HasilKali();
                break;
            case R.id.btn_bagi:
                HasilBagi();
                break;
        }
    }

    private void HasilTambah() {
        stringSatu = editTextSatu.getText().toString();
        stringDua = editTextDua.getText().toString();

        if (TextUtils.isEmpty(stringSatu)) {
            editTextSatu.setError("Angka Belum Diisi");
        } else if (TextUtils.isEmpty(stringDua)) {
            editTextDua.setError("Angka Belum Diisi");
        } else {
            angkasatu = Float.valueOf(editTextSatu.getText().toString());
            angkadua = Float.valueOf(editTextDua.getText().toString());
            float hasilTambah = angkasatu + angkadua;
            String hasil = Float.toString(hasilTambah);
            textViewHasil.setText("Hasil Penambahan = " + hasil);
        }
    }

    private void HasilKurang() {
        stringSatu = editTextSatu.getText().toString();
        stringDua = editTextDua.getText().toString();
        if (TextUtils.isEmpty(stringSatu)) {
            editTextSatu.setError("Angka Belum Diisi");
        } else if (TextUtils.isEmpty(stringDua)) {
            editTextDua.setError("Angka Belum Diisi");
        } else {
            angkasatu = Float.valueOf(editTextSatu.getText().toString());
            angkadua = Float.valueOf(editTextDua.getText().toString());
            float hasilKurang = angkasatu - angkadua;
            String hasil = Float.toString(hasilKurang);
            textViewHasil.setText("Hasil Pengurangan = " + hasil);
        }
    }

    private void HasilKali() {
        stringSatu = editTextSatu.getText().toString();
        stringDua = editTextDua.getText().toString();
        if (TextUtils.isEmpty(stringSatu)) {
            editTextSatu.setError("Angka Belum Diisi");
        } else if (TextUtils.isEmpty(stringDua)) {
            editTextDua.setError("Angka Belum Diisi");
        } else {
            angkasatu = Float.valueOf(editTextSatu.getText().toString());
            angkadua = Float.valueOf(editTextDua.getText().toString());
            float hasilKali = angkasatu * angkadua;
            String hasil = Float.toString(hasilKali);
            textViewHasil.setText("Hasil Perkalian = " + hasil);
        }
    }

    private void HasilBagi() {
        stringSatu = editTextSatu.getText().toString();
        stringDua = editTextDua.getText().toString();
        if (TextUtils.isEmpty(stringSatu)) {
            editTextSatu.setError("Angka Belum Diisi");
        } else if (TextUtils.isEmpty(stringDua)) {
            editTextDua.setError("Angka Belum Diisi");
        } else {
            angkasatu = Float.valueOf(editTextSatu.getText().toString());
            angkadua = Float.valueOf(editTextDua.getText().toString());
            if (angkadua == 0) {
                editTextDua.setError("Angka Tidak Boleh 0");
            } else {
                float hasilBagi = angkasatu / angkadua;
                String hasil = Float.toString(hasilBagi);
                textViewHasil.setText("Hasil Pembagian = " + hasil);
            }
        }
    }


}
