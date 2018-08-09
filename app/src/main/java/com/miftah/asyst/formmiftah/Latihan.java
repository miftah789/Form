package com.miftah.asyst.formmiftah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.miftah.asyst.formmiftah.utility.Constant;

import java.util.ArrayList;

public class Latihan extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    Button btnSatu;
    EditText editTextSatu;
    String stringSatu, stringDua;
    TextView textViewSatu;
    RadioGroup radioGroupSatu;
    CheckBox checkBoxSatu, checkBoxDua, checkBoxTiga;
    String nasiGoreng = "";
    String bakso = "";
    String mieAyam = "";
    Spinner citySpinner;
    String citySelect;
    String foods = "";
    Switch switchSatu;
    ToggleButton toggleSatu;

    ArrayList<String> listFood = new ArrayList<>();
    ArrayList<String> listCity = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSatu = findViewById(R.id.btn_tombol);
        editTextSatu = findViewById(R.id.edit_text_first);
        textViewSatu = findViewById(R.id.text_view_first);

        radioGroupSatu = findViewById(R.id.radio);
        radioGroupSatu.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radioButton_male)).setChecked(true);

        checkBoxSatu = findViewById(R.id.checkbox_satu);
        checkBoxDua = findViewById(R.id.checkbox_dua);
        checkBoxTiga = findViewById(R.id.checkbox_tiga);
        checkBoxSatu.setOnCheckedChangeListener(this);
        checkBoxDua.setOnCheckedChangeListener(this);
        checkBoxTiga.setOnCheckedChangeListener(this);

        switchSatu = findViewById(R.id.switch_satu);
        toggleSatu = findViewById(R.id.tb_satu);

        switchSatu.setOnCheckedChangeListener(this);
        toggleSatu.setOnCheckedChangeListener(this);

        citySpinner = findViewById(R.id.spinner_city);
        citySpinner.setOnItemSelectedListener(this);

        listCity.add("Banyuwangi");
        listCity.add("Lumajang");
        listCity.add("Surabaya");
        listCity.add("Malang");
        listCity.add("Bandung");


        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listCity);
        citySpinner.setAdapter(cityAdapter);

        btnSatu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_tombol:
                stringSatu = editTextSatu.getText().toString();
                if (!TextUtils.isEmpty(stringSatu)) {
//                    Toast.makeText(getApplicationContext(), "Hello "+ stringSatu,Toast.LENGTH_SHORT).show();

                    foods = "";
                    for (int i = 0; i < listFood.size(); i++) {
                        foods = foods + " " + listFood.get(i);
                    }
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirmation").setCancelable(false).setMessage("are you sure?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Latihan.this, ResultActivity.class);
                                    String result = "Nama = " + stringSatu + "\nJenis Kelamin = " + stringDua + "\nMakanan Fav = " + foods + "\nKota = " + citySelect;
                                    intent.putExtra(Constant.KEY_RESULT, result);
                                    startActivity(intent);
                                }
                            }).setNegativeButton("No", null).show();
//                    textViewSatu.setText("Nama = "+stringSatu + "\nJenis Kelamin = " + stringDua +
//                            "\nMakanan Fav = " +foods+"\nKota = "+citySelect);
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButton_male:
                stringDua = "Male";
                break;
            case R.id.radioButton_female:
                stringDua = "Female";
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.checkbox_satu:
                if (isChecked) {
                    listFood.add("Nasi Goreng");
                    //nasiGoreng = " Nasi Goreng";
                } else {
                    listFood.remove("Nasi Goreng");
                    //nasiGoreng ="";
                }
                break;
            case R.id.checkbox_dua:
                if (isChecked) {
                    listFood.add("Bakso");
                    //bakso = " Bakso";
                } else {
                    listFood.remove("Bakso");
                    //bakso ="";
                }
                break;
            case R.id.checkbox_tiga:
                if (isChecked) {
                    listFood.add("Mie Ayam");
                    //mieAyam= " Mie Ayam";
                } else {
                    listFood.remove("Mie Ayam");
                    //mieAyam ="";
                }
                break;
            case R.id.switch_satu:
                Log.d("MainAct testSwitch", "" + isChecked);
                break;
            case R.id.tb_satu:
                Log.d("MainAct testToggle", "" + isChecked);
                break;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        citySelect = citySpinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

