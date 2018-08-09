package com.miftah.asyst.formmiftah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.miftah.asyst.formmiftah.utility.Constant;

public class ResultActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = findViewById(R.id.text_view_reslult);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            textViewResult.setText(bundle.getString(Constant.KEY_RESULT));
        }

    }
}
