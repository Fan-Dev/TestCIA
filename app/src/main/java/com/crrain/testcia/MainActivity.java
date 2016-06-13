package com.crrain.testcia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.ciaapp.sdk.CIAService;
import cn.ciaapp.sdk.VerificationListener;

public class MainActivity extends AppCompatActivity {

    EditText et_phone_num, et_sms_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_phone_num = (EditText) findViewById(R.id.et_phone_num);
        et_sms_code = (EditText) findViewById(R.id.et_sms_code);

        findViewById(R.id.btn_getsmscode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CIAService.startVerification(et_phone_num.getText().toString(), "测试", new VerificationListener() {
                    @Override
                    public void onStateChange(int i, String s, String s1) {
                        Toast.makeText(MainActivity.this,"securityCode"+CIAService.getSecurityCode(),Toast.LENGTH_SHORT).show();
                        Log.d("aaa", i + "<startVerification-onStateChange>" + s + "," + s1);
                    }
                });
            }
        });

        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CIAService.verifySecurityCode(et_sms_code.getText().toString(), new VerificationListener() {
                    @Override
                    public void onStateChange(int i, String s, String s1) {
                        Log.d("aaa", i + "<verifySecurityCode-onStateChange>" + s + "," + s1);
                    }
                });
            }
        });
    }
}
